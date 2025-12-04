package net.watchbox.yuletide.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.watchbox.yuletide.init.YuletideCriterions;

public class MistletoeBlock extends Block {
    public MistletoeBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        if (entity instanceof ServerPlayerEntity serverPlayer) {
            YuletideCriterions.UNDER_MISTLETOE.trigger(serverPlayer);
        }
        super.onEntityCollision(state, world, pos, entity, handler);
    }
    /*
    todo: make mistletoe grant advancement while UNDER mistletoe
     */
}
