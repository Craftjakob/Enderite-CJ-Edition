package craftjakob.enderite.common.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class EnderiteArmor extends ArmorItem {
    public EnderiteArmor(ArmorMaterial material, Type slot, Properties properties) {
        super(material, slot, properties);
    }
    @Override
    public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
        return true;
    }
    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag tooltipFlag) {
    	{
    		components.add(Component.translatable("tooltip.enderite.enderite_armor.description").withStyle(ChatFormatting.BLUE));
    	} 
    	super.appendHoverText(stack, level, components, tooltipFlag);
    }
}