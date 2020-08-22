package mvf314.realisticoreprocessing.modules.bloomery;

import mvf314.mvflib.item.BaseItem;
import mvf314.mvflib.item.ItemPropertyProvider;
import mvf314.realisticoreprocessing.Config;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import mvf314.realisticoreprocessing.entities.HeatableItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class WroughtIronCarbonCompoundItem extends BaseItem {
	public WroughtIronCarbonCompoundItem() {
		super(ItemPropertyProvider.get(ROPMod.setup.itemGroup), ROPMod.setup.registryMap);
		setLocale(lang, "Wrought Iron-Carbon Compound");
	}

	@Override
	public boolean hasCustomEntity(ItemStack stack) {
		return true;
	}

	@Nullable
	@Override
	public Entity createEntity(World world, Entity entity, ItemStack itemstack) {
		return new HeatableItemEntity(world, entity.getPositionVec(), itemstack,
				entity.getMotion(), Config.WICC_HEATING_TIME.get(), ModItems.HOT_STEEL_INGOT);
	}


}
