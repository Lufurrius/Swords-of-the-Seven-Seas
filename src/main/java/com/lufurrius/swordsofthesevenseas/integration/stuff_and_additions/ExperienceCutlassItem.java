package com.lufurrius.swordsofthesevenseas.integration.stuff_and_additions;

import com.lufurrius.swordsofthesevenseas.items.CutlassItem;
import net.mcreator.createstuffadditions.procedures.ExperiencePickaxeBlockDestroyedWithToolProcedure;
import net.mcreator.createstuffadditions.procedures.ExperiencePickaxeLivingEntityIsHitWithToolProcedure;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ExperienceCutlassItem extends CutlassItem {
    public ExperienceCutlassItem(Tier tier, int pAttackDamage, float pAttackSpeed, Properties pProperties) {
        super(tier, pAttackDamage, pAttackSpeed, pProperties);
    }
    public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
        boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
        ExperiencePickaxeBlockDestroyedWithToolProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
        return retval;
    }

    public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        ExperiencePickaxeLivingEntityIsHitWithToolProcedure.execute(entity.level, entity);
        return retval;
    }

    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            list.add(Component.literal("§8Hold [§fShift§8] for Summary"));
            list.add(Component.literal(" "));
            list.add(Component.literal("§5Use this tool gradually crumbles"));
            list.add(Component.literal("§5it and if you are lucky, the tool"));
            list.add(Component.literal("§5will spawn §dxp orbs"));
        } else {
            list.add(Component.literal("§8Hold [§7Shift§8] for Summary"));
        }

        super.appendHoverText(itemstack, world, list, flag);
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(ItemStack itemstack) {
        return true;
    }
}
