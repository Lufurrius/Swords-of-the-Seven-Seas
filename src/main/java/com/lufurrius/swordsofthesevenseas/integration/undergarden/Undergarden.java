package com.lufurrius.swordsofthesevenseas.integration.undergarden;

import com.lufurrius.swordsofthesevenseas.Swords_of_the_Seven_Seas;
import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import quek.undergarden.registry.UGItemTiers;
import quek.undergarden.registry.UGItems;

import static com.lufurrius.swordsofthesevenseas.registry.ModItems.ITEMS;

public class Undergarden {
    public static final RegistryObject<Item> FORGOTTEN_CUTLASS = ITEMS.register("forgotten_cutlass",
            () -> new ForgottenCutlassItem(UGItemTiers.FORGOTTEN, 2, 0,
                    new Item.Properties().rarity(UGItems.FORGOTTEN)));

    public static final RegistryObject<Item> UTHERIUM_CUTLASS = ITEMS.register("utherium_cutlass",
            () -> new UtheriumCutlassItem(UGItemTiers.UTHERIUM, 1, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> FROSTSTEEL_CUTLASS = ITEMS.register("froststeel_cutlass",
            () -> new FroststeelCutlassItem(UGItemTiers.FROSTSTEEL, 1, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> CLOGGRUM_CUTLASS = ITEMS.register("cloggrum_cutlass",
            () -> new CutlassItem(UGItemTiers.CLOGGRUM, 1, 0,
                    new Item.Properties()));

    public static void register() {

    }
}
