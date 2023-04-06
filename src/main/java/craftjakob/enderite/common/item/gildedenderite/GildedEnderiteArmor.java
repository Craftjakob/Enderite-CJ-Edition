package craftjakob.enderite.common.item.gildedenderite;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class GildedEnderiteArmor extends ArmorItem {
    public GildedEnderiteArmor(ArmorMaterial material, Type slot, Properties properties) {
        super(material, slot, properties);
    }
    // Armor
    @Override
    public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
        return true;
    }
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer){
        return true;
    }
    public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
    		components.add(Component.literal("Only with Gilded Netherite CJ Edition").withStyle(ChatFormatting.DARK_RED));
    	} else {
    		components.add(Component.translatable("tooltip.enderite.gilded_enderite_armor.description").withStyle(ChatFormatting.BLUE));
    	} 
    	super.appendHoverText(stack, level, components, tooltipFlag);
    }
}