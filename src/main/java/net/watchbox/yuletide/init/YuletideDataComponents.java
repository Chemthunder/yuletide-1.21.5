package net.watchbox.yuletide.init;

import net.minecraft.component.ComponentType;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.watchbox.yuletide.Yuletide;
import org.jetbrains.annotations.NotNull;

import java.util.function.UnaryOperator;

public interface YuletideDataComponents {
    ComponentType<ItemStack> HELD_ITEM_PRESENT = register("held_item_present",
            builder -> builder.codec(ItemStack.CODEC));

    private static <T> ComponentType<T> register(String name, @NotNull UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Yuletide.id(name), builderOperator.apply(ComponentType.builder()).build());
    }

    static void init() {}
}
