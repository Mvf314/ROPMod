package mvf314.realisticoreprocessing.setup;

import mvf314.mvflib.setup.RegistryMap;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import mvf314.realisticoreprocessing.Resources;
import mvf314.realisticoreprocessing.items.HammerItem;
import mvf314.realisticoreprocessing.items.SlagItem;
import mvf314.realisticoreprocessing.items.SteelIngotItem;
import mvf314.realisticoreprocessing.items.WroughtIronIngotItem;
import mvf314.realisticoreprocessing.modules.bloomery.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

	public ItemGroup itemGroup;
	public RegistryMap registryMap;

	public ModSetup() {
		itemGroup = new ItemGroup(ROPMod.MODID) {
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ModItems.WROUGHT_IRON_INGOT);
			}
		};
		registryMap = new RegistryMap(new Item.Properties().group(itemGroup));

		populateRegistryMap();
	}

	private void populateRegistryMap() {

		registryMap.put(BloomBlock.class.getName(),		Resources.BLOOM_BLOCK);
		registryMap.put(BloomeryBlock.class.getName(),	Resources.BLOOMERY);
		registryMap.put(BellowsBlock.class.getName(),	Resources.BELLOWS);

		registryMap.put(WroughtIronIngotItem.class.getName(),	Resources.WROUGHT_IRON_INGOT);
		registryMap.put(SteelIngotItem.class.getName(),			Resources.STEEL_INGOT);
		registryMap.put(SlagItem.class.getName(),				Resources.SLAG);

		registryMap.put(WroughtIronCarbonCompoundItem.class.getName(),	Resources.WROUGHT_IRON_CARBON_COMPOUND);
		registryMap.put(BloomItem.class.getName(),						Resources.BLOOM);
		registryMap.put(HotSteelIngotItem.class.getName(),				Resources.HOT_STEEL_INGOT);

		registryMap.put(HammerItem.class.getName(),				Resources.HAMMER);

		registryMap.print();
	}
}
