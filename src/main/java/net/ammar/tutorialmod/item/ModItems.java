package net.ammar.tutorialmod.item;

import net.ammar.tutorialmod.TutorialMod;
import net.ammar.tutorialmod.item.custom.MetalDetectorItem;
import net.ammar.tutorialmod.item.custom.ShikoWandItem;
import net.ammar.tutorialmod.tags.ModTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
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

    public static final DeferredItem<Item> SHIKO_WAND = ITEMS.registerItem("shiko_wand", properties ->
            new ShikoWandItem(properties
                    .durability(500)
                    .enchantable(20)));

    public static final DeferredItem<Item> AMMARITO_SWORD = ITEMS.registerItem("ammarito_sword", properties ->
            new Item(properties.sword(ModToolTiers.AMMARITO, 4 ,-2.4f)));
    public static final DeferredItem<Item> AMMARITO_PICKAXE = ITEMS.registerItem("ammarito_pickaxe", properties ->
            new Item(properties.pickaxe(ModToolTiers.AMMARITO, 3 ,-2.8f)));
    public static final DeferredItem<Item> AMMARITO_AXE = ITEMS.registerItem("ammarito_axe", properties ->
            new AxeItem(ModToolTiers.AMMARITO, 6 ,-3f, properties));
    public static final DeferredItem<Item> AMMARITO_SHOVEL = ITEMS.registerItem("ammarito_shovel", properties ->
            new ShovelItem(ModToolTiers.AMMARITO, 1.5f ,-3f, properties));
    public static final DeferredItem<Item> AMMARITO_HOE = ITEMS.registerItem("ammarito_hoe", properties ->
            new HoeItem(ModToolTiers.AMMARITO, 0 ,-3F, properties));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
