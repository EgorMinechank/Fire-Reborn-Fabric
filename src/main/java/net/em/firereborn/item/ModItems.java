package net.em.firereborn.item;

import net.em.firereborn.FireReborn;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item INFERIUM = registerItem("inferium", new Item(new Item.Settings()));
    public static final Item RAW_INFERIUM = registerItem("raw_inferium", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FireReborn.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FireReborn.LOGGER.info("Registering Mod Items for " + FireReborn.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

        });
    }
}
