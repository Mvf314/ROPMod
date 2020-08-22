package mvf314.realisticoreprocessing.datagen;

import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		if (event.includeServer()) {
			gen.addProvider(new LootTables(gen));
			gen.addProvider(new Recipes(gen, ROPMod.MODID));
		}
		if (event.includeClient()) {
			gen.addProvider(new BlockStates(gen, ROPMod.MODID, event.getExistingFileHelper()));
			gen.addProvider(new ItemModels(gen, ROPMod.MODID, event.getExistingFileHelper()));
			gen.addProvider(new Language(gen, ROPMod.MODID, "en_us"));
		}
	}
}
