package mvf314.realisticoreprocessing.items.chunk;

import mvf314.mvflib.datagen.ItemModelGenerator;
import mvf314.mvflib.item.BaseItem;
import mvf314.mvflib.item.ItemPropertyProvider;
import mvf314.mvflib.tools.IClientColor;
import mvf314.realisticoreprocessing.ROPMod;

public abstract class MetalChunkItem extends BaseItem implements IClientColor {

	private final int color;

	public MetalChunkItem(int color) {
		super(ItemPropertyProvider.get(ROPMod.setup.itemGroup), ROPMod.setup.registryMap);
		this.color = color;
	}

	@Override
	public String getItemModel(String modid) {
		return ItemModelGenerator.get(modid + ":item/template_metal_chunk");
	}

	@Override
	public int getColor() {
		return color;
	}
}
