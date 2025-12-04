package net.watchbox.yuletide.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SteamGiftcardItem extends Item {
    public SteamGiftcardItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.sendMessage(Text.translatable("text.error.steam_giftcard").formatted(Formatting.DARK_RED), true);
        user.playSoundToPlayer(SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.PLAYERS, 1, 1);
        return super.use(world, user, hand);
    }
}
