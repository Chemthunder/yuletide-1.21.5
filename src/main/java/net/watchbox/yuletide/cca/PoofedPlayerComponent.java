package net.watchbox.yuletide.cca;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.watchbox.yuletide.Yuletide;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;

public class PoofedPlayerComponent implements AutoSyncedComponent, CommonTickingComponent {
    public static final ComponentKey<PoofedPlayerComponent> KEY = ComponentRegistry.getOrCreate(Yuletide.id("poofed"), PoofedPlayerComponent.class);
    private final PlayerEntity player;
    public int poofedTicks = 0;

    public PoofedPlayerComponent(PlayerEntity player) {
        this.player = player;
    }

    @Override
    public void tick() {
        if (poofedTicks > 0) {
            poofedTicks--;
            player.setInvisible(true);

            if (poofedTicks == 0) {
                sync();
            }
        } else {
            player.setInvisible(false);
        }
    }

    public void sync() {
        KEY.sync(this.player);
    }

    @Override
    public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        this.poofedTicks = nbtCompound.getInt("poofedTicks", 0);
    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        nbtCompound.putInt("poofedTicks", poofedTicks);
    }
}
