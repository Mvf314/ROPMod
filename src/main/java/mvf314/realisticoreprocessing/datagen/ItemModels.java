package mvf314.realisticoreprocessing.datagen;

import mvf314.mvflib.datagen.BaseModelProvider;
import mvf314.mvflib.datagen.ItemModelGenerator;
import mvf314.realisticoreprocessing.ModBlocks;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

import javax.annotation.Nonnull;

public class ItemModels extends BaseModelProvider {

	public ItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper, ROPMod.setup.registryMap);
	}

	@Override
	protected void registerModels() {

		itemModels.put(new ResourceLocation(ROPMod.MODID, "template_metal_chunk"), ItemModelGenerator.getSimple(ROPMod.MODID, "metal_chunk"));

		generateItemModel(ModItems.WROUGHT_IRON_CHUNK);
		generateItemModel(ModItems.STEEL_CHUNK);
		generateItemModel(ModItems.HOT_STEEL_CHUNK);

		generateItemModel(ModBlocks.BROKEN_IRON_ORE);

		generateItemModel(ModBlocks.BLOOMERY);
		generateItemModel(ModBlocks.BELLOWS);

		generateItemModel(ModItems.SLAG);

		generateItemModel(ModItems.BLOOM);
		generateItemModel(ModItems.WROUGHT_IRON_CARBON_COMPOUND);
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
