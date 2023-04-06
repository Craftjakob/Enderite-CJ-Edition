package craftjakob.enderite.core.util;

import craftjakob.enderite.core.init.ModItems;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers { //Harvest Level, Durability, Efficiency, Attack Damage, Enchantability 
    public static final ForgeTier ENDERITE = new ForgeTier(6, 2777, 11.0F, 6.0F, 25, 
    		BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.ENDERITE_INGOT.get()));
    public static final ForgeTier GILDED_ENDERITE = new ForgeTier(7, 3000, 12.0F, 7.0F, 30, 
    		BlockTags.NEEDS_DIAMOND_TOOL,
    		() -> Ingredient.of(ModItems.ENDERITE_INGOT.get()));
    //GILDED_NETHERITE = 5, 2555, 10.0F, 5.0F, 20 
    //NETHERITE = 4, 2031, 9.0F, 4.0F, 15,
}
