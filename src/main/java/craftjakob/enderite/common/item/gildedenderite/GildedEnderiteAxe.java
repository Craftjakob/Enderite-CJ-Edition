package craftjakob.enderite.common.item.gildedenderite;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

	
public class GildedEnderiteAxe extends AxeItem {
	public GildedEnderiteAxe(Tier p_40521_, float p_40522_, float p_40523_, Properties p_40524_) {
		super(p_40521_, p_40522_, p_40523_, p_40524_);
	}
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag tooltipFlag) {
		if(Screen.hasShiftDown()) {
			components.add(Component.literal("Only with Gilded Netherite CJ Edition").withStyle(ChatFormatting.DARK_RED));
		}
		super.appendHoverText(stack, level, components, tooltipFlag);
	}
}
