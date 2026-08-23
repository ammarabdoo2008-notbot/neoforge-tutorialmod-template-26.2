package net.ammar.tutorialmod.item;

import net.ammar.tutorialmod.TutorialMod;
import net.ammar.tutorialmod.item.custom.MetalDetectorItem;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> AMMARITO = ITEMS.registerSimpleItem("ammarito");
    public static final DeferredItem<Item> RAW_AMMARITO = ITEMS.registerSimpleItem("raw_ammarito");

    public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.registerItem("metal_detector" ,
            properties -> new MetalDetectorItem(properties
                    .durability(200)
                    .enchantable(20)
                    .repairable(Tags.Items.INGOTS_IRON)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
