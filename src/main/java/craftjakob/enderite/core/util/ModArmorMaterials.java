package craftjakob.enderite.core.util;

import java.util.function.Supplier;

import craftjakob.enderite.Enderite;
import craftjakob.enderite.core.init.ModItems;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("deprecation")
public enum ModArmorMaterials implements ArmorMaterial { 
	   ENDERITE("enderite", 42, new int[]{4, 7, 9, 4}, 25, //Boots, Leggings, Chestplate, Helmet
			   SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.1F, () -> {
		      return Ingredient.of(ModItems.ENDERITE_INGOT.get());
		   }),
	   GILDED_ENDERITE("gilded_enderite", 44, new int[]{4, 7, 9, 4}, 30,
			   SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () -> {
		      return Ingredient.of(ModItems.ENDERITE_INGOT.get());
		   });

		   private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
		   private final String name;
		   private final int durabilityMultiplier;
		   private final int[] slotProtections;
		   private final int enchantmentValue;
		   private final SoundEvent sound;
		   private final float toughness;
		   private final float knockbackResistance;
		   private final LazyLoadedValue<Ingredient> repairIngredient;

		   private ModArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		      this.name = name;
		      this.durabilityMultiplier = durabilityMultiplier;
		      this.slotProtections = slotProtections;
		      this.enchantmentValue = enchantmentValue;
		      this.sound = sound;
		      this.toughness = toughness;
		      this.knockbackResistance = knockbackResistance;
		      this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
		   }
		   public int getDurabilityForType(Type type) {
		     return HEALTH_PER_SLOT[type.getSlot().getIndex()] * this.durabilityMultiplier;
		   }
		   public int getDefenseForType(Type type) {
		     return this.slotProtections[type.getSlot().getIndex()];
		   }
		   public int getEnchantmentValue() {
		      return this.enchantmentValue;
		   }
		   public SoundEvent getEquipSound() {
		      return this.sound;
		   }
		   public Ingredient getRepairIngredient() {
		      return this.repairIngredient.get();
		   }
		   public String getName() {
		      return Enderite.MODID + ":" + this.name;
		   }
		   public float getToughness() {
		      return this.toughness;
		   }
		   public float getKnockbackResistance() {
		      return this.knockbackResistance;
		   }
		}