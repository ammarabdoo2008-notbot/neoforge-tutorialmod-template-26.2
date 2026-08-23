package net.ammar.tutorialmod.datagen;

import net.ammar.tutorialmod.TutorialMod;
import net.ammar.tutorialmod.block.ModBlocks;
import net.ammar.tutorialmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.AMMARITO.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_AMMARITO.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.METAL_DETECTOR.get(), ModelTemplates.FLAT_ITEM);

        // Blocks

        blockModels.createTrivialCube(ModBlocks.AMMARITO_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.AMMARITO_ORE.get());
        blockModels.createTrivialCube(ModBlocks.RAW_AMMARITO_BLOCK.get());
    }
}
