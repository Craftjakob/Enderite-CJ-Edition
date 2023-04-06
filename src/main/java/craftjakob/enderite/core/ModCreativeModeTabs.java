package craftjakob.enderite.core;

import craftjakob.enderite.Enderite;
import craftjakob.enderite.core.init.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

	@Mod.EventBusSubscriber(modid = Enderite.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public class ModCreativeModeTabs {
		public static CreativeModeTab ENDERITE_TAB;

		@SubscribeEvent
		public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
			ENDERITE_TAB = event.registerCreativeModeTab(new ResourceLocation(Enderite.MODID, "enderite_tab"),
				builder -> builder.icon(() -> new ItemStack(ModItems.ENDERITE_INGOT.get()))
					.title(Component.translatable("creativemodetab.enderite_tab")));
		}
}