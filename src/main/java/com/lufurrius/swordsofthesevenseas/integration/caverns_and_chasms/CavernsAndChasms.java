package com.lufurrius.swordsofthesevenseas.integration.caverns_and_chasms;

import com.teamabnormals.caverns_and_chasms.core.other.CCTiers.CCItemTiers;
import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import static com.lufurrius.swordsofthesevenseas.registry.ModItems.ITEMS;

public class CavernsAndChasms {
    public static final RegistryObject<Item> SILVER_CUTLASS = ITEMS.register("silver_cutlass",
            () -> new CutlassItem(CCItemTiers.SILVER, 0, 0,
                    new Item.Properties()));
    public static final RegistryObject<Item> NECROMIUM_CUTLASS = ITEMS.register("necromium_cutlass",
            () -> new CutlassItem(CCItemTiers.NECROMIUM, 0, 0,
                    new Item.Properties().fireResistant()));


    public static void register() {

    }

}
