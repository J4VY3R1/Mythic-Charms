package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.pottery.ModDecoratedPotPatterns;
import net.minecraft.block.DecoratedPotPatterns;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DecoratedPotPatterns.class)
public class DecoratedPotPatternsMixin {

    @Inject(method = "fromSherd", at = @At("RETURN"), cancellable = true)
    private static void fromSherd(Item sherd, CallbackInfoReturnable<RegistryKey<String>> cir) {

        if (ModDecoratedPotPatterns.SHERD_TO_PATTERN.containsKey(sherd)) {

            cir.setReturnValue(ModDecoratedPotPatterns.SHERD_TO_PATTERN.get(sherd));

        }

    }

}
