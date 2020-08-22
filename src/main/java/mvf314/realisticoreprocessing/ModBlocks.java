package mvf314.realisticoreprocessing;

import mvf314.realisticoreprocessing.modules.bloomery.BellowsBlock;
import mvf314.realisticoreprocessing.modules.bloomery.BloomBlock;
import mvf314.realisticoreprocessing.modules.bloomery.BloomeryBlock;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {
	@ObjectHolder(ROPMod.MODID + ":" + Resources.BLOOM_BLOCK)
	public static BloomBlock BLOOM;

	@ObjectHolder(ROPMod.MODID + ":" + Resources.BLOOMERY)
	public static BloomeryBlock BLOOMERY;

	@ObjectHolder(ROPMod.MODID + ":" + Resources.BELLOWS)
	public static BellowsBlock BELLOWS;
}
