package net.ammar.tutorialmod.item;

import com.google.common.collect.Maps;
import net.ammar.tutorialmod.TutorialMod;
import net.ammar.tutorialmod.tags.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.Map;

public class ModArmorMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> AMMARITO_KEY = ResourceKey.create(ROOT_ID, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "ammarito"));

    public static final ArmorMaterial AMMARITO_ARMOR_MATERIAL    = new ArmorMaterial(1200,
            makeDefense(6, 7, 9, 5, 11), 16, SoundEvents.ARMOR_EQUIP_COPPER,
            2f, 0.1f, ModTags.Items.AMMARITO_REPAIRABLE, AMMARITO_KEY);


    private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
        return Maps.newEnumMap(
                Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body)
        );
    }
}