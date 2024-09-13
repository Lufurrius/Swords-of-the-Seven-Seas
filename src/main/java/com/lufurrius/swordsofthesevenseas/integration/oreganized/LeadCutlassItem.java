package com.lufurrius.swordsofthesevenseas.integration.oreganized;

import com.lufurrius.swordsofthesevenseas.Swords_of_the_Seven_Seas;
import com.lufurrius.swordsofthesevenseas.integration.undergarden.Undergarden;
import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import net.mcreator.createstuffadditions.procedures.ExperiencePickaxeLivingEntityIsHitWithToolProcedure;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import galena.oreganized.index.OEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import quek.undergarden.registry.UGTags;

import javax.annotation.Nullable;
import java.util.List;

public class LeadCutlassItem extends CutlassItem {

    public LeadCutlassItem(Tier tier, int pAttackDamage, float pAttackSpeed, Properties pProperties) {
        super(tier, pAttackDamage, pAttackSpeed, pProperties);
    }

    public boolean hurtEnemy(@NotNull ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        entity.addEffect(new MobEffectInstance(MobEffects.POISON, 140));
        entity.addEffect(new MobEffectInstance(OEffects.STUNNING.get(), 60));
        return retval;
    }

    //@Mod.EventBusSubscriber(modid = Swords_of_the_Seven_Seas.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    //public static class LeadCutlassEvents {
    //    @SubscribeEvent
    //    public static void LeadCutlassAttackEvent(LivingHurtEvent event) {
    //
    //    }
    //}

    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("tooltip.swords_of_the_seven_seas.lead_cutlass").withStyle(ChatFormatting.DARK_PURPLE));
    }
}
