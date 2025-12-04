package net.watchbox.yuletide.init;

import net.minecraft.advancement.criterion.Criterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.watchbox.yuletide.Yuletide;

import java.util.LinkedHashMap;
import java.util.Map;

public interface YuletideCriterions {
    Map<Criterion<?>, Identifier> CRITERIONS = new LinkedHashMap<>();

    TickCriterion UNDER_MISTLETOE = create("under_mistletoe", new TickCriterion());

    static <T extends Criterion<?>> T create(String name, T criterion) {
        CRITERIONS.put(criterion, Yuletide.id(name));
        return criterion;
    }

    static void init() {
        CRITERIONS.keySet().forEach(criterion -> {
            Registry.register(Registries.CRITERION, CRITERIONS.get(criterion), criterion);
        });
    }
}
