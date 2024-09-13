package com.lufurrius.swordsofthesevenseas.loot;

import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class LootTables {

    public static final Map<String, ResourceLocation> LOOT_TABLES = new HashMap<>();

    static {
        // Register loot tables with unique IDs
        registerTable("BURIED_TREASURE", new ResourceLocation("minecraft", "chests/buried_treasure"));
        registerTable("SHIPWRECK_TREASURE", new ResourceLocation("minecraft", "chests/shipwreck_treasure"));
    }

    private static void registerTable(String tableId, ResourceLocation location) {
        LOOT_TABLES.put(tableId, location);
    }

    public static ResourceLocation getTable(String tableId) {
        return LOOT_TABLES.get(tableId);
    }
}