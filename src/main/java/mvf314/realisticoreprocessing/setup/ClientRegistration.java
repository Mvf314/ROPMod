package mvf314.realisticoreprocessing.setup;

import mvf314.mvflib.setup.Registry;
import mvf314.realisticoreprocessing.ModItems;
import mvf314.realisticoreprocessing.ROPMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ROPMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistration {
	@SubscribeEvent
	public static void onItemColor(ColorHandlerEvent.Item event) {
		Registry.Items.registerItemColor(event, ModItems.WROUGHT_IRON_CHUNK);
		Registry.Items.registerItemColor(event, ModItems.STEEL_CHUNK);
		Registry.Items.registerItemColor(event, ModItems.HOT_STEEL_CHUNK);
	}
}
