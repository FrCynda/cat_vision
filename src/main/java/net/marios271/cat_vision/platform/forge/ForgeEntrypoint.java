package net.marios271.cat_vision.platform.forge;

//? forge {

/*import net.marios271.cat_vision.CatVision;
import net.marios271.cat_vision.config.ConfigScreen;
import net.marios271.cat_vision.event.DisconnectListener;
import net.marios271.cat_vision.event.EndTickListener;
import net.marios271.cat_vision.event.JoinListener;
import net.marios271.cat_vision.event.RespawnListener;
import net.marios271.cat_vision.handler.KeyInputHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
//? < 1.17.1 {
/^import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.client.registry.ClientRegistry;
^///?} 1.17.1 {
/^import net.minecraftforge.fmlclient.ConfigGuiHandler;
import net.minecraftforge.fmlclient.registry.ClientRegistry;
^///?} >= 1.18 {
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.ConfigGuiHandler;
//?}

@Mod(CatVision.MOD_ID)
public class ForgeEntrypoint {

	public ForgeEntrypoint() {
		CatVision.onInitializeClient(FMLPaths.CONFIGDIR.get().toFile());

		//? < 1.17.1 {
		/^ModLoadingContext.get().registerExtensionPoint(
				ExtensionPoint.CONFIGGUIFACTORY,
				() -> (mc, parent) -> ConfigScreen.create(parent, CatVision.CONFIG)
		);
		^///?} 1.17.1 {
		/^ModLoadingContext.get().registerExtensionPoint(
				ConfigGuiHandler.ConfigGuiFactory.class,
				() -> new ConfigGuiHandler.ConfigGuiFactory(
						(mc, parent) -> ConfigScreen.create(parent, CatVision.CONFIG))
		);
		^///?} >= 1.18 {
		ModLoadingContext.get().registerExtensionPoint(
				ConfigGuiHandler.ConfigGuiFactory.class,
				() -> new ConfigGuiHandler.ConfigGuiFactory(
						(mc, parent) -> ConfigScreen.create(parent, CatVision.CONFIG))
		);
		//?}

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void onClientSetup(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(KeyInputHandler.toggleNightVisionKey);
		ClientRegistry.registerKeyBinding(KeyInputHandler.openConfigKey);
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
	public void onPlayerLoggedIn(ClientPlayerNetworkEvent.LoggedInEvent event) {
		JoinListener.onJoin(Minecraft.getInstance());
	}

	@SubscribeEvent
	public void onPlayerLoggedOut(ClientPlayerNetworkEvent.LoggedOutEvent event) {
		DisconnectListener.onDisconnect();
	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		RespawnListener.onEntityLoad(event.getEntity());
	}
}
*///?}
