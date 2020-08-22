package mvf314.realisticoreprocessing.setup;

import net.minecraft.world.World;

public interface IProxy {

	World getClientWorld();
	void init();
}