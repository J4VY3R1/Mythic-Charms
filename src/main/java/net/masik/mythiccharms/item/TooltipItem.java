package net.masik.mythiccharms.item;

import net.masik.mythiccharms.util.TooltipHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class TooltipItem extends Item {

    private final Boolean requiresShift;

    public TooltipItem(Settings settings, Boolean shift) {
        super(settings);
        requiresShift = shift;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        TooltipHelper.addTooltip(tooltip, this.getTranslationKey() + ".tooltip", requiresShift);

    }

}