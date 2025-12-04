package net.watchbox.yuletide;

import net.fabricmc.api.ClientModInitializer;
import net.watchbox.yuletide.init.YuletideBlocks;

public class YuletideClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        YuletideBlocks.clientInit();
    }
}
