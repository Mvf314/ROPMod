package mvf314.realisticoreprocessing.modules.bloomery;

import mvf314.mvflib.tile.TickableTileEntity;
import mvf314.mvflib.tools.WorldTools;
import mvf314.realisticoreprocessing.Config;
import mvf314.realisticoreprocessing.ModTiles;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;

public class BloomeryTile extends TickableTileEntity {

	private int counter;

	public BloomeryTile() {
		super(ModTiles.BLOOMERY);
		counter = Config.BLOOMERY_PROCESSING_TIME.get();
	}

	@Override
	public void tick() {
		if (world.isRemote) {
			return;
		}
		BlockState state = world.getBlockState(pos);
		if (counter > 0) {
			counter--;
			markDirty();
		} else {
			WorldTools.setBlockState(world, pos, state, BlockStateProperties.LIT, false);
			counter = Config.BLOOMERY_PROCESSING_TIME.get();
			markDirty();
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
