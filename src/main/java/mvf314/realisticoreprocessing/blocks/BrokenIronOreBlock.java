package mvf314.realisticoreprocessing.blocks;

import mvf314.mvflib.block.BlockPropertyProvider;
import mvf314.mvflib.block.DirectionalXZBlock;
import mvf314.mvflib.block.HarvestLevel;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.common.ToolType;

public class BrokenIronOreBlock extends DirectionalXZBlock {

	public static final IntegerProperty STAGE;

	public BrokenIronOreBlock() {
		super(BlockPropertyProvider.get(Material.ROCK, Material.ROCK.getColor(),
				SoundType.STONE,
				HarvestLevel.STONE, ToolType.PICKAXE,
				0, 6, 1.5f,
				0.6f, 1.0f, 1.0f,
				true, false, false, false), ROPMod.setup.registryMap);
		setLocale(lang, "Broken Iron Ore");
		setDefaultState(getDefaultState().with(STAGE, 0));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(BlockStateProperties.STAGE_0_1);
	}

	static {
		STAGE = BlockStateProperties.STAGE_0_1;
	}
}
