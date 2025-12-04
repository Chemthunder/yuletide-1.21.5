package net.watchbox.yuletide;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.watchbox.yuletide.init.YuletideBlocks;
import net.watchbox.yuletide.init.YuletideItemGroups;
import net.watchbox.yuletide.init.YuletideItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Yuletide implements ModInitializer {
	public static final String MOD_ID = "yuletide";

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        YuletideItems.init();
        YuletideItemGroups.init();
        YuletideBlocks.init();

		if (FabricLoader.getInstance().isDevelopmentEnvironment()) LOGGER.info("Mod is initalized");
	}
}