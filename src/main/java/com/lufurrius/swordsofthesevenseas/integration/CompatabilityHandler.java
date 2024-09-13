package com.lufurrius.swordsofthesevenseas.integration;

import com.lufurrius.swordsofthesevenseas.integration.caves_and_depths.CavesAndDepths;
import com.lufurrius.swordsofthesevenseas.integration.enlightend.Enlightend;
import com.lufurrius.swordsofthesevenseas.integration.oreganized.Oreganized;
import com.lufurrius.swordsofthesevenseas.integration.undead_unleashed.UndeadUnleashed;
import net.minecraftforge.fml.ModList;
import com.lufurrius.swordsofthesevenseas.integration.undergarden.Undergarden;
import com.lufurrius.swordsofthesevenseas.integration.alloyed.Alloyed;
import com.lufurrius.swordsofthesevenseas.integration.caverns_and_chasms.CavernsAndChasms;
import com.lufurrius.swordsofthesevenseas.integration.stuff_and_additions.StuffAndAdditions;

public class CompatabilityHandler {

    public static final boolean undeadUnleashed;
    public static final boolean undergarden;
    public static final boolean oreganized;
    public static final boolean enlightend;
    public static final boolean alloyed;
    public static final boolean cavernsAndChasms;
    public static final boolean stuffAndAdditons;
    public static final boolean cavesAndDepths;


    static {
        ModList mods = ModList.get();

        undeadUnleashed = mods.isLoaded("undead_unleashed");
        undergarden = mods.isLoaded("undergarden");
        oreganized = mods.isLoaded("oreganized");
        enlightend = mods.isLoaded("enlightened_end");
        alloyed = mods.isLoaded("alloyed");
        cavernsAndChasms = mods.isLoaded("caverns_and_chasms");
        stuffAndAdditons = mods.isLoaded("create_sa");
        cavesAndDepths = mods.isLoaded("cavesanddepths");
    }

    public static void register() {
        if (undeadUnleashed) UndeadUnleashed.register();
        if (undergarden) Undergarden.register();
        if (oreganized) Oreganized.register();
        if (enlightend) Enlightend.register();
        if (alloyed) Alloyed.register();
        if (cavernsAndChasms) CavernsAndChasms.register();
        if (stuffAndAdditons) StuffAndAdditions.register();
        if (cavesAndDepths) CavesAndDepths.register();
    }
}