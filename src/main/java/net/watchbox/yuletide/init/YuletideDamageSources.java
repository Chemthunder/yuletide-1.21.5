package net.watchbox.yuletide.init;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.watchbox.yuletide.Yuletide;

public interface YuletideDamageSources {
    RegistryKey<DamageType> SNOWBALL_HIT = of("snowball_hit");

    static DamageSource snowball_hit(LivingEntity entity) {
        return entity.getDamageSources().create(SNOWBALL_HIT);
    }

    private static RegistryKey<DamageType> of(String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Yuletide.id(name));
    }
}
