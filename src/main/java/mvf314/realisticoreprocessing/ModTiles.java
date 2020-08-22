package mvf314.realisticoreprocessing;

import mvf314.realisticoreprocessing.modules.bloomery.BellowsTile;
import mvf314.realisticoreprocessing.modules.bloomery.BloomeryTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModTiles {

	@ObjectHolder(ROPMod.MODID + ":" + Resources.BLOOMERY)
	public static TileEntityType<BloomeryTile> BLOOMERY;

	@ObjectHolder(ROPMod.MODID + ":" + Resources.BELLOWS)
	public static TileEntityType<BellowsTile> BELLOWS;
}
