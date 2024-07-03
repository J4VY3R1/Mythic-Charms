package net.masik.mythiccharms.enchantment;

import net.masik.mythiccharms.MythicCharms;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static final Enchantment ETERNAL_GRIP = registerEnchantment("eternal_grip",
            new EternalGripEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.BREAKABLE, EquipmentSlot.MAINHAND));

    private static Enchantment registerEnchantment(String name, Enchantment enchantment) {

        return Registry.register(Registries.ENCHANTMENT, new Identifier(MythicCharms.MOD_ID, name), enchantment);

    }

    public static void registerModEnchantments() {



    }

}
