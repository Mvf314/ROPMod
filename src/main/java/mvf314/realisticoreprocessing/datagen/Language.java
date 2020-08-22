package mvf314.realisticoreprocessing.datagen;

import mvf314.mvflib.datagen.BaseLanguageProvider;
import mvf314.realisticoreprocessing.ModBlocks;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.data.DataGenerator;

public class Language extends BaseLanguageProvider {

	public Language(DataGenerator gen, String modid, String locale) {
		super(gen, modid, locale);
	}

	@Override
	protected void addTranslations() {

		createItemGroupTranslation(ROPMod.MODID, ROPMod.MODNAME);

		createBlockTranslation(ModBlocks.BLOOM);
		createBlockTranslation(ModBlocks.BLOOMERY);
		createBlockTranslation(ModBlocks.BELLOWS);

		createItemTranslation(ModItems.WROUGHT_IRON_INGOT);
		createItemTranslation(ModItems.STEEL_INGOT);
		createItemTranslation(ModItems.SLAG);

		createItemTranslation(ModItems.BLOOM);
		createItemTranslation(ModItems.WROUGHT_IRON_CARBON_COMPOUND);
		createItemTranslation(ModItems.HOT_STEEL_INGOT);

		createItemTranslation(ModItems.HAMMER);
	}

	@Override
	public String getName() {
		return "Realistic Ore Processing Language " + getLocale();
	}
}
