package mvf314.realisticoreprocessing.datagen;

import mvf314.mvflib.datagen.BaseModelProvider;
import mvf314.realisticoreprocessing.ModBlocks;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

import javax.annotation.Nonnull;

public class ItemModels extends BaseModelProvider {

	public ItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper, ROPMod.setup.registryMap);
	}

	@Override
	protected void registerModels() {

		generateItemModel(ModBlocks.BROKEN_IRON_ORE);

		generateItemModel(ModBlocks.BLOOMERY);
		generateItemModel(ModBlocks.BELLOWS);

		generateItemModel(ModItems.WROUGHT_IRON_INGOT);
		generateItemModel(ModItems.STEEL_INGOT);
		generateItemModel(ModItems.SLAG);

		generateItemModel(ModItems.BLOOM);
		generateItemModel(ModItems.WROUGHT_IRON_CARBON_COMPOUND);
		generateItemModel(ModItems.HOT_STEEL_INGOT);
		generateItemModel(ModItems.IRON_ORE_CHUNK);

		generateItemModel(ModItems.HAMMER);
		generateItemModel(ModItems.CHISEL);
	}

	@Nonnull
	@Override
	public String getName() {
		return "Realistic Ore Processing ItemModels";
	}
}
