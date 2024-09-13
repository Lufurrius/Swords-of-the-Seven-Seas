package com.lufurrius.swordsofthesevenseas.integration.oreganized;

import com.lufurrius.swordsofthesevenseas.Swords_of_the_Seven_Seas;
import galena.oreganized.index.OItemTiers;
import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import galena.oreganized.index.OItems;
import net.mcreator.createstuffadditions.init.CreateSaModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.RegistryObject;

import static com.lufurrius.swordsofthesevenseas.registry.ModItems.ITEMS;

public class Oreganized {
    public static final RegistryObject<Item> ELECTRUM_CUTLASS = ITEMS.register("electrum_cutlass",
            () -> new CutlassItem(OItemTiers.ELECTRUM, 1, 0.1F,
                    new Item.Properties()));

    public static final RegistryObject<Item> LEAD_CUTLASS = ITEMS.register("lead_cutlass",
            () -> new LeadCutlassItem(new Tier() {
                public int getUses() {
                    return 48;
                }

                public float getSpeed() {
                    return 4.0F;
                }

                public float getAttackDamageBonus() {
                    return 1.5F;
                }

                public int getLevel() {
                    return 1;
                }

                public int getEnchantmentValue() {
                    return 5;
                }

                public Ingredient getRepairIngredient() {
                    return Ingredient.of(new ItemStack(OItems.LEAD_INGOT.get()));
                }
            }, 0, -0.4F,
                    new Item.Properties()));



    public static void register() {

    }
}
