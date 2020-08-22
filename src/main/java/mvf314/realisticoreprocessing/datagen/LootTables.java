package mvf314.realisticoreprocessing.datagen;

import mvf314.mvflib.datagen.BaseLootTableProvider;
import mvf314.realisticoreprocessing.ModBlocks;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.data.DataGenerator;

public class LootTables extends BaseLootTableProvider {

	public LootTables(DataGenerator gen) {
		super(gen, ROPMod.setup.registryMap);
	}

	@Override
	protected void addTables() {
		addGemTable(ModBlocks.BLOOM, ModItems.BLOOM);
	}

	@Override
	public String getName() {
		return "Realistic Ore Processing LootTables";
	}
}
