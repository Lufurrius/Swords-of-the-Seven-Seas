package com.lufurrius.swordsofthesevenseas;

import com.lufurrius.swordsofthesevenseas.events.LootTableEventHandler;
import com.lufurrius.swordsofthesevenseas.loot.LootMappings;
import com.lufurrius.swordsofthesevenseas.loot.LootPools;
import com.lufurrius.swordsofthesevenseas.loot.LootTables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.lufurrius.swordsofthesevenseas.integration.CompatabilityHandler;
import com.lufurrius.swordsofthesevenseas.registry.ModItems;
import com.lufurrius.swordsofthesevenseas.registry.ModEnchantments;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Swords_of_the_Seven_Seas.MODID)
public class Swords_of_the_Seven_Seas {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "swords_of_the_seven_seas";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "swords_of_the_seven_seas" namespace

    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(Swords_of_the_Seven_Seas.MODID)
    {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GOLDEN_CUTLASS.get());
        }
    };
    public Swords_of_the_Seven_Seas() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register items, enchantments, etc.
        ModItems.register(modEventBus);
        ModEnchantments.register(modEventBus);
        CompatabilityHandler.register();

        // Register the unified event handler once
        MinecraftForge.EVENT_BUS.register(LootTableEventHandler.class);
    }

}
