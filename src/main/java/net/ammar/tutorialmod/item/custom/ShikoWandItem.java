package net.ammar.tutorialmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.feline.Cat;
import net.minecraft.world.entity.animal.feline.CatVariants;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ShikoWandItem extends Item {
    public ShikoWandItem(Properties properties) {
        super(properties);
    }
    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        if (!player.level().isClientSide()) {
            if (!(target instanceof Cat)) {
                Cat cat = EntityTypes.CAT.create(target.level(), EntitySpawnReason.MOB_SUMMONED);
                if (cat != null) {
                    cat.setPos(target.getX(), target.getY(), target.getZ());
                    cat.setYRot(target.getYRot());
                    cat.setXRot(target.getXRot());
                    cat.setCustomName(Component.literal("Shiko"));
                    cat.setCustomNameVisible(true);
                    target.level().addFreshEntity(cat);
                    target.discard();
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
}
