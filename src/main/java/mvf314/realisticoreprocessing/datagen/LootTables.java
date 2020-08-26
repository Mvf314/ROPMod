package mvf314.realisticoreprocessing.datagen;

import mvf314.mvflib.datagen.BaseLootTableProvider;
import mvf314.realisticoreprocessing.CustomBlockStateProperties;
import mvf314.realisticoreprocessing.ModBlocks;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Items;

public class LootTables extends BaseLootTableProvider {

	public LootTables(DataGenerator gen) {
		super(gen, ROPMod.setup.registryMap);
	}

	@Override
	protected void addTables() {

		addSimpleTable(ModBlocks.BELLOWS);

		addTable(ModBlocks.BLOOMERY, makeFromPools(
				getSimplePool(ModBlocks.BLOOMERY),
				getPool("bloomery_charcoal")
						.addEntry(itemEntry(Items.CHARCOAL)
						.acceptCondition(boolBlockStateCondition(ModBlocks.BLOOMERY, CustomBlockStateProperties.HAS_CHARCOAL, true))),
				getPool("bloomery_iron")
					.addEntry(itemEntry(ModItems.IRON_ORE_CHUNK)
					.acceptCondition(boolBlockStateCondition(ModBlocks.BLOOMERY, CustomBlockStateProperties.HAS_IRON, true)))
		));

		addItemTable(ModBlocks.BLOOM, ModItems.BLOOM);
		addItemTable(ModBlocks.BROKEN_IRON_ORE, ModItems.IRON_ORE_CHUNK);

	}

	@Override
	public String getName() {
		return "Realistic Ore Processing LootTables";
	}
}
