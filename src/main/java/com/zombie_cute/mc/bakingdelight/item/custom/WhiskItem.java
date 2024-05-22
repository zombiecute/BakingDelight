package com.zombie_cute.mc.bakingdelight.item.custom;

import com.zombie_cute.mc.bakingdelight.tag.ModTagKeys;
import com.zombie_cute.mc.bakingdelight.util.ToolTips;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class WhiskItem extends MiningToolItem {
    public WhiskItem(float attackDamage, float attackSpeed, ToolMaterial material, Settings settings) {
        super(attackDamage, attackSpeed, material, ModTagKeys.WHISK_MINEABLE, settings);
    }
    public static final Set<Enchantment> ALLOWED_ENCHANTMENTS = Set.of(Enchantments.VANISHING_CURSE, Enchantments.SHARPNESS,
            Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.KNOCKBACK, Enchantments.FIRE_ASPECT, Enchantments.LOOTING,
            Enchantments.UNBREAKING, Enchantments.EFFICIENCY, Enchantments.SILK_TOUCH, Enchantments.FORTUNE);
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        if(Screen.hasShiftDown()){
            tooltip.add(ToolTips.getShiftText(true));
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.translatable(ToolTips.WHISK_1).formatted(Formatting.GOLD));
            tooltip.add(Text.translatable(ToolTips.WHISK_2).formatted(Formatting.GOLD));
        }else {
            tooltip.add(ToolTips.getShiftText(false));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
