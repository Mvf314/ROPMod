package mvf314.realisticoreprocessing.datagen;

import mvf314.mvflib.datagen.BaseBlockStateProvider;
import mvf314.realisticoreprocessing.ModBlocks;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

import javax.annotation.Nonnull;

public class BlockStates extends BaseBlockStateProvider {

	public BlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
		super(gen, modid, exFileHelper, ROPMod.setup.registryMap);
	}

	@Override
	protected void registerStatesAndModels() {
		generateBlockState(ModBlocks.BLOOM);
		generateBlockState(ModBlocks.BLOOMERY);
		generateBlockState(ModBlocks.BELLOWS);
		generateBlockState(ModBlocks.BROKEN_IRON_ORE);
		generateBlockState(ModBlocks.BROKEN_GOLD_ORE);
	}

	@Nonnull
	@Override
	public String getName() {
		return "Realistic Ore Processing BlockStates";
	}
}
