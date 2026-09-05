package net.ammar.tutorialmod.entity.custom;

import net.ammar.tutorialmod.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AxeProjectile extends AbstractArrow {
    public AxeProjectile(EntityType<? extends AxeProjectile> type, LivingEntity shooter, Level level, ItemStack pickupItem, ItemStack firedFromWeapon) {
        super(type, shooter, level, pickupItem, firedFromWeapon);
    }

    public AxeProjectile(EntityType<? extends AxeProjectile> type, Level level) {
        super(type, level);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.AMMARITO_AXE.get()); // whatever your axe item is
    }
}