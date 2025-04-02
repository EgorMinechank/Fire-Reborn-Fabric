package net.em.firereborn.datagen;

import net.em.firereborn.item.ModItems;
import net.em.firereborn.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.AMETHYST_BLOCK)
                .add(Items.AMETHYST_SHARD)
                .add(Items.AMETHYST_CLUSTER);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.INFERIUM_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.INFERIUM_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.INFERIUM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.INFERIUM_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.INFERIUM_HOE);

    }
}
