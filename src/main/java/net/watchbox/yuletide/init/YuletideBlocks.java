package net.watchbox.yuletide.init;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.watchbox.yuletide.Yuletide;
import net.watchbox.yuletide.block.MistletoeBlock;

import java.util.function.Function;

public interface YuletideBlocks {
    Block MISTLETOE = createWithItem("mistletoe", MistletoeBlock::new, AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
            .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
    );

    static Block create(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return Blocks.register(RegistryKey.of(RegistryKeys.BLOCK, Yuletide.id(name)), factory, settings);
    }

    // Create and Register with an item, always
    static Block createWithItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = create(name, factory, settings);
        YuletideItems.create(name, itemSettings -> new BlockItem(block, itemSettings), new Item.Settings().useBlockPrefixedTranslationKey());

        return block;
    }

    static void init() {
        // a
    }

    static void clientInit() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                MISTLETOE
        );
    }
}
