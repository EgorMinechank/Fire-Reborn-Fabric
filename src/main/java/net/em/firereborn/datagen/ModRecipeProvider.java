package net.em.firereborn.datagen;

import net.em.firereborn.FireReborn;
import net.em.firereborn.block.ModBlocks;
import net.em.firereborn.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> INFERIUM_SMELTABLES = List.of(ModItems.RAW_INFERIUM, ModBlocks.INFERIUM_ORE, ModBlocks.INFERIUM_DEEPSLATE_ORE);

        offerSmelting(exporter, INFERIUM_SMELTABLES, RecipeCategory.MISC, ModItems.INFERIUM, 0.25f, 200, "inferium");
        offerBlasting(exporter, INFERIUM_SMELTABLES, RecipeCategory.MISC, ModItems.INFERIUM, 0.25f, 100, "inferium");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.INFERIUM, RecipeCategory.DECORATIONS, ModBlocks.INFERIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_INFERIUM, RecipeCategory.DECORATIONS, ModBlocks.RAW_INFERIUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BURNER_BLOCK)
                .pattern("AMS")
                .pattern("MIM")
                .pattern("SMC")
                .input('A', Items.AMETHYST_BLOCK).input('M', Items.MAGMA_BLOCK).input('S', Items.SEA_LANTERN).input('C', Items.CRYING_OBSIDIAN).input('I', ModBlocks.INFERIUM_BLOCK)
                .criterion(hasItem(ModItems.INFERIUM), conditionsFromItem(ModItems.INFERIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INFERIUM_STAIRS)
                .pattern("I  ")
                .pattern("II ")
                .pattern("III")
                .input('I', ModItems.INFERIUM)
                .criterion(hasItem(ModItems.INFERIUM), conditionsFromItem(ModItems.INFERIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INFERIUM_SLAB)
                .pattern("   ")
                .pattern("   ")
                .pattern("III")
                .input('I', ModItems.INFERIUM)
                .criterion(hasItem(ModItems.INFERIUM), conditionsFromItem(ModItems.INFERIUM))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.INFERIUM_BUTTON)
                .input(ModItems.INFERIUM)
                .criterion(hasItem(ModItems.INFERIUM), conditionsFromItem(ModItems.INFERIUM))
                        .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.INFERIUM_PRESSURE_PLATE)
                .pattern("   ")
                .pattern("   ")
                .pattern("II ")
                .input('I', ModItems.INFERIUM)
                .criterion(hasItem(ModItems.INFERIUM), conditionsFromItem(ModItems.INFERIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INFERIUM_FENCE)
                .pattern("   ")
                .pattern("ISI")
                .pattern("ISI")
                .input('I', ModItems.INFERIUM).input('S', Items.STICK)
                .criterion(hasItem(ModItems.INFERIUM), conditionsFromItem(ModItems.INFERIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INFERIUM_FENCE_GATE)
                .pattern("   ")
                .pattern("SIS")
                .pattern("SIS")
                .input('I', ModItems.INFERIUM).input('S', Items.STICK)
                .criterion(hasItem(ModItems.INFERIUM), conditionsFromItem(ModItems.INFERIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INFERIUM_WALL)
                .pattern("   ")
                .pattern("III")
                .pattern("III")
                .input('I', ModItems.INFERIUM)
                .criterion(hasItem(ModItems.INFERIUM), conditionsFromItem(ModItems.INFERIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.INFERIUM_DOOR)
                .pattern("II ")
                .pattern("II ")
                .pattern("II ")
                .input('I', ModItems.INFERIUM)
                .criterion(hasItem(ModItems.INFERIUM), conditionsFromItem(ModItems.INFERIUM))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.INFERIUM_TRAPDOOR)
                .pattern("   ")
                .pattern("III")
                .pattern("III")
                .input('I', ModItems.INFERIUM)
                .criterion(hasItem(ModItems.INFERIUM), conditionsFromItem(ModItems.INFERIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.INFERIUMED_LAMP)
                .pattern(" R ")
                .pattern("RIR")
                .pattern(" R ")
                .input('I', ModItems.INFERIUM).input('R', Items.REDSTONE_LAMP)
                .criterion(hasItem(ModItems.INFERIUM), conditionsFromItem(ModItems.INFERIUM))
                .offerTo(exporter);
    }
}
