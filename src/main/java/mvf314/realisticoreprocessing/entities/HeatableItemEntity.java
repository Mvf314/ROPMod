package mvf314.realisticoreprocessing.entities;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class HeatableItemEntity extends ItemEntity {

	private int counter;
	private ItemStack stack;

	public HeatableItemEntity(World worldIn, Vec3d pos, ItemStack itemStack, Vec3d vel, int time, Item item) {
		super(worldIn, pos.x, pos.y, pos.z, itemStack);
		setPickupDelay(40);
		this.setVelocity(vel.x, vel.y, vel.z);

		// do not burn up
		this.setInvulnerable(true);

		counter = time;
		stack = new ItemStack(item);
	}



	@Override
	public void tick() {
		super.tick();
		if (counter < 0) {
			stack.setCount(getItem().getCount());
			this.setItem(stack);
		} else if (isBurning()) {
			counter--;
		}
		// Destroy item if in lava
		if (isInLava()) {
			this.setInvulnerable(false);
		}
	}
}
