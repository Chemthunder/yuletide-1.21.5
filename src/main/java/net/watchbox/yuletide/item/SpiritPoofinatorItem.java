package net.watchbox.yuletide.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.watchbox.yuletide.cca.PoofedPlayerComponent;

public class SpiritPoofinatorItem extends Item {
    public SpiritPoofinatorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!(PoofedPlayerComponent.KEY.get(user).poofedTicks > 0)) {
            PoofedPlayerComponent poofed = PoofedPlayerComponent.KEY.get(user);

            poofed.poofedTicks = 1200;
            poofed.sync();

            user.playSoundToPlayer(SoundEvents.BLOCK_BEACON_POWER_SELECT, SoundCategory.PLAYERS, 1, 1);


            if (world instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(ParticleTypes.POOF, user.getX(), user.getY() + 0.5f, user.getZ(), 15, 0, 0 + 0.5f, 0, 0.04);
                serverWorld.spawnParticles(ParticleTypes.SMOKE, user.getX(), user.getY() + 0.5f, user.getZ(), 15, 0, 0 + 0.5f, 0, 0.04);
            }
        }

        return super.use(world, user, hand);
    }
}
