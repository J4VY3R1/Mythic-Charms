package net.masik.mythiccharms.mixin;

import net.masik.mythiccharms.util.CharmHelper;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.EnchantmentScreen;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(EnchantmentScreen.class)
public class EnchantmentScreenMixin {

    @SuppressWarnings("unchecked")
    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;getName(I)Lnet/minecraft/text/Text;"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void enchantedWhispersEffect(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci, boolean bl, int i, int j, int k, Enchantment enchantment, int l, int m, List list) {

        EnchantmentScreen screen = (EnchantmentScreen) (Object) this;
        EnchantmentScreenHandler screenHandler = screen.getScreenHandler();


        if (!CharmHelper.charmEnchantedWhispersEquipped(screen.getScreenHandler().player())) return;


        Random random = Random.create();
        random.setSeed(screenHandler.getSeed() + j);

        ItemStack itemStack = screenHandler.slots.get(0).getStack();
        List<EnchantmentLevelEntry> enchantments = screenHandler.generateEnchantments(itemStack, j, screenHandler.enchantmentPower[j]);

        enchantments.removeIf(entry -> entry.enchantment.equals(Enchantment.byRawId(screenHandler.enchantmentId[j])));

        if (!enchantments.isEmpty()) {

            list.add(Text.translatable("util.mythic_charms.enchant.clue", new Object[]{enchantments.get(0).enchantment.getName(enchantments.get(0).level)}).formatted(Formatting.WHITE));

        }

    }

}
