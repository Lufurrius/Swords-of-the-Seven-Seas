package com.lufurrius.swordsofthesevenseas.events;

import com.lufurrius.swordsofthesevenseas.loot.LootMappings;
import com.lufurrius.swordsofthesevenseas.loot.LootPools;
import com.lufurrius.swordsofthesevenseas.loot.LootTables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = "swords_of_the_seven_seas")
public class LootTableEventHandler {

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation lootTable = event.getName();

        // Iterate over registered loot tables
        for (String tableId : LootTables.LOOT_TABLES.keySet()) {
            if (lootTable.equals(LootTables.getTable(tableId))) {
                LootTable table = event.getTable();

                // Get the pools for this table ID
                List<String> poolIds = LootMappings.getPoolsForTable(tableId);

                if (poolIds != null) {
                    for (String poolId : poolIds) {
                        // Inject each pool into the loot table
                        table.addPool(LootPools.getPool(poolId));
                    }
                }
            }
        }
    }
}