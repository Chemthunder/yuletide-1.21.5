package net.watchbox.yuletide.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.watchbox.yuletide.cca.SnowedPlayerComponent;
import net.watchbox.yuletide.init.YuletideDamageSources;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SnowballEntity.class)
public abstract class SnowballEntityMixin extends ThrownItemEntity {
    public SnowballEntityMixin(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    @WrapMethod(method = "onEntityHit")
    private void rewriteEntityHit(EntityHitResult entityHitResult, Operation<Void> original) {
        LivingEntity living = (LivingEntity) entityHitResult.getEntity();
        World world = living.getWorld();

        if (world instanceof ServerWorld serverWorld) {
            living.damage(serverWorld, YuletideDamageSources.snowball_hit((LivingEntity) this.getOwner()), 1.5f);
            SnowedPlayerComponent snowed = SnowedPlayerComponent.KEY.get(living);

            snowed.snowedTicks = 120;
            snowed.sync();
        }
    }
}
