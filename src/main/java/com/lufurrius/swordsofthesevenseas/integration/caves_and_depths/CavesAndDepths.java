package com.lufurrius.swordsofthesevenseas.integration.caves_and_depths;

import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.RegistryObject;

import static com.lufurrius.swordsofthesevenseas.registry.ModItems.ITEMS;

public class CavesAndDepths {
    public static final RegistryObject<Item> ROSE_GOLD_CUTLASS = ITEMS.register("rose_gold_cutlass",
            () -> new CutlassItem(new Tier() {
                public int getUses() {
                    return 200;
                }

                public float getSpeed() {
                    return 0.0F;
                }

                public float getAttackDamageBonus() {
                    return 4.1F;
                }

                public int getLevel() {
                    return 0;
                }

                public int getEnchantmentValue() {
                    return 24;
                }

                public Ingredient getRepairIngredient() {
                    return Ingredient.of(new ItemStack(Items.GOLD_INGOT), new ItemStack(Items.COPPER_INGOT));
                }
            }, 1, 0, (new Item.Properties())));

    public static void register() {

    }
}
