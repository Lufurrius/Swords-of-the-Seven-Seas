package com.lufurrius.swordsofthesevenseas.registry;

import com.lufurrius.swordsofthesevenseas.Swords_of_the_Seven_Seas;
import com.lufurrius.swordsofthesevenseas.enchantments.BalancedEnchantment;
import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModEnchantments {
    public static final EnchantmentCategory CUTLASS = EnchantmentCategory.create("cutlass", item -> item instanceof CutlassItem);

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Swords_of_the_Seven_Seas.MODID);

    public static final RegistryObject<Enchantment> BALANCED = ENCHANTMENTS.register("balanced",
            () -> new BalancedEnchantment(Enchantment.Rarity.UNCOMMON, CUTLASS, EquipmentSlot.MAINHAND));


    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
