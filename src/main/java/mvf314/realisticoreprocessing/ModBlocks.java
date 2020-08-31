package mvf314.realisticoreprocessing;

import mvf314.realisticoreprocessing.blocks.BrokenGoldOreBlock;
import mvf314.realisticoreprocessing.blocks.BrokenIronOreBlock;
import mvf314.realisticoreprocessing.modules.bloomery.BellowsBlock;
import mvf314.realisticoreprocessing.modules.bloomery.BloomBlock;
import mvf314.realisticoreprocessing.modules.bloomery.BloomeryBlock;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {
	@ObjectHolder(ROPMod.MODID + ":" + Resources.BROKEN_IRON_ORE)
	public static BrokenIronOreBlock BROKEN_IRON_ORE;

	@ObjectHolder(ROPMod.MODID + ":" + Resources.BROKEN_GOLD_ORE)
	public static BrokenGoldOreBlock BROKEN_GOLD_ORE;

	@ObjectHolder(ROPMod.MODID + ":" + Resources.BLOOM_BLOCK)
	public static BloomBlock BLOOM;

	@ObjectHolder(ROPMod.MODID + ":" + Resources.BLOOMERY)
	public static BloomeryBlock BLOOMERY;

	@ObjectHolder(ROPMod.MODID + ":" + Resources.BELLOWS)
	public static BellowsBlock BELLOWS;
}
