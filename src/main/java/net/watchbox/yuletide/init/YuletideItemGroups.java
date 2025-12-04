package net.watchbox.yuletide.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.watchbox.yuletide.Yuletide;

public interface YuletideItemGroups {
    RegistryKey<ItemGroup> GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, Yuletide.id("yuletide"));
    ItemGroup YULETIDE_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(YuletideItems.CANDY_CANE))
            .displayName(Text.translatable("itemGroup.yuletide").styled(style -> style.withColor(0x62ffae)))
            .build();

    static void init() {
        Registry.register(Registries.ITEM_GROUP, GROUP_KEY, YULETIDE_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(GROUP_KEY).register(YuletideItemGroups::addEntries);

    }

    private static void addEntries(FabricItemGroupEntries i) {
        i.add(YuletideItems.FESTIVE_BELLS);
        i.add(YuletideItems.CANDY_CANE);
        i.add(YuletideItems.HOT_COCOA);
        i.add(YuletideItems.SPIRIT_POOFINATOR);
        i.add(YuletideItems.FESTIVE_COOKIE);
        i.add(YuletideBlocks.MISTLETOE);
        i.add(YuletideItems.GINGERBREAD);
        i.add(YuletideItems.GINGERBREAD_COOKIE);
    }
}
