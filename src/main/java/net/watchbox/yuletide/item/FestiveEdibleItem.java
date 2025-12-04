package net.watchbox.yuletide.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.watchbox.yuletide.init.YuletideItems;

public class FestiveEdibleItem extends Item {
    public FestiveEdibleItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (stack.isOf(YuletideItems.CANDY_CANE)) {
            stack.decrement(1);
            if (user instanceof PlayerEntity player) {
                player.giveItemStack(YuletideItems.SHARPENED_CANDY_CANE.getDefaultStack());
            }
        }

        return super.finishUsing(stack, world, user);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (stack.isOf(YuletideItems.CANDY_CANE) || stack.isOf(YuletideItems.SHARPENED_CANDY_CANE)) {
            stack.decrement(1);
        }

        // break sfx and particles
        super.postHit(stack, target, attacker);
    }
}
