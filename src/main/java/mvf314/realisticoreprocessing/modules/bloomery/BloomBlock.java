package mvf314.realisticoreprocessing.modules.bloomery;

import mvf314.mvflib.block.BaseBlock;
import mvf314.mvflib.block.BlockPropertyProvider;
import mvf314.mvflib.block.HarvestLevel;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class BloomBlock extends BaseBlock {

	public static final IntegerProperty LEVEL;

	protected static final VoxelShape SHAPE_LEVEL0;
	protected static final VoxelShape SHAPE_LEVEL1;
	protected static final VoxelShape SHAPE_LEVEL2;
	protected static final VoxelShape SHAPE_LEVEL3;

	public BloomBlock() {
		super(BlockPropertyProvider.get(Material.PLANTS, SoundType.SAND, HarvestLevel.WOOD, ToolType.SHOVEL), ROPMod.setup.registryMap);
		setLocale(lang, "Bloom Block");
		setDefaultState((this.getDefaultState().with(LEVEL, 0)));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(BlockStateProperties.LEVEL_0_3);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int level = state.get(LEVEL);
		if (level == 0) {
			return SHAPE_LEVEL0;
		} else if (level == 1) {
			return SHAPE_LEVEL1;
		} else if (level == 2) {
			return SHAPE_LEVEL2;
		}
		return SHAPE_LEVEL3;
	}

	static {
		LEVEL = BlockStateProperties.LEVEL_0_3;
		SHAPE_LEVEL0 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);
		SHAPE_LEVEL1 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D);
		SHAPE_LEVEL2 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
		SHAPE_LEVEL3 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	}

}

