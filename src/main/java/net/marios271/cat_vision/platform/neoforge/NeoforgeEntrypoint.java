package net.marios271.cat_vision.platform.neoforge;

//? neoforge {

/*import net.marios271.cat_vision.CatVision;
import net.marios271.cat_vision.config.ConfigScreen;
import net.marios271.cat_vision.event.DisconnectListener;
import net.marios271.cat_vision.event.EndTickListener;
import net.marios271.cat_vision.event.JoinListener;
import net.marios271.cat_vision.event.RespawnListener;
import net.marios271.cat_vision.handler.KeyInputHandler;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.client.ConfigScreenHandler;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@Mod(CatVision.MOD_ID)
public class NeoforgeEntrypoint {

	public NeoforgeEntrypoint(IEventBus modBus, ModContainer modContainer) {
		CatVision.onInitializeClient(FMLPaths.CONFIGDIR.get().toFile());

		modContainer.registerExtensionPoint(
				ConfigScreenHandler.ConfigScreenFactory.class,
				() -> new ConfigScreenHandler.ConfigScreenFactory(
						(mc, parent) -> ConfigScreen.create(parent, CatVision.CONFIG))
		);

		modBus.addListener(this::onRegisterKeyMappings);

		NeoForge.EVENT_BUS.register(this);
	}

	private void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(KeyInputHandler.toggleNightVisionKey);
		event.register(KeyInputHandler.openConfigKey);
	}

	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		if (event.phase != TickEvent.Phase.END)
			return;
		Minecraft client = Minecraft.getInstance();
		EndTickListener.onEndTick(client);
		KeyInputHandler.onKeyTick(client);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(ClientPlayerNetworkEvent.LoggingIn event) {
		JoinListener.onJoin(Minecraft.getInstance());
	}

	@SubscribeEvent
	public void onPlayerLoggedOut(ClientPlayerNetworkEvent.LoggingOut event) {
		DisconnectListener.onDisconnect();
	}

	@SubscribeEvent
	public void onEntityJoinLevel(EntityJoinLevelEvent event) {
		RespawnListener.onEntityLoad(event.getEntity());
	}
}
*///?}
