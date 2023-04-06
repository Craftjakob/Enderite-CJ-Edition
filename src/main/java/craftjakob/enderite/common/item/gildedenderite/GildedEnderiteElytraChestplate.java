package craftjakob.enderite.common.item.gildedenderite;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;

public class GildedEnderiteElytraChestplate extends ArmorItem {
    public GildedEnderiteElytraChestplate(ArmorMaterial material, Type slot, Properties properties) {
        super(material, slot, properties);
        DispenserBlock.registerBehavior(this, GildedEnderiteElytraChestplate.DISPENSE_ITEM_BEHAVIOR);
    }
    // Armor
    @Override
    public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
        return true;
    }
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }
    // Elytra
    public static boolean isFlyEnabled(ItemStack p_41141_) {
        return p_41141_.getDamageValue() < p_41141_.getMaxDamage() - 1;
     }
     public InteractionResultHolder<ItemStack> use(Level p_41137_, Player p_41138_, InteractionHand p_41139_) {
        return this.swapWithEquipmentSlot(this, p_41137_, p_41138_, p_41139_);
     }
     @Override
     public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return ElytraItem.isFlyEnabled(stack);
     }
     @Override
     public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        if (!entity.level.isClientSide) {
           int nextFlightTick = flightTicks + 1;
           if (nextFlightTick % 10 == 0) {
              if (nextFlightTick % 20 == 0) {
                 stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
              }
              entity.gameEvent(GameEvent.ELYTRA_GLIDE);
           }
        }
        return true;
     }
     @Override
     public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag tooltipFlag) {
         if(Screen.hasShiftDown()) {
     		components.add(Component.literal("Only with Gilded Netherite CJ Edition").withStyle(ChatFormatting.DARK_RED));
     	} else {
     		components.add(Component.translatable("tooltip.enderite.gilded_enderite_elytra_chestplate.description").withStyle(ChatFormatting.BLUE));
     	} 
     	super.appendHoverText(stack, level, components, tooltipFlag);
     }
}