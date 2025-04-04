package net.em.firereborn;

import net.em.firereborn.block.ModBlocks;
import net.em.firereborn.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class FireRebornClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INFERIUM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INFERIUM_TRAPDOOR, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();
    }
}
