package net.em.firereborn.block;

import net.em.firereborn.FireReborn;
import net.em.firereborn.block.custom.BurnerBlock;
import net.em.firereborn.block.custom.InferiumLampBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block INFERIUM_BLOCK = registerBlock("inferium_block",
            new Block(AbstractBlock.Settings.create().strength(5.0f, 6.0f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_INFERIUM_BLOCK = registerBlock("raw_inferium_block",
            new Block(AbstractBlock.Settings.create().strength(5.0f, 6.0f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block INFERIUM_ORE = registerBlock("inferium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4),
                    AbstractBlock.Settings.create().strength(3.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block INFERIUM_DEEPSLATE_ORE = registerBlock("inferium_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4),
                    AbstractBlock.Settings.create().strength(4.5f, 3.0f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block BURNER_BLOCK = registerBlock("burner_block",
            new BurnerBlock(AbstractBlock.Settings.create().strength(3.0f, 3.0f).requiresTool()));

    public static final Block INFERIUM_STAIRS = registerBlock("inferium_stairs",
            new StairsBlock(ModBlocks.INFERIUM_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(5.0f, 6.0f).requiresTool()));
    public static final Block INFERIUM_SLAB = registerBlock("inferium_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(5.0f, 6.0f).requiresTool()));

    public static final Block INFERIUM_BUTTON = registerBlock("inferium_button",
            new ButtonBlock(BlockSetType.IRON, 20, AbstractBlock.Settings.create().strength(5.0f, 6.0f).requiresTool().noCollision()));
    public static final Block INFERIUM_PRESSURE_PLATE = registerBlock("inferium_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(5.0f, 6.0f).requiresTool()));

    public static final Block INFERIUM_FENCE = registerBlock("inferium_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(5.0f, 6.0f).requiresTool()));
    public static final Block INFERIUM_FENCE_GATE = registerBlock("inferium_fence_gate",
            new FenceGateBlock(WoodType.BAMBOO, AbstractBlock.Settings.create().strength(5.0f, 6.0f).requiresTool()));
    public static final Block INFERIUM_WALL = registerBlock("inferium_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(5.0f, 6.0f).requiresTool()));

    public static final Block INFERIUM_DOOR = registerBlock("inferium_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(5.0f, 6.0f).requiresTool().nonOpaque()));
    public static final Block INFERIUM_TRAPDOOR = registerBlock("inferium_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(5.0f, 6.0f).requiresTool().nonOpaque()));

    public static final Block INFERIUMED_LAMP = registerBlock("inferiumed_lamp",
            new InferiumLampBlock(AbstractBlock.Settings.create()
                    .strength(0.3f, 0.3f).requiresTool().luminance(state -> state.get(InferiumLampBlock.CLICKED) ? 15 : 0)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FireReborn.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FireReborn.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        FireReborn.LOGGER.info("Registering Mod Blocks for " + FireReborn.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {

        });
    }
}
