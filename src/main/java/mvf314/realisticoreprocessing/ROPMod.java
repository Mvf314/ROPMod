package mvf314.realisticoreprocessing;

import mvf314.realisticoreprocessing.setup.ClientProxy;
import mvf314.realisticoreprocessing.setup.IProxy;
import mvf314.realisticoreprocessing.setup.ModSetup;
import mvf314.realisticoreprocessing.setup.ServerProxy;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(ROPMod.MODID)
public class ROPMod {

	public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

	public static final String MODID = "realisticoreprocessing";
	public static final String MODNAME = "Realistic Ore Processing";

	public static ModSetup setup = new ModSetup();

	public ROPMod() {

		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

		Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-client.toml"));
		Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-server.toml"));
	}

	private void setup(final FMLCommonSetupEvent event) {
		proxy.init();
	}
}
