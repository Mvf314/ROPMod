package mvf314.realisticoreprocessing.blocks;

import mvf314.mvflib.block.BlockPropertyProvider;
import mvf314.mvflib.block.HarvestLevel;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BrokenIronOreBlock extends BrokenOreBlock {

	public BrokenIronOreBlock() {
		super(BlockPropertyProvider.get(Material.ROCK, Material.ROCK.getColor(),
				SoundType.STONE,
				HarvestLevel.STONE, ToolType.PICKAXE,
				0, 6, 1.5f,
				0.6f, 1.0f, 1.0f,
				true, false, false, false));
		setLocale(lang, "Broken Iron Ore");
	}
}
