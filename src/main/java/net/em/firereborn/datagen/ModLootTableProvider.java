package net.em.firereborn.datagen;

import net.em.firereborn.block.ModBlocks;
import net.em.firereborn.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.INFERIUM_BLOCK);
        addDrop(ModBlocks.INFERIUM_ORE, multipleOreDrops(ModBlocks.INFERIUM_ORE, ModItems.RAW_INFERIUM, 1, 3));
        addDrop(ModBlocks.INFERIUM_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.INFERIUM_DEEPSLATE_ORE, ModItems.RAW_INFERIUM, 1, 3));
        addDrop(ModBlocks.RAW_INFERIUM_BLOCK);
        addDrop(ModBlocks.BURNER_BLOCK);

        addDrop(ModBlocks.INFERIUM_STAIRS);
        addDrop(ModBlocks.INFERIUM_SLAB, slabDrops(ModBlocks.INFERIUM_SLAB));

        addDrop(ModBlocks.INFERIUM_BUTTON);
        addDrop(ModBlocks.INFERIUM_PRESSURE_PLATE);

        addDrop(ModBlocks.INFERIUM_FENCE);
        addDrop(ModBlocks.INFERIUM_FENCE_GATE);
        addDrop(ModBlocks.INFERIUM_WALL);

        addDrop(ModBlocks.INFERIUM_DOOR, doorDrops(ModBlocks.INFERIUM_DOOR));
        addDrop(ModBlocks.INFERIUM_TRAPDOOR);

        addDrop(ModBlocks.INFERIUMED_LAMP);
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
