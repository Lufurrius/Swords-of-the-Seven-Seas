package com.lufurrius.swordsofthesevenseas.items;


import com.lufurrius.swordsofthesevenseas.Swords_of_the_Seven_Seas;
import com.lufurrius.swordsofthesevenseas.registry.ModEnchantments;
import net.minecraft.world.item.*;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class CutlassItem extends SwordItem {
    private final float baseAttackSpeed;

    public CutlassItem(Tier tier, int attackDamageModifier, float baseAttackSpeed, Item.Properties properties) {
        super(tier, attackDamageModifier, baseAttackSpeed, properties.tab(Swords_of_the_Seven_Seas.CREATIVE_TAB)); // Pass the base attack speed to the superclass
        this.baseAttackSpeed = baseAttackSpeed - 2.2F; // Save the base attack speed for dynamic adjustment
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if (slot == EquipmentSlot.MAINHAND) {
            int sharpnessLevel = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.BALANCED.get(), stack);
            float dynamicAttackSpeed = calculateDynamicAttackSpeed(sharpnessLevel);

            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.getDamage(), AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", dynamicAttackSpeed, AttributeModifier.Operation.ADDITION));

            return builder.build();
        }

        return super.getAttributeModifiers(slot, stack);
    }

    private float calculateDynamicAttackSpeed(int sharpnessLevel) {
        // Use the baseAttackSpeed for dynamic calculation
        return this.baseAttackSpeed + sharpnessLevel * 0.1F;
    }
    @Mod.EventBusSubscriber(modid = Swords_of_the_Seven_Seas.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class CutlassEvents {

        @SubscribeEvent
        public static void onCutlassKnockback(LivingKnockBackEvent event) {
            LivingEntity attacker = event.getEntity().getKillCredit();
            if (attacker == null) return;

            ItemStack toolStack = attacker.getItemInHand(InteractionHand.MAIN_HAND);

            if (toolStack.getItem() instanceof CutlassItem && !attacker.isSprinting() && attacker.fallDistance == 0.0F) {
                event.setStrength(event.getOriginalStrength() - 0.15F);
            }
        }
    }
}


