package net.ammar.tutorialmod.item.custom;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

import java.util.function.Predicate;

public class BoweyItem extends BowItem {
    public static final Predicate<ItemStack> AXES_ONLY = itemStack -> itemStack.is(ItemTags.AXES);

    public BoweyItem(Properties properties) {
        super(properties);
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return AXES_ONLY;
    }
}
