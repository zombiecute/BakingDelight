package com.zombie_cute.mc.bakingdelight.item.custom;

import com.zombie_cute.mc.bakingdelight.tag.ModTagKeys;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WhiskItem extends MiningToolItem {
    public WhiskItem(float attackDamage, float attackSpeed, ToolMaterial material, TagKey<Block> effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, ModTagKeys.WHISK_MINEABLE, settings);
    }

    public static final String TOOL_TIP_0 = "tooltips.bakingdelight.tool_tip_0";
    public static final String WHISK_TOOL_TIP_1 = "tooltips.whisk_tool_tip_1";
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable(WHISK_TOOL_TIP_1).formatted(Formatting.AQUA));
        }else {
            tooltip.add(Text.translatable(TOOL_TIP_0).formatted(Formatting.GRAY));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
