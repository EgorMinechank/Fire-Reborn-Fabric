package net.em.firereborn.item;

import net.em.firereborn.FireReborn;
import net.em.firereborn.item.custom.BurnerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.*;
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

    public static final Item INFERIUM_SWORD = registerItem("inferium_sword",
            new SwordItem(ModToolMaterials.INFERIUM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.INFERIUM, 3, -2.4f))));
    public static final Item INFERIUM_PICKAXE = registerItem("inferium_pickaxe",
            new PickaxeItem(ModToolMaterials.INFERIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.INFERIUM, 1.5f, -2.8f))));
    public static final Item INFERIUM_SHOVEL = registerItem("inferium_shovel",
            new ShovelItem(ModToolMaterials.INFERIUM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.INFERIUM, 1.0f, -3.0f))));
    public static final Item INFERIUM_AXE = registerItem("inferium_axe",
            new AxeItem(ModToolMaterials.INFERIUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.INFERIUM, 5.0f, -3.0f))));
    public static final Item INFERIUM_HOE = registerItem("inferium_hoe",
            new HoeItem(ModToolMaterials.INFERIUM, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.INFERIUM, 0, -3.0f))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FireReborn.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FireReborn.LOGGER.info("Registering Mod Items for " + FireReborn.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

        });
    }
}
