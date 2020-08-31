package mvf314.realisticoreprocessing.items;

import mvf314.mvflib.block.DirectionalXZBlock;
import mvf314.mvflib.item.BaseToolItem;
import mvf314.mvflib.item.ItemPropertyProvider;
import mvf314.mvflib.tools.WorldTools;
import mvf314.realisticoreprocessing.ModBlocks;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChiselItem extends BaseToolItem {
	public ChiselItem() {
		super(ItemPropertyProvider.getTool(ROPMod.setup.itemGroup, 1000, Rarity.COMMON, true), ROPMod.setup.registryMap, 1.5f, -2.8f);
		setLocale(lang, "Chisel");
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		if (!context.getWorld().isRemote) {
			BlockPos pos = context.getPos();
			World world = context.getWorld();
			BlockState blockState = world.getBlockState(pos);
			BlockPos loc = pos.offset(context.getFace());

			if (blockState.getBlock() == Blocks.IRON_ORE) {
				BlockState state = ModBlocks.BROKEN_IRON_ORE.getDefaultState();
				WorldTools.setBlockState(world, pos, state, BlockStateProperties.HORIZONTAL_FACING, DirectionalXZBlock.getFacingFromEntity(pos, context.getPlayer()));

				WorldTools.spawnItem(world, loc, ModItems.IRON_ORE_CHUNK);

				addDamage(1, context.getPlayer());
				return ActionResultType.SUCCESS;
			} else if (blockState.getBlock() == ModBlocks.BROKEN_IRON_ORE) {
				if (blockState.get(BlockStateProperties.STAGE_0_1) == 0) {
					WorldTools.setBlockState(world, pos, blockState, BlockStateProperties.STAGE_0_1, 1);
				} else {
					world.removeBlock(pos, false);
				}

				WorldTools.spawnItem(world, loc, ModItems.IRON_ORE_CHUNK);

				addDamage(1, context.getPlayer());
				return ActionResultType.SUCCESS;
			} else if (blockState.getBlock() == Blocks.GOLD_ORE) {
				BlockState state = ModBlocks.BROKEN_GOLD_ORE.getDefaultState();
				WorldTools.setBlockState(world, pos, state, BlockStateProperties.HORIZONTAL_FACING, DirectionalXZBlock.getFacingFromEntity(pos, context.getPlayer()));

				WorldTools.spawnItem(world, loc, Items.GOLD_NUGGET);

				addDamage(1, context.getPlayer());
				return ActionResultType.SUCCESS;
			} else if (blockState.getBlock() == ModBlocks.BROKEN_GOLD_ORE) {
				if (blockState.get(BlockStateProperties.STAGE_0_1) == 0) {
					WorldTools.setBlockState(world, pos, blockState, BlockStateProperties.STAGE_0_1, 1);
				} else {
					world.removeBlock(pos, false);
				}

				WorldTools.spawnItem(world, loc, Items.GOLD_NUGGET);

				addDamage(1, context.getPlayer());
				return ActionResultType.SUCCESS;
			}
		}
		return super.onItemUse(context);
	}
}
