package mvf314.realisticoreprocessing.setup;

import mvf314.mvflib.setup.Registry;
import mvf314.mvflib.setup.RegistryMap;
import mvf314.realisticoreprocessing.ModBlocks;
import mvf314.realisticoreprocessing.ROPMod;
import mvf314.realisticoreprocessing.items.HammerItem;
import mvf314.realisticoreprocessing.items.SlagItem;
import mvf314.realisticoreprocessing.items.SteelIngotItem;
import mvf314.realisticoreprocessing.items.WroughtIronIngotItem;
import mvf314.realisticoreprocessing.modules.bloomery.*;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registration {
	private static final RegistryMap map = ROPMod.setup.registryMap;
	private static final String MODID = ROPMod.MODID;

	@SubscribeEvent
	public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {

		Registry.Blocks.register(event, new BloomBlock());
		Registry.Blocks.register(event, new BloomeryBlock());
		Registry.Blocks.register(event, new BellowsBlock());

	}

	@SubscribeEvent
	public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {

		Registry.Blocks.registerItem(event, ModBlocks.BLOOM, map);
		Registry.Blocks.registerItem(event, ModBlocks.BLOOMERY, map);
		Registry.Blocks.registerItem(event, ModBlocks.BELLOWS, map);

		Registry.Items.register(event, new WroughtIronIngotItem());
		Registry.Items.register(event, new SteelIngotItem());
		Registry.Items.register(event, new SlagItem());

		Registry.Items.register(event, new BloomItem());
		Registry.Items.register(event, new WroughtIronCarbonCompoundItem());
		Registry.Items.register(event, new HotSteelIngotItem());

		Registry.Items.register(event, new HammerItem());
	}

	@SubscribeEvent
	public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
		Registry.TileEntities.register(event, BloomeryTile::new, ModBlocks.BLOOMERY, map);
		Registry.TileEntities.register(event, BellowsTile::new, ModBlocks.BELLOWS, map);
	}

	@SubscribeEvent
	public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
	}

	@SubscribeEvent
	public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {

	}
}