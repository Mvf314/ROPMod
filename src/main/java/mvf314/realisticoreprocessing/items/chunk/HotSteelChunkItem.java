package mvf314.realisticoreprocessing.items.chunk;

import mvf314.realisticoreprocessing.Config;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.entities.QuenchableItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class HotSteelChunkItem extends MetalChunkItem {
	public HotSteelChunkItem() {
		super(0xff8a57);
		setLocale(lang, "Hot Steel Chunk");
	}

	@Override
	public boolean hasCustomEntity(ItemStack stack) {
		return true;
	}

	@Nullable
	@Override
	public Entity createEntity(World world, Entity entity, ItemStack itemstack) {
		return new QuenchableItemEntity(world, entity.getPositionVec(), itemstack,
				entity.getMotion(), Config.HOT_STEEL_QUENCHING_TIME.get(), ModItems.STEEL_CHUNK);
	}
}
