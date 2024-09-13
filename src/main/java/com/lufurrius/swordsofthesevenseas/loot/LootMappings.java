package com.lufurrius.swordsofthesevenseas.loot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LootMappings {

    private static final Map<String, List<String>> TABLE_POOL_MAP = new HashMap<>();

    static {
        // Link loot tables to their associated pool IDs
        registerMapping("BURIED_TREASURE", List.of("GILDED_CUTLASS", "GOLDEN_CUTLASS"));
        registerMapping("SHIPWRECK_TREASURE", List.of("GILDED_CUTLASS_RARE", "GOLDEN_CUTLASS"));
    }

    private static void registerMapping(String tableId, List<String> poolIds) {
        TABLE_POOL_MAP.put(tableId, poolIds);
    }

    public static List<String> getPoolsForTable(String tableId) {
        return TABLE_POOL_MAP.get(tableId);
    }
}
