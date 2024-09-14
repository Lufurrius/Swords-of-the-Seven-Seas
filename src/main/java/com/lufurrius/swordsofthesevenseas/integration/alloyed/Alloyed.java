package com.lufurrius.swordsofthesevenseas.integration.alloyed;

import com.lufurrius.swordsofthesevenseas.registry.ModItems;
import com.molybdenum.alloyed.common.item.ModItemTiers;
import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class Alloyed {
    public static final RegistryObject<Item> STEEL_CUTLASS = ModItems.ITEMS.register("steel_cutlass",
            () -> new CutlassItem(ModItemTiers.STEEL, 1, 0,
                    new Item.Properties()));
    public static void register() {

    }
}
