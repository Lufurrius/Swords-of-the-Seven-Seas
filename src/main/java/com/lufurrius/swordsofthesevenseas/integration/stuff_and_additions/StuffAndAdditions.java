package com.lufurrius.swordsofthesevenseas.integration.stuff_and_additions;

import com.lufurrius.swordsofthesevenseas.Swords_of_the_Seven_Seas;
import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import com.teamabnormals.caverns_and_chasms.core.other.CCTiers.CCItemTiers;
import net.mcreator.createstuffadditions.init.CreateSaModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.RegistryObject;

import static com.lufurrius.swordsofthesevenseas.registry.ModItems.ITEMS;

public class StuffAndAdditions {
    public static final RegistryObject<Item> EXPERIENCE_CUTLASS = ITEMS.register("experience_cutlass",
            () -> new ExperienceCutlassItem(new Tier() {
                public int getUses() {
                    return 270;
                }

                public float getSpeed() {
                    return 0;
                }

                public float getAttackDamageBonus() {
                    return 1.5F;
                }

                public int getLevel() {
                    return 2;
                }

                public int getEnchantmentValue() {
                    return 800;
                }

                public Ingredient getRepairIngredient() {
                    return Ingredient.of(new ItemStack(CreateSaModItems.HEAP_OF_EXPERIENCE.get()));
                }
            }, 1, 0.3F,
                    new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> COPPER_CUTLASS = ITEMS.register("copper_cutlass",
            () -> new CutlassItem(new Tier() {
                public int getUses() {
                    return 131;
                }

                public float getSpeed() {
                    return 0;
                }

                public float getAttackDamageBonus() {
                    return 2.0F;
                }

                public int getLevel() {
                    return 2;
                }

                public int getEnchantmentValue() {
                    return 11;
                }

                public Ingredient getRepairIngredient() {
                    return Ingredient.of(new ItemStack(Items.COPPER_INGOT));
                }
            }, 1, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> BRASS_CUTLASS = ITEMS.register("brass_cutlass",
            () -> new CutlassItem(new Tier() {
                public int getUses() {
                    return 450;
                }

                public float getSpeed() {
                    return 0;
                }

                public float getAttackDamageBonus() {
                    return 3.0F;
                }

                public int getLevel() {
                    return 3;
                }

                public int getEnchantmentValue() {
                    return 14;
                }

                public Ingredient getRepairIngredient() {
                    return Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/brass")));
                }
                }, 1, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> ZINC_CUTLASS = ITEMS.register("zinc_cutlass",
            () -> new CutlassItem(new Tier() {
                public int getUses() {
                    return 250;
                }

                public float getSpeed() {
                    return 0;
                }

                public float getAttackDamageBonus() {
                    return 2.0F;
                }

                public int getLevel() {
                    return 2;
                }

                public int getEnchantmentValue() {
                    return 11;
                }

                public Ingredient getRepairIngredient() {
                    return Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/zinc")));
                }
            }, 1, 0.1F,
                    new Item.Properties()));

    public static final RegistryObject<Item> ROSE_QUARTZ_CUTLASS = ITEMS.register("rose_quartz_cutlass",
            () -> new CutlassItem(new Tier() {
                public int getUses() {
                    return 1644;
                }

                public float getSpeed() {
                    return 0;
                }

                public float getAttackDamageBonus() {
                    return 4.0F;
                }

                public int getLevel() {
                    return 3;
                }

                public int getEnchantmentValue() {
                    return 14;
                }

                public Ingredient getRepairIngredient() {
                    return Ingredient.of(new ItemStack(Items.GOLD_INGOT), new ItemStack(Items.QUARTZ));
                }
            }, 1, 0.1F,
                    new Item.Properties()));



    public static void register() {

    }

}
