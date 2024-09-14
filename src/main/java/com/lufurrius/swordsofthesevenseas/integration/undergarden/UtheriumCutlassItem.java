package com.lufurrius.swordsofthesevenseas.integration.undergarden;

import com.lufurrius.swordsofthesevenseas.Swords_of_the_Seven_Seas;
import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import quek.undergarden.registry.UGTags;

import javax.annotation.Nullable;
import java.util.List;

public class UtheriumCutlassItem extends CutlassItem {

    public UtheriumCutlassItem(Tier tier, int pAttackDamage, float pAttackSpeed, Properties pProperties) {
        super(tier, pAttackDamage, pAttackSpeed, pProperties);
    }

    @Mod.EventBusSubscriber(modid = Swords_of_the_Seven_Seas.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgottenCutlassEvents {
        @SubscribeEvent
        public static void ForgottenCutlassAttackEvent(LivingHurtEvent event) {
            float damage = event.getAmount();
            LivingEntity attacker = event.getEntity().getKillCredit();
            ItemStack toolStack = attacker != null ? attacker.getItemInHand(InteractionHand.MAIN_HAND) : ItemStack.EMPTY;
            if ((toolStack.getItem() instanceof ForgottenCutlassItem) && event.getEntity().getType().is(UGTags.Entities.ROTSPAWN)) {
                event.setAmount(damage * 1.5F);
            }
        }
    }

    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("tooltip.utheric_sword").withStyle(ChatFormatting.RED));
    }
}
