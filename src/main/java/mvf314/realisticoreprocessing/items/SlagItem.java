package mvf314.realisticoreprocessing.items;

import mvf314.mvflib.item.BaseItem;
import mvf314.mvflib.item.ItemPropertyProvider;
import mvf314.realisticoreprocessing.ROPMod;

public class SlagItem extends BaseItem {
	public SlagItem() {
		super(ItemPropertyProvider.get(ROPMod.setup.itemGroup), ROPMod.setup.registryMap);
		setLocale(lang, "Slag");
	}
}
