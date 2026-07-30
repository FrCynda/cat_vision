package net.marios271.cat_vision;

import net.marios271.cat_vision.config.ConfigData;
import net.marios271.cat_vision.platform.Platform;

import net.minecraft.resources.ResourceLocation;
//? >=1.18 {
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 *///?} else {
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//?}

//? fabric {
import net.marios271.cat_vision.platform.fabric.FabricPlatform;
//?} neoforge {
/*import net.marios271.cat_vision.platform.neoforge.NeoforgePlatform;
 *///?} forge {
/*import net.marios271.cat_vision.platform.forge.ForgePlatform;
 *///?}

import java.io.File;

@SuppressWarnings("LoggingSimilarMessage")
public class CatVision {

	public static final String MOD_ID = /*$ mod_id*/ "cat_vision";
	public static final String MOD_VERSION = /*$ mod_version*/ "3.0.0";
	public static final String MOD_FRIENDLY_NAME = /*$ mod_name*/ "CatVision";
	//? >=1.18 {
	/*public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	 *///?} else {
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	//?}

	private static final Platform PLATFORM = createPlatformInstance();

	public static final String CONFIG_FILE = "cat_vision.json";
	public static ConfigData CONFIG;

	public static void onInitializeClient(File configDir) {
		LOGGER.info("Initializing {} Client on {}", MOD_ID, CatVision.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);

		CONFIG = ConfigData.load(configDir);
	}

	static Platform xplat() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		return new FabricPlatform();
		//?} neoforge {
		/*return new NeoforgePlatform();
		 *///?} forge {
		/*return new ForgePlatform();
		 *///?}
	}

	private static ResourceLocation id(String path) {
		//? > 1.19.2 {
		/*return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
		 *///?} <= 1.19.2 {
		return new ResourceLocation(MOD_ID, path);
		//?}
	}

	private static ResourceLocation id(String namespace, String path) {
		//? > 1.19.2 {
		/*return ResourceLocation.fromNamespaceAndPath(namespace, path);
		 *///?} <= 1.19.2 {
		return new ResourceLocation(namespace, path);
		//?}
	}
}
