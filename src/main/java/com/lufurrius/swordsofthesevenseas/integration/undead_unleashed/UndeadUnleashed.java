package com.lufurrius.swordsofthesevenseas.integration.undead_unleashed;

import com.lufurrius.swordsofthesevenseas.Swords_of_the_Seven_Seas;
import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import galena.oreganized.index.OItems;
import net.mcreator.undead_unleashed.init.UndeadUnleashedModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.RegistryObject;

import static com.lufurrius.swordsofthesevenseas.registry.ModItems.ITEMS;

public class UndeadUnleashed {
    public static final RegistryObject<Item> GRAVE_METAL_CUTLASS = ITEMS.register("grave_metal_cutlass",
            () -> new CutlassItem(new Tier() {
                public int getUses() {
                    return 540;
                }

                public float getSpeed() {
                    return 6.0F;
                }

                public float getAttackDamageBonus() {
                    return 2.0F;
                }

                public int getLevel() {
                    return 2;
                }

                public int getEnchantmentValue() {
                    return 18;
                }

                public Ingredient getRepairIngredient() {
                    return Ingredient.of(new ItemStack(UndeadUnleashedModItems.GRAVE_METAL_INGOT.get()));
                }
            }, 1, 0,
                    new Item.Properties()));

    public static void register() {

    }
}
