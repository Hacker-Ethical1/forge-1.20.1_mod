package net.coolfalcon5298.gemmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SapphireStaffItem extends Item {

    public SapphireStaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide) {
            // Get the attacker's look direction
            Vec3 direction = attacker.getLookAngle().normalize();
            Vec3 upAndForward = direction.add(0, 10, 0).normalize().scale(1.5); // Add upward force

            // Apply motion to the hit entity
            target.setDeltaMovement(upAndForward);
            target.hurtMarked = true; // Forces the server to sync velocity

            // Optional: damage the item
            attacker.getItemInHand(InteractionHand.MAIN_HAND).hurtAndBreak(1, attacker, player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("item.tooltip.gemmod.sapphire_staff"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
