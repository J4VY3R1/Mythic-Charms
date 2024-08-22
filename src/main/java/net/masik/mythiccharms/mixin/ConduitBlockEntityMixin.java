package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.block.entity.ConduitBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.FluidTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ConduitBlockEntity.class)
public class ConduitBlockEntityMixin {

    @Redirect(method = "givePlayersEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isTouchingWaterOrRain()Z"))
    private static boolean inject(PlayerEntity instance) {

        if (!CharmHelper.charmDrownedFreedomEquipped(instance)) return instance.isTouchingWaterOrRain();

        return instance.updateMovementInFluid(FluidTags.WATER, 0.014);

    }

}
