package net.em.firereborn.datagen;

import net.em.firereborn.block.ModBlocks;
import net.em.firereborn.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.INFERIUM_ORE)
                .add(ModBlocks.INFERIUM_BLOCK)
                .add(ModBlocks.INFERIUM_DEEPSLATE_ORE)
                .add(ModBlocks.RAW_INFERIUM_BLOCK)
                .add(ModBlocks.BURNER_BLOCK)

                .add(ModBlocks.INFERIUM_STAIRS)
                .add(ModBlocks.INFERIUM_SLAB)

                .add(ModBlocks.INFERIUM_BUTTON)
                .add(ModBlocks.INFERIUM_PRESSURE_PLATE)

                .add(ModBlocks.INFERIUM_FENCE)
                .add(ModBlocks.INFERIUM_FENCE_GATE)
                .add(ModBlocks.INFERIUM_WALL)

                .add(ModBlocks.INFERIUM_DOOR)
                .add(ModBlocks.INFERIUM_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.INFERIUM_ORE)
                .add(ModBlocks.INFERIUM_BLOCK)
                .add(ModBlocks.INFERIUM_DEEPSLATE_ORE)
                .add(ModBlocks.BURNER_BLOCK)

                .add(ModBlocks.INFERIUM_STAIRS)
                .add(ModBlocks.INFERIUM_SLAB)

                .add(ModBlocks.INFERIUM_BUTTON)
                .add(ModBlocks.INFERIUM_PRESSURE_PLATE)

                .add(ModBlocks.INFERIUM_FENCE)
                .add(ModBlocks.INFERIUM_FENCE_GATE)
                .add(ModBlocks.INFERIUM_WALL)

                .add(ModBlocks.INFERIUM_DOOR)
                .add(ModBlocks.INFERIUM_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.INFERIUM_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.INFERIUM_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.INFERIUM_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_INFERIUM_TOOL)
                .add(ModBlocks.RAW_INFERIUM_BLOCK)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
    }
}
