package net.ammar.tutorialmod.datagen;

import net.ammar.tutorialmod.TutorialMod;
import net.ammar.tutorialmod.block.ModBlocks;
import net.ammar.tutorialmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlocksTagProvider extends BlockTagsProvider {
    public ModBlocksTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TutorialMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
      tag(BlockTags.MINEABLE_WITH_PICKAXE)
              .add(ModBlocks.AMMARITO_BLOCK.getKey())
              .add(ModBlocks.AMMARITO_ORE.getKey())
              .add(ModBlocks.RAW_AMMARITO_BLOCK.getKey());

      tag(BlockTags.NEEDS_IRON_TOOL)
              .add(ModBlocks.RAW_AMMARITO_BLOCK.getKey())
              .add(ModBlocks.AMMARITO_ORE.getKey());

      tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
              .add(ModBlocks.AMMARITO_BLOCK.getKey());

      tag(ModTags.Blocks.METAL_DETECTABLES)
              .addTag(Tags.Blocks.ORES);

      tag(ModTags.Blocks.NEEDS_AMMARITO_TOOL)
              .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

      tag(ModTags.Blocks.INCORRECT_FOR_AMMARITO_TOOL)
              .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
              .remove(ModTags.Blocks.NEEDS_AMMARITO_TOOL);
    }
}
