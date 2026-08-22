package net.ammar.tutorialmod.datagen;

import net.ammar.tutorialmod.block.ModBlocks;
import net.ammar.tutorialmod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
       dropSelf(ModBlocks.AMMARITO_BLOCK.get());
       dropSelf(ModBlocks.RAW_AMMARITO_BLOCK.get());

       add(ModBlocks.AMMARITO_ORE.get(),
               createOreDrop(ModBlocks.AMMARITO_ORE.get(), ModItems.RAW_AMMARITO.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
