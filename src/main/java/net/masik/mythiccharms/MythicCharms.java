package net.masik.mythiccharms;

import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.util.TriState;
import net.masik.mythiccharms.block.ModBlocks;
import net.masik.mythiccharms.enchantment.ModEnchantments;
import net.masik.mythiccharms.item.ModItemGroups;
import net.masik.mythiccharms.item.ModItems;

import net.masik.mythiccharms.pottery.ModDecoratedPotPatterns;
import net.masik.mythiccharms.processor.ModStructureProcessorType;
import net.masik.mythiccharms.recipe.ModRecipes;
import net.masik.mythiccharms.util.ModLootTableModifiers;
import net.masik.mythiccharms.util.ModRegistries;
import net.masik.mythiccharms.util.MythicCharmsConfig;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MythicCharms implements ModInitializer {
	public static final String MOD_ID = "mythic_charms";
    public static final Logger LOGGER = LoggerFactory.getLogger("mythic_charms");
	public static final MythicCharmsConfig CONFIG = MythicCharmsConfig.createAndLoad();

	@Override
	public void onInitialize() {
		MythicCharms.LOGGER.info("[Mythic Charms] Initializing...");

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModDecoratedPotPatterns.registerModDecoratedPotPatterns();
		ModEnchantments.registerModEnchantments();

		ModStructureProcessorType.registerProcessors();

		ModLootTableModifiers.modifyLootTables();
		ModRegistries.registerRegistries();

		ModRecipes.registerRecipes();
	}
}