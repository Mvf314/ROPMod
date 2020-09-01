package mvf314.realisticoreprocessing;

import mvf314.realisticoreprocessing.items.*;
import mvf314.realisticoreprocessing.items.chunk.HotSteelChunkItem;
import mvf314.realisticoreprocessing.items.chunk.SteelChunkItem;
import mvf314.realisticoreprocessing.items.chunk.WroughtIronChunkItem;
import mvf314.realisticoreprocessing.modules.bloomery.BloomItem;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {

	@ObjectHolder(ROPMod.MODID+ ":" + Resources.WROUGHT_IRON_CHUNK)
	public static WroughtIronChunkItem WROUGHT_IRON_CHUNK;
	@ObjectHolder(ROPMod.MODID+ ":" + Resources.STEEL_CHUNK)
	public static SteelChunkItem STEEL_CHUNK;
	@ObjectHolder(ROPMod.MODID+ ":" + Resources.HOT_STEEL_CHUNK)
	public static HotSteelChunkItem HOT_STEEL_CHUNK;


	@ObjectHolder(ROPMod.MODID + ":" + Resources.SLAG)
	public static SlagItem SLAG;

	@ObjectHolder(ROPMod.MODID + ":" + Resources.PIPE)
	public static PipeItem PIPE;

	@ObjectHolder(ROPMod.MODID + ":" + Resources.BLOOM)
	public static BloomItem BLOOM;
	@ObjectHolder(ROPMod.MODID + ":" + Resources.WROUGHT_IRON_CARBON_COMPOUND)
	public static WroughtIronCarbonCompoundItem WROUGHT_IRON_CARBON_COMPOUND;
	@ObjectHolder(ROPMod.MODID + ":" + Resources.IRON_ORE_CHUNK)
	public static IronOreChunkItem IRON_ORE_CHUNK;

	@ObjectHolder(ROPMod.MODID + ":" + Resources.HAMMER)
	public static HammerItem HAMMER;
	@ObjectHolder(ROPMod.MODID + ":" + Resources.CHISEL)
	public static ChiselItem CHISEL;

}
