package com.lufurrius.swordsofthesevenseas.loot;

import com.lufurrius.swordsofthesevenseas.integration.CompatabilityHandler;
import com.lufurrius.swordsofthesevenseas.integration.caverns_and_chasms.CavernsAndChasms;
import com.lufurrius.swordsofthesevenseas.registry.ModItems;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.ModList;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;

import java.util.HashMap;
import java.util.Map;

import static com.lufurrius.swordsofthesevenseas.integration.CompatabilityHandler.cavernsAndChasms;

public class LootPools {

    private static final Map<String, LootPool> LOOT_POOLS = new HashMap<>();

    static {
        // Register loot pools with unique IDs
        registerPool("GILDED_CUTLASS_RARE", LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.EMERALD_CUTLASS.get())
                        .when(LootItemRandomChanceCondition.randomChance(0.175F))
                        .apply(SetItemDamageFunction.setDamage(ConstantValue.exactly(0))
                                .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2F, 0.8F))
                                .when(LootItemRandomChanceCondition.randomChance(0.6F)))
                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0, 0.2F))
                                .when(LootItemRandomChanceCondition.randomChance(0.3F)))
                ).build());

        registerPool("GILDED_CUTLASS", LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.EMERALD_CUTLASS.get())
                        .when(LootItemRandomChanceCondition.randomChance(0.55F))
                ).build());

        // Conditionally modify the GOLDEN_CUTLASS pool based on the presence of "caverns_and_chasms"
        if (cavernsAndChasms) {
            // 50% chance of getting either Golden or Silver Cutlass if "caverns_and_chasms" mod is present
            registerPool("GOLDEN_CUTLASS", LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(ModItems.GOLDEN_CUTLASS.get())
                            .when(LootItemRandomChanceCondition.randomChance(0.5F))
                    )
                    .add(LootItem.lootTableItem(CavernsAndChasms.SILVER_CUTLASS.get())
                            .when(LootItemRandomChanceCondition.randomChance(0.5F))
                    ).build());
        } else {
            // 100% chance of getting a Golden Cutlass if "caverns_and_chasms" mod is NOT present
            registerPool("GOLDEN_CUTLASS", LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(ModItems.GOLDEN_CUTLASS.get()))
                    .build());
        }
    }

    private static void registerPool(String poolId, LootPool pool) {
        LOOT_POOLS.put(poolId, pool);
    }

    public static LootPool getPool(String poolId) {
        return LOOT_POOLS.get(poolId);
    }
}