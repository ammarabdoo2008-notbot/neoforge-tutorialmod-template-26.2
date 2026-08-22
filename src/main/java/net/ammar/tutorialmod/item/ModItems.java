package net.ammar.tutorialmod.item;

import net.ammar.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> AMMARITO = ITEMS.registerSimpleItem("ammarito");
    public static final DeferredItem<Item> RAW_AMMARITO = ITEMS.registerSimpleItem("raw_ammarito");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
