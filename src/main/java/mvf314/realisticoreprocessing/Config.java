package mvf314.realisticoreprocessing;

import mvf314.mvflib.tools.BaseConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Config extends BaseConfig {
	public static final String CATEGORY_TIMING = "timing";

	public static final String SUBCATEGORY_HEATING = "heating";
	public static final String SUBCATEGORY_QUENCHING = "quenching";

	public static final String CATEGORY_MACHINES = "machines";
	public static final String SUBCATEGORY_BLOOMERY = "bloomery";
	public static final String SUBCATEGORY_BELLOWS = "bellows";

	public static final ForgeConfigSpec.Builder SERVER = getBuilder();
	public static final ForgeConfigSpec.Builder CLIENT = getBuilder();

	public static ForgeConfigSpec SERVER_CONFIG;
	public static ForgeConfigSpec CLIENT_CONFIG;

	public static ForgeConfigSpec.IntValue WICC_HEATING_TIME;
	public static ForgeConfigSpec.IntValue HOT_STEEL_QUENCHING_TIME;

	public static ForgeConfigSpec.IntValue BLOOMERY_PROCESSING_TIME;

	public static ForgeConfigSpec.DoubleValue BELLOWS_SPEED_MULT;

	static {
		startCategory(SERVER, "Timings", CATEGORY_TIMING);
		setupHeatingConfig();
		setupQuenchingConfig();
		endCategory(SERVER);

		startCategory(SERVER, "Machine properties", CATEGORY_MACHINES);
		setupBloomeryConfig();
		setupBellowsConfig();
		endCategory(SERVER);


		SERVER_CONFIG = build(SERVER);
		CLIENT_CONFIG = build(CLIENT);
	}

	private static void setupBloomeryConfig() {
		startCategory(SERVER, "Bloomery", SUBCATEGORY_BLOOMERY);

		BLOOMERY_PROCESSING_TIME = positiveInt(SERVER, "Ticks per bloomery operation", "bloomery_ticks", 100);

		endCategory(SERVER);
	}

	private static void setupBellowsConfig() {
		startCategory(SERVER, "Bellows", SUBCATEGORY_BELLOWS);

		BELLOWS_SPEED_MULT = positiveDouble(SERVER, "Bellows speed multiplier", "bellows_speed_mult", 1.0d);

		endCategory(SERVER);
	}

	private static void setupHeatingConfig() {
		startCategory(SERVER, "Heatimg timings", SUBCATEGORY_HEATING);

		WICC_HEATING_TIME = positiveInt(SERVER, "Wrought Iron-Carbon Compound", "wicc_heating", 200);

		endCategory(SERVER);
	}

	private static void setupQuenchingConfig() {
		startCategory(SERVER, "Quenching timings", SUBCATEGORY_QUENCHING);

		HOT_STEEL_QUENCHING_TIME = positiveInt(SERVER, "Hot Steel", "hot_steel_quenching", 300);

		endCategory(SERVER);
	}



	@SubscribeEvent
	public static void onLoad(final ModConfig.Loading cfgEvent) {
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfig.Reloading cfgEvent) {
	}
}
