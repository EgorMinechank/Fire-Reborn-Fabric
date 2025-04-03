package net.em.firereborn.item;

import net.em.firereborn.FireReborn;
import net.em.firereborn.item.custom.BurnerItem;
import net.em.firereborn.item.custom.HammerItem;
import net.em.firereborn.item.custom.ModArmorItem;
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

    public static final Item INFERIUM_HAMMER = registerItem("inferium_hammer",
            new HammerItem(ModToolMaterials.INFERIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.INFERIUM, 7f, -3.5f))));

    public static final Item INFERIUM_HELMET = registerItem("inferium_helmet",
            new ModArmorItem(ModArmorMaterials.INFERIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(35))){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    if(Screen.hasAltDown()) {
                        tooltip.add(Text.translatable("tooltip.firereborn.inferium_armor.alt.down"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.firereborn.inferium_armor"));
                    }

                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item INFERIUM_CHESTPLATE = registerItem("inferium_chestplate",
            new ModArmorItem(ModArmorMaterials.INFERIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(35))){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    if(Screen.hasAltDown()) {
                        tooltip.add(Text.translatable("tooltip.firereborn.inferium_armor.alt.down"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.firereborn.inferium_armor"));
                    }

                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item INFERIUM_LEGGINGS = registerItem("inferium_leggings",
            new ModArmorItem(ModArmorMaterials.INFERIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(35))){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    if(Screen.hasAltDown()) {
                        tooltip.add(Text.translatable("tooltip.firereborn.inferium_armor.alt.down"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.firereborn.inferium_armor"));
                    }

                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item INFERIUM_BOOTS = registerItem("inferium_boots",
            new ModArmorItem(ModArmorMaterials.INFERIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(35))){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    if(Screen.hasAltDown()) {
                        tooltip.add(Text.translatable("tooltip.firereborn.inferium_armor.alt.down"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.firereborn.inferium_armor"));
                    }

                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item INFERIUM_HORSE_ARMOR = registerItem("inferium_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.INFERIUM_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FireReborn.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FireReborn.LOGGER.info("Registering Mod Items for " + FireReborn.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

        });
    }
}
