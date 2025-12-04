package net.watchbox.yuletide.init;

import net.acoyt.acornlib.api.items.AcornItemSettings;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.watchbox.yuletide.Yuletide;
import net.watchbox.yuletide.item.*;

import java.util.function.Function;

public interface YuletideItems {
    Item HOT_COCOA = create("hot_cocoa", FestiveBeverageItem::new, new AcornItemSettings()
            .maxCount(1)
            .food(new FoodComponent.Builder()
                    .saturationModifier(1f)
                    .alwaysEdible()
                    .build(),
                    ConsumableComponent.builder()
                            .sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK)
                            .consumeParticles(false)
                            .build())
    );

    Item FESTIVE_COOKIE = create("festive_cookie", FestiveEdibleItem::new, new AcornItemSettings()
            .maxCount(16)
    );

    Item CANDY_CANE = create("candy_cane", FestiveEdibleItem::new, new AcornItemSettings()
            .maxCount(1)
            .food(new FoodComponent.Builder()
                    .alwaysEdible()
                    .nutrition(3)
                    .saturationModifier(1f)
                    .build()
            )
    );

    Item FESTIVE_BELLS = create("festive_bells", FestiveBellsItem::new, new AcornItemSettings()
            .maxCount(1)
    );

    Item SPIRIT_POOFINATOR = create("spirit_poofinator", SpiritPoofinatorItem::new, new AcornItemSettings()
            .maxCount(1)
    );

    Item GINGERBREAD = create("gingerbread", FestiveEdibleItem::new, new AcornItemSettings()
            .maxCount(16)
    );

    Item GINGERBREAD_COOKIE = create("gingerbread_cookie", FestiveEdibleItem::new, new AcornItemSettings()
            .maxCount(1)
    );

    Item SHARPENED_CANDY_CANE = create("sharpened_candy_cane", FestiveEdibleItem::new, new AcornItemSettings()
            .maxCount(1)
            .sword(ToolMaterial.NETHERITE, 1, -2.0f)
            .food(new FoodComponent.Builder()
                    .alwaysEdible()
                    .nutrition(3)
                    .saturationModifier(1f)
                    .build()
            )
    );

    Item PRESENT = create("present", PresentItem::new, new AcornItemSettings()
            .maxCount(1)
    );

    Item CHRISTMAS_COOKIE = create("christmas_cookie", FestiveEdibleItem::new, new AcornItemSettings()
            .maxCount(16)
            .food(new FoodComponent.Builder()
                    .nutrition(4)
                    .saturationModifier(6f)
                    .alwaysEdible()
                    .build())
    );


    Item GOLDEN_ORNAMENT = create("golden_ornament", OrnamentItem::new, new AcornItemSettings());
    Item FRAGRANT_ORNAMENT = create("fragrant_ornament", OrnamentItem::new, new AcornItemSettings());
    Item CRYSTALLINE_ORNAMENT = create("crystalline_ornament", OrnamentItem::new, new AcornItemSettings());
    Item FESTIVE_ORNAMENT = create("festive_ornament", OrnamentItem::new, new AcornItemSettings());



    // secret santa
    Item STEAM_GIFTCARD = create("steam_giftcard", SteamGiftcardItem::new, new AcornItemSettings()
            .maxCount(1)
    );

    Item SPEAK_N_SPELL = create("speak_n_spell", SpeakNSpellItem::new, new AcornItemSettings()
            .maxCount(1)
    );

    static Item create(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return Items.register(RegistryKey.of(RegistryKeys.ITEM, Yuletide.id(name)), factory, settings);
    }

    static void init() {
        // modifyItemNameColor(HOT_COCOA, );
    }
}
