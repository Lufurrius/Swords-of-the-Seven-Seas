package com.lufurrius.swordsofthesevenseas.registry;

import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import com.lufurrius.swordsofthesevenseas.Swords_of_the_Seven_Seas;
import net.mcreator.undead_unleashed.init.UndeadUnleashedModItems;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Swords_of_the_Seven_Seas.MODID);


    //public static final RegistryObject<Item> WOODEN_CUTLASS = ITEMS.register("wooden_cutlass",
    //        () -> new CutlassItem(Tiers.WOOD, 2, 0,
    //                new Item.Properties()));

    //public static final RegistryObject<Item> STONE_CUTLASS = ITEMS.register("stone_cutlass",
    //        () -> new CutlassItem(Tiers.STONE, 1, 0,
    //                new Item.Properties()));

    public static final RegistryObject<Item> IRON_CUTLASS = ITEMS.register("iron_cutlass",
            () -> new CutlassItem(Tiers.IRON, 1, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_CUTLASS = ITEMS.register("golden_cutlass",
            () -> new CutlassItem(Tiers.GOLD, 2, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_CUTLASS = ITEMS.register("diamond_cutlass",
            () -> new CutlassItem(Tiers.DIAMOND, 1, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_CUTLASS = ITEMS.register("netherite_cutlass",
            () -> new CutlassItem(Tiers.NETHERITE, 1, 0,
                    new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> EMERALD_CUTLASS = ITEMS.register("emerald_cutlass",
            () -> new CutlassItem(new Tier() {
                public int getUses() {
                    return 127;
                }

                public float getSpeed() {
                    return 8.0F;
                }

                public float getAttackDamageBonus() {
                    return 3.0F;
                }

                public int getLevel() {
                    return 3;
                }

                public int getEnchantmentValue() {
                    return 12;
                }

                public Ingredient getRepairIngredient() {
                    return Ingredient.of(new ItemStack(Items.EMERALD));
                }
            }, 1, 0.1F,
                    new Item.Properties().rarity(Rarity.UNCOMMON)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
