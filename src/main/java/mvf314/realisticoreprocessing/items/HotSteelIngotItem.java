package mvf314.realisticoreprocessing.items;

import mvf314.mvflib.item.BaseItem;
import mvf314.mvflib.item.ItemPropertyProvider;
import mvf314.realisticoreprocessing.Config;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import mvf314.realisticoreprocessing.entities.QuenchableItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class HotSteelIngotItem extends BaseItem {
	public HotSteelIngotItem() {
		super(ItemPropertyProvider.get(ROPMod.setup.itemGroup), ROPMod.setup.registryMap);
		setLocale(lang, "Hot Steel Ingot");
	}

	@Override
	public boolean hasCustomEntity(ItemStack stack) {
		return true;
	}

	@Nullable
	@Override
	public Entity createEntity(World world, Entity entity, ItemStack itemstack) {
		return new QuenchableItemEntity(world, entity.getPositionVec(), itemstack,
				entity.getMotion(), Config.HOT_STEEL_QUENCHING_TIME.get(), ModItems.STEEL_INGOT);
	}
}
