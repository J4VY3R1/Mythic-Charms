package net.masik.mythiccharms.item;

import dev.emi.trinkets.api.*;
import net.masik.mythiccharms.enchantment.ModEnchantments;
import net.masik.mythiccharms.util.TooltipHelper;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class TooltipTrinketItem extends TrinketItem {

    private final Boolean requiresShift;

    public TooltipTrinketItem(Settings settings, Boolean shift) {
        super(settings);
        requiresShift = shift;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        TooltipHelper.addTooltip(tooltip, (this.getTranslationKey() + ".tooltip").replace("fragile_charm_of_", "").replace("unbreakable_charm_of_", ""), requiresShift);

    }

    @Override
    public TrinketEnums.DropRule getDropRule(ItemStack stack, SlotReference slot, LivingEntity entity) {

        if (EnchantmentHelper.getLevel(ModEnchantments.ETERNAL_GRIP, stack) > 0) {

            return TrinketEnums.DropRule.KEEP;

        }

        return TrinketEnums.DropRule.DEFAULT;
    }
}
