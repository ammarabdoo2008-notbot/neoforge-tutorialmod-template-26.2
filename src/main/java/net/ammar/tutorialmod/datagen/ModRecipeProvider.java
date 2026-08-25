package net.ammar.tutorialmod.datagen;

import net.ammar.tutorialmod.TutorialMod;
import net.ammar.tutorialmod.block.ModBlocks;
import net.ammar.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "TutorialMod Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMMARITO_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AMMARITO.get())
                .unlockedBy(getHasName(ModItems.AMMARITO.get()), has(ModItems.AMMARITO))
                .group("ammarito")
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_AMMARITO_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_AMMARITO.get())
                .unlockedBy(getHasName(ModItems.RAW_AMMARITO.get()), has(ModItems.RAW_AMMARITO))
                .group("ammarito")
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AMMARITO_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.AMMARITO.get())
                .unlockedBy(getHasName(ModItems.AMMARITO.get()), has(ModItems.AMMARITO))
                .group("ammarito")
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AMMARITO_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AMMARITO.get())
                .unlockedBy(getHasName(ModItems.AMMARITO.get()), has(ModItems.AMMARITO))
                .group("ammarito")
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AMMARITO_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.AMMARITO.get())
                .unlockedBy(getHasName(ModItems.AMMARITO.get()), has(ModItems.AMMARITO))
                .group("ammarito")
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AMMARITO_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.AMMARITO.get())
                .unlockedBy(getHasName(ModItems.AMMARITO.get()), has(ModItems.AMMARITO))
                .group("ammarito")
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AMMARITO_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("S")
                .define('A', ModItems.AMMARITO.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.AMMARITO.get()), has(ModItems.AMMARITO))
                .group("ammarito")
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AMMARITO_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AMMARITO.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.AMMARITO.get()), has(ModItems.AMMARITO))
                .group("ammarito")
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AMMARITO_AXE.get())
                .pattern("AA")
                .pattern("SA")
                .pattern("S ")
                .define('A', ModItems.AMMARITO.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.AMMARITO.get()), has(ModItems.AMMARITO))
                .group("ammarito")
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AMMARITO_SHOVEL.get())
                .pattern("A")
                .pattern("S")
                .pattern("S")
                .define('A', ModItems.AMMARITO.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.AMMARITO.get()), has(ModItems.AMMARITO))
                .group("ammarito")
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AMMARITO_HOE.get())
                .pattern("AA")
                .pattern("S ")
                .pattern("S ")
                .define('A', ModItems.AMMARITO.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.AMMARITO.get()), has(ModItems.AMMARITO))
                .group("ammarito")
                .save(output);

        shaped(RecipeCategory.MISC, ModItems.METAL_DETECTOR.get())
                .pattern("IGI")
                .pattern("IRI")
                .pattern("ICI")
                .define('I', Items.IRON_INGOT)
                .define('R', Items.REDSTONE)
                .define('C', Items.CLOCK)
                .define('G', Items.GLASS)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .group("ammars custom gadgets")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.AMMARITO.get(), 9)
                .requires(ModBlocks.AMMARITO_BLOCK)
                .unlockedBy(getHasName(ModBlocks.AMMARITO_BLOCK.get()), has(ModBlocks.AMMARITO_BLOCK))
                .group("ammarito")
                .save(output);


        List<ItemLike> AMMARITO_SMELTABLES = List.of(ModItems.RAW_AMMARITO, ModBlocks.AMMARITO_ORE);

        oreSmelting(AMMARITO_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.AMMARITO.get(), 0.25f, 200, "ammarito");
        oreBlasting(AMMARITO_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.AMMARITO.get(), 0.50f, 100, "ammarito");


    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, TutorialMod.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}