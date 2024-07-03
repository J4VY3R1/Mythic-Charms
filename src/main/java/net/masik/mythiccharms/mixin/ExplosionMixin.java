package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Explosion.class)
public class ExplosionMixin {

    @Redirect(method = "collectBlocksAndDamageEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;setVelocity(Lnet/minecraft/util/math/Vec3d;)V"))
    private void mountainsStrengthEffectExplosion(Entity instance, Vec3d velocity) {

        if (!instance.isPlayer()) {

            instance.setVelocity(velocity);
            return;

        }


        if (!CharmHelper.charmMountainsStrengthEquipped((LivingEntity) instance)) {

            instance.setVelocity(velocity);
            return;

        }


        instance.setVelocity(Vec3d.ZERO);
    }

}
