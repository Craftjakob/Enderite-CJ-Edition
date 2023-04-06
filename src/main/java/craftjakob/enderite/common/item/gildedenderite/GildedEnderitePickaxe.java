package craftjakob.enderite.common.item.gildedenderite;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

	
public class GildedEnderitePickaxe extends PickaxeItem {
	public GildedEnderitePickaxe(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_) {
		super(p_42961_, p_42962_, p_42963_, p_42964_);
	}
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag tooltipFlag) {
		if(Screen.hasShiftDown()) {
			components.add(Component.literal("Only with Gilded Netherite CJ Edition").withStyle(ChatFormatting.DARK_RED));
		}
		super.appendHoverText(stack, level, components, tooltipFlag);
	}
}
