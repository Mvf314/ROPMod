package mvf314.realisticoreprocessing.items;

import mvf314.mvflib.item.BaseToolItem;
import mvf314.mvflib.item.ItemPropertyProvider;
import mvf314.realisticoreprocessing.ModBlocks;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HammerItem extends BaseToolItem {
	public HammerItem() {
		super(ItemPropertyProvider.getTool(ROPMod.setup.itemGroup, 250, Rarity.COMMON, true), ROPMod.setup.registryMap, 1, -2);
		setLocale(lang, "Hammer");
		//super(prop, map, 1.5f, -2.8F);
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
					world.setBlockState(pos, blockState.with(BlockStateProperties.LEVEL_0_3, ++level));
				} else {
					world.setBlockState(pos, Blocks.AIR.getDefaultState());
					ItemStack iron_stack = new ItemStack(ModItems.WROUGHT_IRON_INGOT);
					ItemStack slag_stack = new ItemStack(ModItems.SLAG);
					ItemEntity ironDrop = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), iron_stack);
					ItemEntity slagDrop = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), slag_stack);
					world.addEntity(ironDrop);
					world.addEntity(slagDrop);
				}
				addDamage(1, context.getPlayer().getHeldItem(Hand.MAIN_HAND), context.getPlayer());
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.PASS;
	}
}
