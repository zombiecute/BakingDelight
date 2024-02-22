package com.zombie_cute.mc.bakingdelight;

import com.zombie_cute.mc.bakingdelight.block.ModBlocks;
import com.zombie_cute.mc.bakingdelight.entity.ModEntities;
import com.zombie_cute.mc.bakingdelight.screen.FreezerScreen;
import com.zombie_cute.mc.bakingdelight.screen.ModScreenHandlers;
import com.zombie_cute.mc.bakingdelight.screen.OvenScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class BakingdelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_BOWL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_PEPPER_CROP, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.BUTTER, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.CHERRY_BOMB, FlyingItemEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.OVEN_SCREEN_HANDLER_SCREEN_HANDLER, OvenScreen::new);
        HandledScreens.register(ModScreenHandlers.FREEZER_SCREEN_HANDLER_SCREEN_HANDLER, FreezerScreen::new);
    }
}
