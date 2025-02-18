package net.yunion.alltheonions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.yunion.alltheonions.block.ModBlocks;
import net.yunion.alltheonions.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                //RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
                List<ItemConvertible> ONION_GEM_SMELTABLES = List.of(ModBlocks.ONION_GEM_ORE, ModBlocks.ONION_GEM_DEEPSLATE_ORE);
                List<ItemConvertible> ONION_CHARCOAL_SMELTABLES = List.of(ModBlocks.CRATE, ModItems.REGULAR_ONION);

                offerSmelting(ONION_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.ONION_GEM, 0.4f, 200,  "onion_gem");
                offerBlasting(ONION_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.ONION_GEM, 0.6f, 100,  "onion_gem");
                offerSmelting(ONION_CHARCOAL_SMELTABLES, RecipeCategory.MISC, ModItems.CHARCOAL_ONION, 0.2f, 200, "charcoal_onion");
                offerBlasting(ONION_CHARCOAL_SMELTABLES, RecipeCategory.MISC, ModItems.CHARCOAL_ONION, 0.4f, 100, "charcoal_onion");


                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.ONION_GEM, RecipeCategory.DECORATIONS, ModBlocks.ONION_GEM_BLOCK);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModItems.TUNING_FORK, ModBlocks.TUNER_BLOCK);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRATE)
                        .pattern("WSW")
                        .pattern("S S")
                        .pattern("WSW")
                        .input('W', ItemTags.PLANKS)
                        .input('S', Items.STICK)
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter);


                createDoorRecipe(ModBlocks.ONION_GEM_DOOR, Ingredient.ofItem(ModItems.ONION_GEM)).criterion(hasItem(ModItems.ONION_GEM), conditionsFromItem(ModItems.ONION_GEM)).offerTo(exporter);
                createTrapdoorRecipe(ModBlocks.ONION_GEM_TRAPDOOR, Ingredient.ofItem(ModItems.ONION_GEM)).criterion(hasItem(ModItems.ONION_GEM), conditionsFromItem(ModItems.ONION_GEM)).offerTo(exporter);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ONION_GEM_SLAB, Ingredient.ofItem(ModBlocks.ONION_GEM_BLOCK)).criterion(hasItem(ModItems.ONION_GEM), conditionsFromItem(ModItems.ONION_GEM)).offerTo(exporter);
                createButtonRecipe(ModBlocks.ONION_GEM_BUTTON, Ingredient.ofItem(ModItems.ONION_GEM)).criterion(hasItem(ModItems.ONION_GEM), conditionsFromItem(ModItems.ONION_GEM)).offerTo(exporter);
                createFenceRecipe(ModBlocks.ONION_GEM_FENCE, Ingredient.ofItem(ModItems.ONION_GEM)).criterion(hasItem(ModItems.ONION_GEM), conditionsFromItem(ModItems.ONION_GEM)).offerTo(exporter);
                createFenceGateRecipe(ModBlocks.ONION_GEM_FENCE_GATE, Ingredient.ofItem(ModItems.ONION_GEM)).criterion(hasItem(ModItems.ONION_GEM), conditionsFromItem(ModItems.ONION_GEM)).offerTo(exporter);
                createStairsRecipe(ModBlocks.ONION_GEM_STAIRS, Ingredient.ofItem(ModItems.ONION_GEM)).criterion(hasItem(ModItems.ONION_GEM), conditionsFromItem(ModItems.ONION_GEM)).offerTo(exporter);
                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.ONION_GEM_PRESSURE_PLATE, Ingredient.ofItem(ModItems.ONION_GEM)).criterion(hasItem(ModItems.ONION_GEM), conditionsFromItem(ModItems.ONION_GEM)).offerTo(exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ONION_GEM_WALL, ModItems.ONION_GEM);




            }
        };
    }


    @Override
    public String getName() {
        return "AllTheOnionsRecipeProvider";
    }
}
