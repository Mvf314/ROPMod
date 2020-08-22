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

		createBlockItemModel(ModBlocks.BLOOMERY);
		createBlockItemModel(ModBlocks.BELLOWS);

		createSimpleItemModel(ModItems.WROUGHT_IRON_INGOT);
		createSimpleItemModel(ModItems.STEEL_INGOT);
		createSimpleItemModel(ModItems.SLAG);

		createSimpleItemModel(ModItems.BLOOM);
		createSimpleItemModel(ModItems.WROUGHT_IRON_CARBON_COMPOUND);
		createSimpleItemModel(ModItems.HOT_STEEL_INGOT);

		createSimpleItemModel(ModItems.HAMMER);
	}

	@Nonnull
	@Override
	public String getName() {
		return "Realistic Ore Processing ItemModels";
	}
}
