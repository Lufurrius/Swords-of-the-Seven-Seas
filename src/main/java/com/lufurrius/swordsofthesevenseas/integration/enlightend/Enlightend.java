package com.lufurrius.swordsofthesevenseas.integration.enlightend;

import com.lufurrius.swordsofthesevenseas.Swords_of_the_Seven_Seas;
import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.RegistryObject;

import static com.lufurrius.swordsofthesevenseas.registry.ModItems.ITEMS;

public class Enlightend {
    public static final RegistryObject<Item> ADAMANTITE_CUTLASS = ITEMS.register("adamantite_cutlass",
            () -> new CutlassItem(new Tier() {
                public int getUses() {
                    return 1561;
                }

                public float getSpeed() {
                    return 14.0F;
                }

                public float getAttackDamageBonus() {
                    return 5.0F;
                }

                public int getLevel() {
                    return 5;
                }

                public int getEnchantmentValue() {
                    return 15;
                }

                public Ingredient getRepairIngredient() {
                    return Ingredient.of(new ItemStack(EnlightenedEndModItems.ADAMANTITE_INGOT.get()));
                }
            }, 1, 0,
                    new Item.Properties()));

    public static void register() {

    }
}
