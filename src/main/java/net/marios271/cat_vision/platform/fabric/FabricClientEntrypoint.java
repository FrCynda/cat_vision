package net.marios271.cat_vision.platform.fabric;

//? fabric {

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
//? < 26.1 {
/*import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
*///?} >= 26.1 {
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
//?}
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.marios271.cat_vision.CatVision;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;
import net.marios271.cat_vision.event.DisconnectListener;
import net.marios271.cat_vision.event.EndTickListener;
import net.marios271.cat_vision.event.JoinListener;
import net.marios271.cat_vision.event.RespawnListener;
import net.marios271.cat_vision.handler.KeyInputHandler;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		CatVision.onInitializeClient(FabricLoader.getInstance().getConfigDir().toFile());

		//? < 26.1 {
		/*KeyBindingHelper.registerKeyBinding(KeyInputHandler.toggleNightVisionKey);
		KeyBindingHelper.registerKeyBinding(KeyInputHandler.openConfigKey);
		*///?} >= 26.1 {
		KeyMappingHelper.registerKeyMapping(KeyInputHandler.toggleNightVisionKey);
		KeyMappingHelper.registerKeyMapping(KeyInputHandler.openConfigKey);
		//?}

		ClientTickEvents.END_CLIENT_TICK.register(EndTickListener::onEndTick);
		ClientTickEvents.END_CLIENT_TICK.register(KeyInputHandler::onKeyTick);
		ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> JoinListener.onJoin(client));
		ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> DisconnectListener.onDisconnect());
		ClientEntityEvents.ENTITY_LOAD.register((entity, world) -> RespawnListener.onEntityLoad(entity));
	}
}
//?}
