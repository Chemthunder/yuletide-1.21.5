package net.watchbox.yuletide.cca;

import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.watchbox.yuletide.Yuletide;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;

public class SnowedPlayerComponent implements AutoSyncedComponent, CommonTickingComponent {
    public static final ComponentKey<SnowedPlayerComponent> KEY = ComponentRegistry.getOrCreate(Yuletide.id("snowed"), SnowedPlayerComponent.class);
    private final LivingEntity player;
    public int snowedTicks = 0;

    public SnowedPlayerComponent(LivingEntity player) {
        this.player = player;
    }

    public void sync() {
        KEY.sync(this.player);
    }

    @Override
    public void tick() {
        if (snowedTicks > 0) {
            snowedTicks--;
            if (snowedTicks == 0) {
                sync();
            }
        }
    }

    @Override
    public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        this.snowedTicks = nbtCompound.getInt("snowedTicks", 0);
    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        nbtCompound.putInt("snowedTicks", snowedTicks);
    }
}
