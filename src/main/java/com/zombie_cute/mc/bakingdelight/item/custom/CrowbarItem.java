package com.zombie_cute.mc.bakingdelight.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.zombie_cute.mc.bakingdelight.sound.ModSounds;
import com.zombie_cute.mc.bakingdelight.tag.ModTagKeys;
import com.zombie_cute.mc.bakingdelight.util.ToolTips;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CrowbarItem extends ToolItem {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public static final Set<Enchantment> ALLOWED_ENCHANTMENTS = Set.of(Enchantments.SHARPNESS,
            Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.KNOCKBACK, Enchantments.FIRE_ASPECT, Enchantments.LOOTING,
            Enchantments.UNBREAKING, Enchantments.EFFICIENCY);
    public CrowbarItem(ToolMaterial material, float attackDamage, float attackSpeed) {
        super(material, new FabricItemSettings());
        float attackDamage1 = attackDamage + material.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                        "Weapon modifier", attackDamage1, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED,
                new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                        "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        if(Screen.hasShiftDown()){
            MutableText mutableText = Text.translatable(ToolTips.SHIFT_FRONT).formatted(Formatting.DARK_GRAY);
            mutableText.append(Text.literal("[SHIFT]")).formatted(Formatting.WHITE);
            mutableText.append(Text.translatable(ToolTips.SHIFT_END)).formatted(Formatting.DARK_GRAY);
            tooltip.add(mutableText);
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.translatable(ToolTips.CROWBAR).formatted(Formatting.GOLD));
        }else {
            MutableText mutableText = Text.translatable(ToolTips.SHIFT_FRONT).formatted(Formatting.DARK_GRAY);
            mutableText.append(Text.literal("[SHIFT]")).formatted(Formatting.GRAY);
            mutableText.append(Text.translatable(ToolTips.SHIFT_END)).formatted(Formatting.DARK_GRAY);
            tooltip.add(mutableText);
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        List<Block> blocks = new ArrayList<>();
        for (RegistryEntry<Block> registryEntry : Registries.BLOCK.iterateEntries(ModTagKeys.CROWBAR_DESTROYABLE)){
            blocks.add(registryEntry.value());
        }
        if (blocks.contains(world.getBlockState(blockPos).getBlock())){
            context.getStack().damage(1, Objects.requireNonNull(context.getPlayer()),
                    (player) -> player.sendToolBreakStatus(player.getActiveHand()));
            if (world.random.nextDouble() < 0.3){
                world.playSound(blockPos.getX(),blockPos.getY(),blockPos.getZ(),
                        ModSounds.ITEM_CROWBAR_HIT,
                        SoundCategory.BLOCKS,
                        0.3f, world.random.nextFloat()+1.7f,true);
                world.breakBlock(blockPos, true, context.getPlayer());
            } else {
                world.playSound(blockPos.getX(),blockPos.getY(),blockPos.getZ(),
                        ModSounds.ITEM_CROWBAR_HIT,
                        SoundCategory.BLOCKS,
                        0.3f, world.random.nextFloat()+1.2f,true);
            }
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAIL;
        }
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(3, attacker, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(2, miner, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        return true;
    }
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }
}
