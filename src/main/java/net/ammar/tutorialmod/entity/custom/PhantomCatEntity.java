package net.ammar.tutorialmod.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.feline.Cat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class PhantomCatEntity extends PathfinderMob {
    public PhantomCatEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }



    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.TEMPT_RANGE, 10.D)
                .add(Attributes.FOLLOW_RANGE, 11.0D);



    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.5F));
        this.goalSelector.addGoal(2, new TemptGoal(
                this, 1.2d , itemStack -> itemStack.is(Items.PHANTOM_MEMBRANE), false  ));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.4d));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1d));
    }

    public static final EntityDataAccessor<Integer> MY_DATA =
            SynchedEntityData.defineId(
                    // The class of the entity.
                    PhantomCatEntity.class,
                    // The entity data accessor type.
                    EntityDataSerializers.INT

            );

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(MY_DATA, 0);
    }


    public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
        return false;
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {

    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {

    }
}

