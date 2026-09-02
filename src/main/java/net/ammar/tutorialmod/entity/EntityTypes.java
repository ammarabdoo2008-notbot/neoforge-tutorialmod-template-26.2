package net.ammar.tutorialmod.entity;

import net.ammar.tutorialmod.TutorialMod;
import net.ammar.tutorialmod.entity.custom.FerretEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EntityTypes {

    public static final DeferredRegister.Entities ENTITY_TYPES =
            DeferredRegister.createEntities(TutorialMod.MOD_ID);

    public static final Supplier<EntityType<FerretEntity>> FERRET_ENTITY = ENTITY_TYPES.register(
            "ferret_entity",
            () -> EntityType.Builder.of(
                            FerretEntity::new,
                            MobCategory.MISC
                    )
                    .sized(1.0f, 1.0f)
                    .spawnDimensionsScale(4.0f)
                    .eyeHeight(0.5f)
                    .noSummon()
                    .fireImmune()
                    .canSpawnFarFromPlayer()
                    .clientTrackingRange(8)
                    .updateInterval(10)
                    .build(ResourceKey.create(
                            Registries.ENTITY_TYPE,
                            Identifier.fromNamespaceAndPath("tutorialmod", "ferret_entity")
                    ))
    );


}