package net.watchbox.yuletide.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.watchbox.yuletide.cca.SnowedPlayerComponent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    @Shadow
    protected abstract void renderOverlay(DrawContext context, Identifier texture, float opacity);

    @Shadow
    @Final
    private static Identifier POWDER_SNOW_OUTLINE;

    @Inject(method = "renderMiscOverlays", at = @At("TAIL"))
    private void snowOverlay(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null) {
            if (SnowedPlayerComponent.KEY.get(player).snowedTicks > 0) {
                int snowedTicks = SnowedPlayerComponent.KEY.get(player).snowedTicks;
                if (snowedTicks > 0) {
                    float opacity = snowedTicks > 50 ? 1f : snowedTicks / 50.0f;
                    this.renderOverlay(context, POWDER_SNOW_OUTLINE, opacity);
                }
            }
        }
    }
}
