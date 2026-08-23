package net.ammar.tutorialmod.datagen;

import net.ammar.tutorialmod.TutorialMod;
import net.ammar.tutorialmod.item.ModItems;
import net.ammar.tutorialmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TutorialMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ModTags.Items.AMMARITO_REPAIRABLE)
                .add(ModItems.AMMARITO.getKey());

        tag(ItemTags.SWORDS).add(ModItems.AMMARITO_SWORD.getKey());
        tag(ItemTags.PICKAXES).add(ModItems.AMMARITO_PICKAXE.getKey());
        tag(ItemTags.SHOVELS).add(ModItems.AMMARITO_SHOVEL.getKey());
        tag(ItemTags.AXES).add(ModItems.AMMARITO_AXE.getKey());
        tag(ItemTags.HOES).add(ModItems.AMMARITO_HOE.getKey());

    }
}