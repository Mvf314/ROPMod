package mvf314.realisticoreprocessing.modules.bloomery;

import mvf314.mvflib.block.BlockPropertyProvider;
import mvf314.mvflib.block.DirectionalXZBlock;
import mvf314.mvflib.block.HarvestLevel;
import mvf314.mvflib.tools.WorldTools;
import mvf314.realisticoreprocessing.CustomBlockStateProperties;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BellowsBlock extends DirectionalXZBlock {

	public static final IntegerProperty LEVEL;
	public static final BooleanProperty ENABLED;

	protected static final VoxelShape SHAPE_LEVEL0;
	protected static final VoxelShape SHAPE_LEVEL1;
	protected static final VoxelShape SHAPE_LEVEL2;
	protected static final VoxelShape SHAPE_LEVEL3;

	public BellowsBlock() {
		super(BlockPropertyProvider.get(Material.WOOD, Material.WOOD.getColor(),
				SoundType.WOOD,
				HarvestLevel.WOOD, ToolType.AXE,
				0, 6, 1.5f,
				0.6f, 1.0f, 1.0f,
				true, false, false, false), ROPMod.setup.registryMap);
		setLocale(lang, "Bellows");
		setDefaultState(getDefaultState().with(LEVEL, 0));
		setDefaultState(getDefaultState().with(ENABLED, false));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(CustomBlockStateProperties.LEVEL_0_6);
		builder.add(BlockStateProperties.ENABLED);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new BellowsTile();
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (player.getHeldItem(Hand.MAIN_HAND).isEmpty()) {
			if (!state.get(BlockStateProperties.ENABLED)) {
				WorldTools.setBlockState(worldIn, pos, state, BlockStateProperties.ENABLED, true);
				return ActionResultType.SUCCESS;
			}
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int level = state.get(LEVEL);
		if (level == 0 || level == 6) {
			return SHAPE_LEVEL0;
		} else if (level == 1 || level == 5) {
			return SHAPE_LEVEL1;
		} else if (level == 2 || level == 4) {
			return SHAPE_LEVEL2;
		} else if (level == 3) {
			return SHAPE_LEVEL3;
		}
		return SHAPE_LEVEL0;
	}

	static {
		LEVEL = CustomBlockStateProperties.LEVEL_0_6;
		ENABLED = BlockStateProperties.ENABLED;

		SHAPE_LEVEL0 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
		SHAPE_LEVEL1 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
		SHAPE_LEVEL2 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);
		SHAPE_LEVEL3 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D);
	}
}
