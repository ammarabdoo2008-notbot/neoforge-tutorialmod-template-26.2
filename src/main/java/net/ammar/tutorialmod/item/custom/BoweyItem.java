package net.ammar.tutorialmod.item.custom;

import net.ammar.tutorialmod.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;


import java.util.List;
import java.util.function.Predicate;

public class BoweyItem extends BowItem {
    public static final Predicate<ItemStack> AXE_AMMO = stack -> stack.is(ModItems.AMMARITO_AXE.get());

    public BoweyItem(Properties props) {
        super(props);
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return AXE_AMMO;
    }

    @Override
    public boolean releaseUsing(ItemStack itemStack, Level level, LivingEntity entity, int remainingTime) {
        if (entity instanceof Player player) {
            ItemStack projectile = player.getProjectile(itemStack);
            if (projectile.isEmpty()) {
                return false;
            }

            int timeHeld = this.getUseDuration(itemStack, entity) - remainingTime;
            timeHeld = net.neoforged.neoforge.event.EventHooks.onArrowLoose(itemStack, level, player, timeHeld, !projectile.isEmpty());
            if (timeHeld < 0) return false;
            float pow = getPowerForTime(timeHeld);
            if (pow < 0.1) {
                return false;
            }

            List<ItemStack> firedProjectiles = draw(itemStack, projectile, player);
            if (level instanceof ServerLevel serverLevel && !firedProjectiles.isEmpty()) {
                this.shoot(serverLevel, player, player.getUsedItemHand(), itemStack, firedProjectiles, pow * 50.0F, 0, pow == 500.0F, null);
            }

            level.playSound(
                    null,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    SoundEvents.ARROW_SHOOT,
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + pow * 0.5F
            );
            player.awardStat(Stats.ITEM_USED.get(this));
            return true;
        } else {
            return false;
        }
    }

}
