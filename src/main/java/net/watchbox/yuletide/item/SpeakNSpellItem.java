package net.watchbox.yuletide.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SpeakNSpellItem extends Item {
    public SpeakNSpellItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.playSound(SoundEvents.BLOCK_COMPARATOR_CLICK);

        return super.use(world, user, hand);
    }
}
