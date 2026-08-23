package net.ammar.tutorialmod.creativemodetab;

import net.ammar.tutorialmod.TutorialMod;
import net.ammar.tutorialmod.block.ModBlocks;
import net.ammar.tutorialmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static final Supplier<CreativeModeTab> AMMARITO_ITEMS_TAB = CREATIVE_MODE_TABS.register("ammarito_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AMMARITO.get()))
                    .title(Component.translatable("creativetab.tutorialmod.ammarito_items"))
                   // .withTabsAfter(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, ""))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.AMMARITO);
                        output.accept(ModItems.RAW_AMMARITO);
                        output.accept(ModItems.METAL_DETECTOR);
                    })


                    .build());

    public static final Supplier<CreativeModeTab> AMMARITO_BLOCKS_TAB = CREATIVE_MODE_TABS.register("ammarito_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.AMMARITO_BLOCK.get()))
                    .title(Component.translatable("creativetab.tutorialmod.ammarito_items"))
                    //.withTabsAfter(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "ammarito_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.AMMARITO_BLOCK);
                        output.accept(ModBlocks.RAW_AMMARITO_BLOCK);
                        output.accept(ModBlocks.AMMARITO_ORE);
                    })


                    .build());

}
