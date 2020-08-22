package mvf314.realisticoreprocessing;

import mvf314.realisticoreprocessing.items.HammerItem;
import mvf314.realisticoreprocessing.items.SlagItem;
import mvf314.realisticoreprocessing.items.SteelIngotItem;
import mvf314.realisticoreprocessing.items.WroughtIronIngotItem;
import mvf314.realisticoreprocessing.modules.bloomery.BloomItem;
import mvf314.realisticoreprocessing.modules.bloomery.HotSteelIngotItem;
import mvf314.realisticoreprocessing.modules.bloomery.WroughtIronCarbonCompoundItem;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {

	@ObjectHolder(ROPMod.MODID + ":" + Resources.WROUGHT_IRON_INGOT)
	public static WroughtIronIngotItem WROUGHT_IRON_INGOT;
	@ObjectHolder(ROPMod.MODID + ":" + Resources.STEEL_INGOT)
	public static SteelIngotItem STEEL_INGOT;
	@ObjectHolder(ROPMod.MODID + ":" + Resources.SLAG)
	public static SlagItem SLAG;

	@ObjectHolder(ROPMod.MODID + ":" + Resources.BLOOM)
	public static BloomItem BLOOM;
	@ObjectHolder(ROPMod.MODID + ":" + Resources.WROUGHT_IRON_CARBON_COMPOUND)
	public static WroughtIronCarbonCompoundItem WROUGHT_IRON_CARBON_COMPOUND;
	@ObjectHolder(ROPMod.MODID + ":" + Resources.HOT_STEEL_INGOT)
	public static HotSteelIngotItem HOT_STEEL_INGOT;

	@ObjectHolder(ROPMod.MODID + ":" + Resources.HAMMER)
	public static HammerItem HAMMER;

}
