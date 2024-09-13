package com.lufurrius.swordsofthesevenseas.mixin;

import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentMixin {

    // Inject into the canApplyAtEnchantingTable method to block enchantment on CutlassItem
    @Inject(method = "canApplyAtEnchantingTable", at = @At("HEAD"), cancellable = true, remap = false)
    public void onCanApplyAtEnchantingTable(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;

        if (enchantment instanceof DamageEnchantment && stack.getItem() instanceof CutlassItem) {
            cir.setReturnValue(false);
        }
    }

    // Inject into the canEnchant method to block the enchantment through anvil
    @Inject(method = "canEnchant(Lnet/minecraft/world/item/ItemStack;)Z", at = @At("HEAD"), cancellable = true)
    public void onCanEnchant(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;

        if (enchantment instanceof DamageEnchantment && stack.getItem() instanceof CutlassItem) {
            cir.setReturnValue(false);
        }
    }
}