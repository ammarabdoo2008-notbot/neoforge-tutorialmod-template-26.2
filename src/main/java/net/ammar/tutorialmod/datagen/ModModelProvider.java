package net.ammar.tutorialmod.datagen;

import net.ammar.tutorialmod.TutorialMod;
import net.ammar.tutorialmod.block.ModBlocks;
import net.ammar.tutorialmod.item.ModArmorMaterials;
import net.ammar.tutorialmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.AMMARITO.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_AMMARITO.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.METAL_DETECTOR.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        //itemModels.generateFlatItem(ModItems.SHIKO_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModels.generateFlatItem(ModItems.AMMARITO_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AMMARITO_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AMMARITO_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AMMARITO_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AMMARITO_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModels.generateTrimmableItem(ModItems.AMMARITO_HELMET.get(), ModArmorMaterials.AMMARITO_KEY, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModels.generateTrimmableItem(ModItems.AMMARITO_CHESTPLATE.get(), ModArmorMaterials.AMMARITO_KEY, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModels.generateTrimmableItem(ModItems.AMMARITO_LEGGINGS.get(), ModArmorMaterials.AMMARITO_KEY, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModels.generateTrimmableItem(ModItems.AMMARITO_BOOTS.get(), ModArmorMaterials.AMMARITO_KEY, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        itemModels.declareCustomModelItem(ModItems.SHIKO_WAND.get());

        itemModels.createFlatItemModel(ModItems.BOWEY.get(), ModelTemplates.BOW);
        itemModels.generateBow(ModItems.BOWEY.get());




        // Blocks

        blockModels.createTrivialCube(ModBlocks.AMMARITO_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.AMMARITO_ORE.get());
        blockModels.createTrivialCube(ModBlocks.RAW_AMMARITO_BLOCK.get());

        blockModels.createNonTemplateModelBlock(ModBlocks.PEDESTEL_BLOCK.get());
    }
}
