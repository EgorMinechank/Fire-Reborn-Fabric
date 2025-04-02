package net.em.firereborn.util;

import net.em.firereborn.FireReborn;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_INFERIUM_TOOL = createTag("needs_inferium_tool");
        public static final TagKey<Block> INCORRECT_FOR_INFERIUM_TOOL = createTag("incorrect_for_inferium_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(FireReborn.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(FireReborn.MOD_ID, name));
        }
    }
}
