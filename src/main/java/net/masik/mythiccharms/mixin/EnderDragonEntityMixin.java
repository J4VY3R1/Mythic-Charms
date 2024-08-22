package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Iterator;

@Mixin(EnderDragonEntity.class)
public class EnderDragonEntityMixin {

    @Redirect(method = "launchLivingEntities", at = @At(value = "INVOKE", target = "Ljava/util/Iterator;next()Ljava/lang/Object;"))
    private Object mountainsStrengthEffectDragon(Iterator instance) {

        Entity entity = (Entity) instance.next();

        if (!entity.isPlayer()) return(entity);

        if (!CharmHelper.charmMountainsStrengthEquipped((LivingEntity) entity)) return(entity);

        return null;
    }

}
