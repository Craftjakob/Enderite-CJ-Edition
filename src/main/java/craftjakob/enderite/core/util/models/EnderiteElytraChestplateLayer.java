package craftjakob.enderite.core.util.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import craftjakob.enderite.Enderite;
import craftjakob.enderite.core.init.ModItems;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Enderite.MODID, bus = Bus.MOD)
public class EnderiteElytraChestplateLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
	   private static final ResourceLocation WINGS_LOCATION = new ResourceLocation(Enderite.MODID, "textures/entity/enderite_elytra_chestplate.png");
	   private final ElytraModel<T> elytraModel;
	
	   public EnderiteElytraChestplateLayer(RenderLayerParent<T, M> p_174493_, EntityModelSet p_174494_) {
		      super(p_174493_);
		      this.elytraModel = new ElytraModel<>(p_174494_.bakeLayer(ModelLayers.ELYTRA));
		   }

		   public void render(PoseStack p_116951_, MultiBufferSource p_116952_, int p_116953_, T p_116954_, float p_116955_, float p_116956_, float p_116957_, float p_116958_, float p_116959_, float p_116960_) {
		      ItemStack itemstack = p_116954_.getItemBySlot(EquipmentSlot.CHEST);
		      if (shouldRender(itemstack, p_116954_)) {
		         ResourceLocation resourcelocation;
		         if (p_116954_ instanceof AbstractClientPlayer) {
		            AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer)p_116954_;
		            if (abstractclientplayer.isElytraLoaded() && abstractclientplayer.getElytraTextureLocation() != null) {
		               resourcelocation = abstractclientplayer.getElytraTextureLocation();
		            } else if (abstractclientplayer.isCapeLoaded() && abstractclientplayer.getCloakTextureLocation() != null && abstractclientplayer.isModelPartShown(PlayerModelPart.CAPE)) {
		               resourcelocation = abstractclientplayer.getCloakTextureLocation();
		            } else {
		               resourcelocation = getElytraTexture(itemstack, p_116954_);
		            }
		         } else {
		            resourcelocation = getElytraTexture(itemstack, p_116954_);
		         }

		         p_116951_.pushPose();
		         p_116951_.translate(0.0F, 0.0F, 0.125F);
		         this.getParentModel().copyPropertiesTo(this.elytraModel);
		         this.elytraModel.setupAnim(p_116954_, p_116955_, p_116956_, p_116958_, p_116959_, p_116960_);
		         VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(p_116952_, RenderType.armorCutoutNoCull(resourcelocation), false, itemstack.hasFoil());
		         this.elytraModel.renderToBuffer(p_116951_, vertexconsumer, p_116953_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		         p_116951_.popPose();
		      }
		   }

		   public boolean shouldRender(ItemStack stack, T entity) {
		      return stack.getItem() == ModItems.ENDERITE_ELYTRA_CHESTPLATE.get();
		   }

		   public ResourceLocation getElytraTexture(ItemStack stack, T entity) {
		      return WINGS_LOCATION;
		   }   	
}
