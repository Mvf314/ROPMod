package mvf314.realisticoreprocessing.modules.bloomery;

import mvf314.mvflib.tile.TickableTileEntity;
import mvf314.realisticoreprocessing.*;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

public class BellowsTile extends TickableTileEntity {
	private final int TICKS;
	private int counter;

	public BellowsTile() {
		super(ModTiles.BELLOWS);
		TICKS = (int) (4.d / Config.BELLOWS_SPEED_MULT.get());
		counter = TICKS;
	}

	@Override
	public void tick() {
		if (world.isRemote) {
			return;
		}
		BlockState state = world.getBlockState(pos);
		if (counter > 0) {
			if (state.get(BlockStateProperties.ENABLED)) {
				counter--;
				markDirty();
			}
		} else {
			int level = state.get(BlockStateProperties.LEVEL_0_8);
			// progress to next stage
			if (level != 6) {
				world.setBlockState(pos, state.with(BlockStateProperties.LEVEL_0_8, level + 1));
				counter = TICKS;
				markDirty();

				// blow air in bloomery
				if (level == 3) {
					Direction offset = state.get(BlockStateProperties.HORIZONTAL_FACING).rotateYCCW();
					BlockState rightState = world.getBlockState(pos.offset(offset));
					System.out.println("block to right = " + rightState.getBlock().toString());
					if (rightState.getBlock() == ModBlocks.BLOOMERY) {
						if (rightState.get(BlockStateProperties.HORIZONTAL_FACING) == state.get(BlockStateProperties.HORIZONTAL_FACING) &&
								rightState.get(BlockStateProperties.LIT) &&
								rightState.get(CustomBlockStateProperties.HAS_CHARCOAL) &&
								rightState.get(CustomBlockStateProperties.HAS_IRON)) {
							rightState = rightState.with(BlockStateProperties.LIT, false);
							rightState = rightState.with(CustomBlockStateProperties.HAS_CHARCOAL, false);
							rightState = rightState.with(CustomBlockStateProperties.HAS_IRON, false);
							world.setBlockState(pos.offset(offset), rightState);
							BlockPos itemPos = pos.offset(offset).offset(Direction.UP);
							ItemStack is = new ItemStack(ModItems.BLOOM);
							ItemEntity entity = new ItemEntity(world, itemPos.getX(), itemPos.getY(), itemPos.getZ(), is);
							world.addEntity(entity);
						}
					}
				}

			} else {
				state = state.with(BlockStateProperties.LEVEL_0_8, 0);
				world.setBlockState(pos, state.with(BlockStateProperties.ENABLED, false));
				counter = TICKS;
				markDirty();
			}
		}
	}

	@Override
	public void read(CompoundNBT tag) {
		counter = tag.getInt("counter");
		super.read(tag);
	}

	@Override
	public CompoundNBT write(CompoundNBT tag) {
		tag.putInt("counter", counter);
		return super.write(tag);
	}
}
