package craftjakob.enderite.common.item.gildedenderite;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

	
public class GildedEnderiteHoe extends HoeItem {
	public GildedEnderiteHoe(Tier p_41336_, int p_41337_, float p_41338_, Properties p_41339_) {
		super(p_41336_, p_41337_, p_41338_, p_41339_);
	}
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag tooltipFlag) {
		if(Screen.hasShiftDown()) {
			components.add(Component.literal("Only with Gilded Netherite CJ Edition").withStyle(ChatFormatting.DARK_RED));
		}
		super.appendHoverText(stack, level, components, tooltipFlag);
	}
}
