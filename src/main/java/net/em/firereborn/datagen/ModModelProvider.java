package net.em.firereborn.datagen;

import net.em.firereborn.block.ModBlocks;
import net.em.firereborn.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BURNER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INFERIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INFERIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INFERIUM_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_INFERIUM_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.INFERIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_INFERIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOT_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BURNER, Models.GENERATED);
    }
}
