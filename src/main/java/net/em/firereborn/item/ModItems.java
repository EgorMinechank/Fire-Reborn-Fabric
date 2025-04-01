package net.em.firereborn.item;

import net.em.firereborn.FireReborn;
import net.em.firereborn.item.custom.BurnerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item INFERIUM = registerItem("inferium", new Item(new Item.Settings()));
    public static final Item RAW_INFERIUM = registerItem("raw_inferium", new Item(new Item.Settings()));

    public static final Item BURNER = registerItem("burner", new BurnerItem(new Item.Settings().maxDamage(48)));

    public static final Item FIRE_APPLE = registerItem("fire_apple", new Item(new Item.Settings().food(ModFoodComponents.FIREAPPLE)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if(Screen.hasAltDown()) {
                tooltip.add(Text.translatable("tooltip.firereborn.fire_apple.alt.down"));
            } else {
                tooltip.add(Text.translatable("tooltip.firereborn.fire_apple"));
            }

            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item HOT_COAL = registerItem("hot_coal", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if(Screen.hasAltDown()) {
                tooltip.add(Text.translatable("tooltip.firereborn.hot_coal.alt.down"));
            } else {
                tooltip.add(Text.translatable("tooltip.firereborn.hot_coal"));
            }

            super.appendTooltip(stack, context, tooltip, type);
        }
    });


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FireReborn.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FireReborn.LOGGER.info("Registering Mod Items for " + FireReborn.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

        });
    }
}
