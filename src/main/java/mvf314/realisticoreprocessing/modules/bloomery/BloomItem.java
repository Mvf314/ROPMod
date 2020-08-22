package mvf314.realisticoreprocessing.modules.bloomery;

import mvf314.mvflib.item.BaseItem;
import mvf314.mvflib.item.ItemPropertyProvider;
import mvf314.realisticoreprocessing.ModBlocks;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

public class BloomItem extends BaseItem {
	public BloomItem() {
		super(ItemPropertyProvider.get(ROPMod.setup.itemGroup), ROPMod.setup.registryMap);
		setLocale(lang, "Bloom");
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		if (!context.getWorld().isRemote) {
			BlockPos pos = context.getPos().offset(context.getFace());
			BlockState blockState = context.getWorld().getBlockState(pos.offset(Direction.DOWN));
			if (blockState.getMaterial().isOpaque()) {
				context.getWorld().setBlockState(pos, ModBlocks.BLOOM.getDefaultState());
			}
			ItemStack itemStack = context.getItem();
			itemStack.shrink(1);
			context.getPlayer().setItemStackToSlot(EquipmentSlotType.MAINHAND, itemStack);
		}
		return super.onItemUse(context);
	}
}
