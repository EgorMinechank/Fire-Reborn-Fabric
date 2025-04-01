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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_INFERIUM, 9)
                .input(ModBlocks.RAW_INFERIUM_BLOCK)
                .criterion(hasItem(ModItems.RAW_INFERIUM), conditionsFromItem(ModItems.RAW_INFERIUM))
                .offerTo(exporter, Identifier.of(FireReborn.MOD_ID, "raw_inferium_from_raw_inferium_block"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INFERIUM, 9)
                .input(ModBlocks.INFERIUM_BLOCK)
                .criterion(hasItem(ModItems.INFERIUM), conditionsFromItem(ModItems.INFERIUM))
                .offerTo(exporter, Identifier.of(FireReborn.MOD_ID, "inferium_from_inferium_block"));
    }
}
