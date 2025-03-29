package net.em.firereborn.blocks;

import net.em.firereborn.FireReborn;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
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
