package net.em.firereborn.item;

import net.em.firereborn.FireReborn;
import net.em.firereborn.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FIRE_REBORN_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FireReborn.MOD_ID, "fire_reborn"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.INFERIUM))
                    .displayName(Text.translatable("itemgroup.firereborn.firereborn"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.INFERIUM);
                        entries.add(ModItems.RAW_INFERIUM);

                        entries.add(ModItems.BURNER);

                        entries.add(ModItems.FIRE_APPLE);

                        entries.add(ModItems.HOT_COAL);


                        entries.add(ModBlocks.INFERIUM_BLOCK);
                        entries.add(ModBlocks.RAW_INFERIUM_BLOCK);

                        entries.add(ModBlocks.INFERIUM_ORE);
                        entries.add(ModBlocks.INFERIUM_DEEPSLATE_ORE);

                        entries.add(ModBlocks.BURNER_BLOCK);
                    }).build());



    public static void registerItemGroups() {
        FireReborn.LOGGER.info("Registering Item Groups for " + FireReborn.MOD_ID);
    }
}
