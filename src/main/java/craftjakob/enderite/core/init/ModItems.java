package craftjakob.enderite.core.init;

import craftjakob.enderite.Enderite;
import craftjakob.enderite.common.block.gildedenderite.GildedEnderiteBlock;
import craftjakob.enderite.common.item.EnderiteArmor;
import craftjakob.enderite.common.item.EnderiteElytraChestplate;
import craftjakob.enderite.common.item.gildedenderite.GildedEnderiteArmor;
import craftjakob.enderite.common.item.gildedenderite.GildedEnderiteAxe;
import craftjakob.enderite.common.item.gildedenderite.GildedEnderiteElytraChestplate;
import craftjakob.enderite.common.item.gildedenderite.GildedEnderiteHoe;
import craftjakob.enderite.common.item.gildedenderite.GildedEnderitePickaxe;
import craftjakob.enderite.common.item.gildedenderite.GildedEnderiteShovel;
import craftjakob.enderite.common.item.gildedenderite.GildedEnderiteSword;
import craftjakob.enderite.core.util.ModArmorMaterials;
import craftjakob.enderite.core.util.ModTiers;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Enderite.MODID);
    
    // Material
    public static final RegistryObject<Item> RAW_ENDERITE = ITEMS.register("raw_enderite",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.RARE)));

    // Armor
    public static final RegistryObject<Item> ENDERITE_HELMET = ITEMS.register("enderite_helmet",
    		() -> new EnderiteArmor(ModArmorMaterials.ENDERITE, Type.HELMET, new Item.Properties()
    				.fireResistant().rarity(Rarity.EPIC)));
    
    public static final RegistryObject<Item> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate",
    		() -> new EnderiteArmor(ModArmorMaterials.ENDERITE, Type.CHESTPLATE, new Item.Properties()
    				.fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERITE_ELYTRA_CHESTPLATE = ITEMS.register("enderite_elytra_chestplate",
    		() -> new EnderiteElytraChestplate(ModArmorMaterials.ENDERITE, Type.CHESTPLATE, new Item.Properties()
    				.fireResistant().rarity(Rarity.EPIC)));
    
    public static final RegistryObject<Item> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings",
    		() -> new EnderiteArmor(ModArmorMaterials.ENDERITE, Type.LEGGINGS, new Item.Properties()
    				.fireResistant().rarity(Rarity.EPIC)));
    
    public static final RegistryObject<Item> ENDERITE_BOOTS = ITEMS.register("enderite_boots",
    		() -> new EnderiteArmor(ModArmorMaterials.ENDERITE, Type.BOOTS, new Item.Properties()
    				.fireResistant().rarity(Rarity.EPIC)));

    // Tools
    public static final RegistryObject<Item> ENDERITE_SWORD = ITEMS.register("enderite_sword",
            () -> new SwordItem(ModTiers.ENDERITE, 3, -2.4F,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe",
            () -> new PickaxeItem(ModTiers.ENDERITE, 1, -2.8f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERITE_AXE = ITEMS.register("enderite_axe",
            () -> new AxeItem(ModTiers.ENDERITE, 5f, -3f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel",
            () -> new ShovelItem(ModTiers.ENDERITE, 1.5f, -3f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERITE_HOE = ITEMS.register("enderite_hoe",
            () -> new HoeItem(ModTiers.ENDERITE, -5, 0f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
   
   // BlockItems
    public static final RegistryObject<BlockItem> ENDERITE_ORE_ITEM = ITEMS.register("enderite_ore", 
    		() -> new BlockItem(ModBlocks.ENDERITE_ORE.get(), 
    				new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    
    public static final RegistryObject<BlockItem> RAW_ENDERITE_BLOCK_ITEM = ITEMS.register("raw_enderite_block", 
    		() -> new BlockItem(ModBlocks.RAW_ENDERITE_BLOCK.get(), 
    				new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    
    public static final RegistryObject<BlockItem> ENDERITE_BLOCK_ITEM = ITEMS.register("enderite_block", 
    		() -> new GildedEnderiteBlock(ModBlocks.ENDERITE_BLOCK.get(), 
    				new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    
    public static final RegistryObject<BlockItem> END_RESPAWN_ANCHOR = ITEMS.register("end_respawn_anchor", 
    		() -> new BlockItem(ModBlocks.END_RESPAWN_ANCHOR.get(), 
    				new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    
    
    
    // Gilded Items
    // Armor
    public static final RegistryObject<Item> GILDED_ENDERITE_HELMET = ITEMS.register("gilded_enderite_helmet",
    		() -> new GildedEnderiteArmor(ModArmorMaterials.GILDED_ENDERITE, Type.HELMET, new Item.Properties()
    				.fireResistant().rarity(Rarity.EPIC)));
    
    public static final RegistryObject<Item> GILDED_ENDERITE_CHESTPLATE = ITEMS.register("gilded_enderite_chestplate",
    		() -> new GildedEnderiteArmor(ModArmorMaterials.GILDED_ENDERITE, Type.CHESTPLATE, new Item.Properties()
    				.fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GILDED_ENDERITE_ELYTRA_CHESTPLATE = ITEMS.register("gilded_enderite_elytra_chestplate",
    		() -> new GildedEnderiteElytraChestplate(ModArmorMaterials.GILDED_ENDERITE, Type.CHESTPLATE, new Item.Properties()
    				.fireResistant().rarity(Rarity.EPIC)));
    
    public static final RegistryObject<Item> GILDED_ENDERITE_LEGGINGS = ITEMS.register("gilded_enderite_leggings",
    		() -> new GildedEnderiteArmor(ModArmorMaterials.GILDED_ENDERITE, Type.LEGGINGS, new Item.Properties()
    				.fireResistant().rarity(Rarity.EPIC)));
    
    public static final RegistryObject<Item> GILDED_ENDERITE_BOOTS = ITEMS.register("gilded_enderite_boots",
    		() -> new GildedEnderiteArmor(ModArmorMaterials.GILDED_ENDERITE, Type.BOOTS, new Item.Properties()
    				.fireResistant().rarity(Rarity.EPIC)));
    // Tools
    public static final RegistryObject<Item> GILDED_ENDERITE_SWORD = ITEMS.register("gilded_enderite_sword",
            () -> new GildedEnderiteSword(ModTiers.GILDED_ENDERITE, 3, -2.4F,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GILDED_ENDERITE_PICKAXE = ITEMS.register("gilded_enderite_pickaxe",
            () -> new GildedEnderitePickaxe(ModTiers.GILDED_ENDERITE, 1, -2.8f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GILDED_ENDERITE_AXE = ITEMS.register("gilded_enderite_axe",
            () -> new GildedEnderiteAxe(ModTiers.GILDED_ENDERITE, 5f, -3f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GILDED_ENDERITE_SHOVEL = ITEMS.register("gilded_enderite_shovel",
            () -> new GildedEnderiteShovel(ModTiers.GILDED_ENDERITE, 1.5f, -3f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GILDED_ENDERITE_HOE = ITEMS.register("gilded_enderite_hoe",
            () -> new GildedEnderiteHoe(ModTiers.GILDED_ENDERITE, -5, 0f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    
    // Block
    public static final RegistryObject<BlockItem> GILDED_ENDERITE_BLOCK_ITEM = ITEMS.register("gilded_enderite_block", 
    		() -> new GildedEnderiteBlock(ModBlocks.GILDED_ENDERITE_BLOCK.get(), 
    				new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    
    public static void register(IEventBus eventBus) {
	ITEMS.register(eventBus);
	}
}

