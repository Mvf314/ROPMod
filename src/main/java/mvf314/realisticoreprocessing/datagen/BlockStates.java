package mvf314.realisticoreprocessing.datagen;

import mvf314.mvflib.datagen.BaseBlockStateProvider;
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

	}

	@Nonnull
	@Override
	public String getName() {
		return "Realistic Ore Processing BlockStates";
	}
}
