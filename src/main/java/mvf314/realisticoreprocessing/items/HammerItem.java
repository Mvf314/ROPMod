package mvf314.realisticoreprocessing.items;

import mvf314.mvflib.item.BaseToolItem;
import mvf314.mvflib.item.ItemPropertyProvider;
import mvf314.mvflib.tools.WorldTools;
import mvf314.realisticoreprocessing.ModBlocks;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HammerItem extends BaseToolItem {
	public HammerItem() {
		super(ItemPropertyProvider.getTool(ROPMod.setup.itemGroup, 250, Rarity.COMMON, true), ROPMod.setup.registryMap, 1.5f, -2.8f);
		setLocale(lang, "Hammer");
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		if (!context.getWorld().isRemote) {
			BlockPos pos = context.getPos();
			World world = context.getWorld();
			BlockState blockState = world.getBlockState(pos);
			if (blockState.getBlock() == ModBlocks.BLOOM) {
				int level = blockState.get(BlockStateProperties.LEVEL_0_3);
				if (level < 3) {
					WorldTools.setBlockState(world, pos, blockState, BlockStateProperties.LEVEL_0_3, ++level);
				} else {
					world.removeBlock(pos, false);

					WorldTools.spawnItem(world, pos, ModItems.WROUGHT_IRON_CHUNK);
					WorldTools.spawnItem(world, pos, ModItems.SLAG);
				}
				addDamage(1, context.getPlayer());
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.PASS;
	}
}
