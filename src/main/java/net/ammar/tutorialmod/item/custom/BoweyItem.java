package net.ammar.tutorialmod.item.custom;


import net.ammar.tutorialmod.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

import java.util.function.Predicate;

public class BoweyItem extends ProjectileWeaponItem {

    public static final int MAX_DRAW_DURATION = 30;
    public static final int DEFAULT_RANGE = 20;
    public static final Predicate<ItemStack> AMMARITO_AXE_ONLY = itemStack -> itemStack.is(ModItems.AMMARITO_AXE.get());



    public BoweyItem(Properties properties) {
        super(properties);
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return AMMARITO_AXE_ONLY;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 20;
    }

    @Override
    protected void shootProjectile(LivingEntity shooter, Projectile projectileEntity, int index, float power, float uncertainty, float angle, @Nullable LivingEntity targetOverrride) {
        projectileEntity.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0f, power, uncertainty);
        shooter.level().addFreshEntity(projectileEntity);
    }

    public static float getPowerForTime(int timeHeld) {
        float pow = timeHeld / 20.0F;
        pow = (pow * pow + pow * 2.0F) / 3.0F;
        if (pow > 1.0F) {
            pow = 1.0F;
        }

        return pow;
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack itemStack) {
        return ItemUseAnimation.BOW;
    }

     @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        boolean foundProjectile = !player.getProjectile(itemStack).isEmpty();

        InteractionResult ret = net.neoforged.neoforge.event.EventHooks.onArrowNock(itemStack, level, player, hand, foundProjectile);
        if (ret != null) return ret;

        if (!player.hasInfiniteMaterials() && !foundProjectile) {
            return InteractionResult.FAIL;
        }

        player.startUsingItem(hand);
        return InteractionResult.CONSUME;
    }

}
