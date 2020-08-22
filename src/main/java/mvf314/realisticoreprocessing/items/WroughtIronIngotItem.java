package mvf314.realisticoreprocessing.items;

import mvf314.mvflib.item.BaseItem;
import mvf314.mvflib.item.ItemPropertyProvider;
import mvf314.realisticoreprocessing.ROPMod;

public class WroughtIronIngotItem extends BaseItem {
	public WroughtIronIngotItem() {
		super(ItemPropertyProvider.get(ROPMod.setup.itemGroup), ROPMod.setup.registryMap);
		setLocale(lang, "Wrought Iron Ingot");
	}
}
