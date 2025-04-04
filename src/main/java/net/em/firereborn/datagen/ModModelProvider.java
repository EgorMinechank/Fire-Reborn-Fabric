package net.em.firereborn.datagen;

import net.em.firereborn.block.ModBlocks;
import net.em.firereborn.block.custom.InferiumLampBlock;
import net.em.firereborn.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BURNER_BLOCK);
        BlockStateModelGenerator.BlockTexturePool inferiumPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.INFERIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INFERIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INFERIUM_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_INFERIUM_BLOCK);

        inferiumPool.stairs(ModBlocks.INFERIUM_STAIRS);
        inferiumPool.slab(ModBlocks.INFERIUM_SLAB);

        inferiumPool.button(ModBlocks.INFERIUM_BUTTON);
        inferiumPool.pressurePlate(ModBlocks.INFERIUM_PRESSURE_PLATE);

        inferiumPool.fence(ModBlocks.INFERIUM_FENCE);
        inferiumPool.fenceGate(ModBlocks.INFERIUM_FENCE_GATE);
        inferiumPool.wall(ModBlocks.INFERIUM_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.INFERIUM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.INFERIUM_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.INFERIUMED_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.INFERIUMED_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.INFERIUMED_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(InferiumLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.INFERIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_INFERIUM, Models.GENERATED);

        itemModelGenerator.register(ModItems.HOT_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_APPLE, Models.GENERATED);

        //itemModelGenerator.register(ModItems.BURNER, Models.GENERATED);

        itemModelGenerator.register(ModItems.INFERIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERIUM_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.INFERIUM_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INFERIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INFERIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INFERIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INFERIUM_BOOTS));

        itemModelGenerator.register(ModItems.INFERIUM_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.INFERNUM_SMITHING_TEMPLATE, Models.GENERATED);
    }
}
