package mvf314.realisticoreprocessing.modules.bloomery;

import mvf314.mvflib.block.BlockPropertyProvider;
import mvf314.mvflib.block.DirectionalXZBlock;
import mvf314.mvflib.block.HarvestLevel;
import mvf314.mvflib.datagen.BlockStateGenerator;
import mvf314.mvflib.tools.WorldTools;
import mvf314.realisticoreprocessing.CustomBlockStateProperties;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.Random;

public class BloomeryBlock extends DirectionalXZBlock {

	public static final BooleanProperty CHARCOAL;
	public static final BooleanProperty IRON;
	public static final BooleanProperty LIT;

	public BloomeryBlock() {
		super(BlockPropertyProvider.get(Material.ROCK, Material.ROCK.getColor(),
				SoundType.STONE,
				HarvestLevel.WOOD, ToolType.PICKAXE,
				0, 6, 1.5f,
				0.6f, 1.0f, 1.0f,
				true, false, false, false), ROPMod.setup.registryMap);
		setLocale(lang, "Bloomery");
		setDefaultState(getDefaultState().with(CHARCOAL, false));
		setDefaultState(getDefaultState().with(IRON, false));
		setDefaultState(getDefaultState().with(LIT, false));
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		if (state.get(BlockStateProperties.LIT)) {
			return true;
		}
		return false;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		if (state.get(BlockStateProperties.LIT)) {
			return new BloomeryTile();
		}
		return null;
	}

	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		if (state.get(BlockStateProperties.LIT)) {
			return 10;
		}
		return 0;
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		ItemStack stack = player.getHeldItem(handIn);
		boolean hasCharcoal = state.get(CustomBlockStateProperties.HAS_CHARCOAL);
		boolean hasIron = state.get(CustomBlockStateProperties.HAS_IRON);
		if (stack.getItem() == Items.CHARCOAL) {
			if (!hasCharcoal) {
				WorldTools.setBlockState(worldIn, pos, state, CustomBlockStateProperties.HAS_CHARCOAL, true);
				stack.shrink(1);
				player.setHeldItem(handIn, stack);
				return ActionResultType.SUCCESS;
			}
		} else if (stack.getItem() == ModItems.IRON_ORE_CHUNK) {
			if (!hasIron) {
				WorldTools.setBlockState(worldIn, pos, state, CustomBlockStateProperties.HAS_IRON, true);
				stack.shrink(1);
				player.setHeldItem(handIn, stack);
				return ActionResultType.SUCCESS;
			}
		} else if (stack.getItem() == Items.FLINT_AND_STEEL) {
			if (hasCharcoal && hasIron) {
				worldIn.setBlockState(pos, state.with(BlockStateProperties.LIT, true));
				stack.damageItem(1, player, entity -> {
					entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
				});
				return ActionResultType.SUCCESS;
			}
		} else if (stack.isEmpty()) {
			if (hasCharcoal) {
				WorldTools.setBlockState(worldIn, pos, state, CustomBlockStateProperties.HAS_CHARCOAL, false);
				WorldTools.spawnItem(worldIn, pos.offset(Direction.UP), Items.CHARCOAL);
				return ActionResultType.SUCCESS;
			} else if (hasIron) {
				WorldTools.setBlockState(worldIn, pos, state, CustomBlockStateProperties.HAS_IRON, false);
				WorldTools.spawnItem(worldIn, pos.offset(Direction.UP), ModItems.IRON_ORE_CHUNK);
				return ActionResultType.SUCCESS;
			}
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(CustomBlockStateProperties.HAS_CHARCOAL);
		builder.add(CustomBlockStateProperties.HAS_IRON);
		builder.add(BlockStateProperties.LIT);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (stateIn.get(LIT)) {
			double x = pos.getX() + 0.5d;
			double y = pos.getY() + 0.2d;
			double z = pos.getZ() + 0.5d;

			Direction dir = stateIn.get(BlockStateProperties.HORIZONTAL_FACING);
			double fireX = rand.nextDouble() * 0.8d - 0.4d;
			double fireY = rand.nextDouble() * 0.2d - 0.1d;
			double fireZ = rand.nextDouble() * 0.8d - 0.4d;

			double smokeX = rand.nextDouble() * 0.1d - 0.05d;
			double smokeY = 0.7d;
			double smokeZ = rand.nextDouble() * 0.1d - 0.05d;

			double smokeYSpeed = rand.nextDouble() * 0.05d + 0.01d;

			worldIn.addParticle(ParticleTypes.FLAME, x + fireX, y + fireY, z + fireZ, 0.0d, 0.0d, 0.0d);
			worldIn.addParticle(ParticleTypes.SMOKE, x + smokeX, y + smokeY, z + smokeZ, 0.0d, smokeYSpeed, 0.0d);
		}
	}

	static {
		CHARCOAL = CustomBlockStateProperties.HAS_CHARCOAL;
		IRON = CustomBlockStateProperties.HAS_IRON;
		LIT = BlockStateProperties.LIT;
	}

	@Override
	public String getBlockState(String modid) {
		return BlockStateGenerator.generateFromStates(
				BlockStateGenerator.getDirectionalXZSingleStateCustom("has_charcoal=false,has_iron=false", modid, getRegistryName().getPath(), ""),
				BlockStateGenerator.getDirectionalXZSingleStateCustom("has_charcoal=true,has_iron=false", modid, getRegistryName().getPath(), "_charcoal"),
				BlockStateGenerator.getDirectionalXZSingleStateCustom("has_charcoal=false,has_iron=true", modid, getRegistryName().getPath(), "_iron"),
				BlockStateGenerator.getDirectionalXZSingleStateCustom("has_charcoal=true,has_iron=true", modid, getRegistryName().getPath(), "_charcoal_iron")
		);
	}
}
