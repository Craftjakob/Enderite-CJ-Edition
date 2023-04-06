package craftjakob.enderite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import craftjakob.enderite.common.item.EnderiteElytraChestplate;
import craftjakob.enderite.core.ModCreativeModeTabs;
import craftjakob.enderite.core.init.ModBlocks;
import craftjakob.enderite.core.init.ModItems;
import craftjakob.enderite.core.util.models.EnderiteElytraChestplateLayer;
import craftjakob.enderite.core.util.models.GildedEnderiteElytraChestplateLayer;
import craftjakob.enderite.loot.ModLootModifiers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Enderite.MODID)
public class Enderite {
    public static final String MODID = "enderite";
    private static final Logger LOGGER = LogManager.getLogger();

    public Enderite() {
    	IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModLootModifiers.register(eventBus);
        
        eventBus.addListener(this::commensetup);
        eventBus.addListener(this::addCreative);
    }
    private void commensetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Enderite is detected!");
        
        event.enqueueWork(() -> {
    	ModItems.ITEMS.getEntries().forEach(item -> {
    		ItemProperties.register(item.get() , new ResourceLocation("broken"), (ItemStack, ClientLevel, LivingEntity, p_174593_) -> {
    				return EnderiteElytraChestplate.isFlyEnabled(ItemStack) ? 0.0F : 1.0F;
    			});
    		});
        });
    }
    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTabs.ENDERITE_TAB) {
            event.accept(ModItems.RAW_ENDERITE);
            event.accept(ModItems.ENDERITE_SCRAP);
            event.accept(ModItems.ENDERITE_INGOT);
            event.accept(ModItems.RAW_ENDERITE_BLOCK_ITEM);
            event.accept(ModItems.ENDERITE_ORE_ITEM);
            event.accept(ModItems.ENDERITE_BLOCK_ITEM);
            event.accept(ModItems.ENDERITE_HELMET);
            event.accept(ModItems.ENDERITE_CHESTPLATE);
            event.accept(ModItems.ENDERITE_LEGGINGS);
            event.accept(ModItems.ENDERITE_BOOTS);
            event.accept(ModItems.ENDERITE_ELYTRA_CHESTPLATE);
            event.accept(ModItems.ENDERITE_SWORD);
            event.accept(ModItems.ENDERITE_PICKAXE);
            event.accept(ModItems.ENDERITE_AXE);
            event.accept(ModItems.ENDERITE_SHOVEL);
            event.accept(ModItems.ENDERITE_HOE);
            //event.accept(ModItems.END_RESPAWN_ANCHOR);
            
            event.accept(ModItems.GILDED_ENDERITE_HELMET);
            event.accept(ModItems.GILDED_ENDERITE_CHESTPLATE);
            event.accept(ModItems.GILDED_ENDERITE_LEGGINGS);
            event.accept(ModItems.GILDED_ENDERITE_BOOTS);
            event.accept(ModItems.GILDED_ENDERITE_ELYTRA_CHESTPLATE);
            event.accept(ModItems.GILDED_ENDERITE_SWORD);
            event.accept(ModItems.GILDED_ENDERITE_PICKAXE);
            event.accept(ModItems.GILDED_ENDERITE_AXE);
            event.accept(ModItems.GILDED_ENDERITE_SHOVEL);
            event.accept(ModItems.GILDED_ENDERITE_HOE);
            event.accept(ModItems.GILDED_ENDERITE_BLOCK_ITEM);
        }
    }
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class RegistryEventsClient {
    	
	    @SubscribeEvent(priority = EventPriority.LOW)
	    public static void renderPlayerEEC(final EntityRenderersEvent.AddLayers event) {
	        //default
	        LivingEntityRenderer<Player, PlayerModel<Player>> renderer = event.getSkin("default");
	        EnderiteElytraChestplateLayer<Player, PlayerModel<Player>> layer = new EnderiteElytraChestplateLayer<>(renderer, event.getEntityModels());
	        if (renderer != null) {
	            
	            renderer.addLayer(layer);
	        } else {
	            LOGGER.error("Couldn't get renderer");
	        }
	        //Slim
	        renderer = event.getSkin("slim");
	        layer = new EnderiteElytraChestplateLayer<>(renderer, event.getEntityModels());
	        if (renderer != null) {
	            
	            renderer.addLayer(layer);
	        } else {
	            LOGGER.error("Couldn't get renderer");
	        }
	        addEntityLayerEEC(event, EntityType.ARMOR_STAND);
	        addEntityLayerEEC(event, EntityType.ZOMBIE);
	        addEntityLayerEEC(event, EntityType.ZOMBIE_VILLAGER);
	        addEntityLayerEEC(event, EntityType.SKELETON);
	        addEntityLayerEEC(event, EntityType.HUSK);
	        addEntityLayerEEC(event, EntityType.STRAY);
	        addEntityLayerEEC(event, EntityType.WITHER_SKELETON);
	        addEntityLayerEEC(event, EntityType.DROWNED);
	        addEntityLayerEEC(event, EntityType.PIGLIN);
	        addEntityLayerEEC(event, EntityType.PIGLIN_BRUTE);
	        addEntityLayerEEC(event, EntityType.ZOMBIFIED_PIGLIN);
	    }
	    private static <T extends LivingEntity, M extends HumanoidModel<T>, R extends LivingEntityRenderer<T, M>> void addEntityLayerEEC(EntityRenderersEvent.AddLayers evt, EntityType<? extends T> entityType) {
	        R renderer = evt.getRenderer(entityType);
	
	        if (renderer != null) {
	            renderer.addLayer(new EnderiteElytraChestplateLayer<>(renderer, evt.getEntityModels()));
	        }
	    }
	    @SubscribeEvent(priority = EventPriority.LOW)
	    public static void renderPlayerGEEC(final EntityRenderersEvent.AddLayers event) {
	        //default
	        LivingEntityRenderer<Player, PlayerModel<Player>> renderer = event.getSkin("default");
	        GildedEnderiteElytraChestplateLayer<Player, PlayerModel<Player>> layer = new GildedEnderiteElytraChestplateLayer<>(renderer, event.getEntityModels());
	        if (renderer != null) {
	            
	            renderer.addLayer(layer);
	        } else {
	            LOGGER.error("Couldn't get renderer");
	        }
	        //Slim
	        renderer = event.getSkin("slim");
	        layer = new GildedEnderiteElytraChestplateLayer<>(renderer, event.getEntityModels());
	        if (renderer != null) {
	            
	            renderer.addLayer(layer);
	        } else {
	            LOGGER.error("Couldn't get renderer");
	        }
	        addEntityLayerGEEC(event, EntityType.ARMOR_STAND);
	        addEntityLayerGEEC(event, EntityType.ZOMBIE);
	        addEntityLayerGEEC(event, EntityType.ZOMBIE_VILLAGER);
	        addEntityLayerGEEC(event, EntityType.SKELETON);
	        addEntityLayerGEEC(event, EntityType.HUSK);
	        addEntityLayerGEEC(event, EntityType.STRAY);
	        addEntityLayerGEEC(event, EntityType.WITHER_SKELETON);
	        addEntityLayerGEEC(event, EntityType.DROWNED);
	        addEntityLayerGEEC(event, EntityType.PIGLIN);
	        addEntityLayerGEEC(event, EntityType.PIGLIN_BRUTE);
	        addEntityLayerGEEC(event, EntityType.ZOMBIFIED_PIGLIN);
	    }
	    private static <T extends LivingEntity, M extends HumanoidModel<T>, R extends LivingEntityRenderer<T, M>> void addEntityLayerGEEC(EntityRenderersEvent.AddLayers evt, EntityType<? extends T> entityType) {
	        R renderer = evt.getRenderer(entityType);
	
	        if (renderer != null) {
	            renderer.addLayer(new GildedEnderiteElytraChestplateLayer<>(renderer, evt.getEntityModels()));
	        }
	    }
    }
}