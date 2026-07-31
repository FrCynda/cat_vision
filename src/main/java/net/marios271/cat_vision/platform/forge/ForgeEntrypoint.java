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
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
//? < 1.19 {
/^import net.minecraftforge.event.entity.EntityJoinWorldEvent;
^///?}
//? < 1.17.1 {
/^import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.client.registry.ClientRegistry;
^///?} 1.17.1 {
/^import net.minecraftforge.fmlclient.ConfigGuiHandler;
import net.minecraftforge.fmlclient.registry.ClientRegistry;
^///?} >= 1.18 && < 1.19 {
/^import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.ConfigGuiHandler;
^///?} >= 1.19 {
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
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
		^///?} >= 1.18 && < 1.19 {
		/^ModLoadingContext.get().registerExtensionPoint(
				ConfigGuiHandler.ConfigGuiFactory.class,
				() -> new ConfigGuiHandler.ConfigGuiFactory(
						(mc, parent) -> ConfigScreen.create(parent, CatVision.CONFIG))
		);
		^///?} >= 1.19 {
		ModLoadingContext.get().registerExtensionPoint(
				ConfigScreenHandler.ConfigScreenFactory.class,
				() -> new ConfigScreenHandler.ConfigScreenFactory(
						(mc, parent) -> ConfigScreen.create(parent, CatVision.CONFIG))
		);
		//?}

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
		//? >= 1.19 {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onRegisterKeyMappings);
		//?}
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void onClientSetup(FMLClientSetupEvent event) {
		//? < 1.19 {
		/^ClientRegistry.registerKeyBinding(KeyInputHandler.toggleNightVisionKey);
		ClientRegistry.registerKeyBinding(KeyInputHandler.openConfigKey);
		^///?} >= 1.19 {

		//?}
	}

	//? >= 1.19 {
	private void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(KeyInputHandler.toggleNightVisionKey);
		event.register(KeyInputHandler.openConfigKey);
	}
	//?}

	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		if (event.phase != TickEvent.Phase.END)
			return;
		Minecraft client = Minecraft.getInstance();
		EndTickListener.onEndTick(client);
		KeyInputHandler.onKeyTick(client);
	}

	@SubscribeEvent
	//? < 1.19 {
	/^public void onPlayerLoggedIn(ClientPlayerNetworkEvent.LoggedInEvent event) {
	^///?} >= 1.19 {
	public void onPlayerLoggedIn(ClientPlayerNetworkEvent.LoggingIn event) {
	//?}
		JoinListener.onJoin(Minecraft.getInstance());
	}

	@SubscribeEvent
	//? < 1.19 {
	/^public void onPlayerLoggedOut(ClientPlayerNetworkEvent.LoggedOutEvent event) {
	^///?} >= 1.19 {
	public void onPlayerLoggedOut(ClientPlayerNetworkEvent.LoggingOut event) {
	//?}
		DisconnectListener.onDisconnect();
	}

	@SubscribeEvent
	//? < 1.19 {
	/^public void onEntityJoinWorld(EntityJoinWorldEvent event) {
	^///?} >= 1.19 {
	public void onEntityJoinLevel(EntityJoinLevelEvent event) {
	//?}
		RespawnListener.onEntityLoad(event.getEntity());
	}
}
*///?}
