package craftjakob.enderite.common.item.gildedenderite;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
	

public class GildedEnderiteShovel extends ShovelItem {
	public GildedEnderiteShovel(Tier p_43114_, float p_43115_, float p_43116_, Properties p_43117_) {
		super(p_43114_, p_43115_, p_43116_, p_43117_);
	}
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag tooltipFlag) {
		if(Screen.hasShiftDown()) {
			components.add(Component.literal("Only with Gilded Netherite CJ Edition").withStyle(ChatFormatting.DARK_RED));
		}
		super.appendHoverText(stack, level, components, tooltipFlag);
	}
}
