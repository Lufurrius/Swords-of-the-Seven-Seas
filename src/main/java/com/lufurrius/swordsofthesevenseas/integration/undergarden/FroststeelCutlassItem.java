package com.lufurrius.swordsofthesevenseas.integration.undergarden;

import com.lufurrius.swordsofthesevenseas.Swords_of_the_Seven_Seas;
import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class FroststeelCutlassItem extends CutlassItem {

    public FroststeelCutlassItem(Tier tier, int pAttackDamage, float pAttackSpeed, Properties pProperties) {
        super(tier, pAttackDamage, pAttackSpeed, pProperties);
    }

    public boolean hurtEnemy(@NotNull ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 2));
        return retval;
    }

    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("tooltip.froststeel_sword").withStyle(ChatFormatting.AQUA));
    }
}
