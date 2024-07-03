package net.masik.mythiccharms.pottery;

import net.masik.mythiccharms.MythicCharms;
import net.masik.mythiccharms.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModDecoratedPotPatterns {

    private static final RegistryKey<String> RESONANCE_POTTERY_PATTERN_KEY = getKey("resonance_pottery_pattern");
    private static final RegistryKey<String> CRYSTAL_POTTERY_PATTERN_KEY = getKey("crystal_pottery_pattern");
    private static final RegistryKey<String> CORE_POTTERY_PATTERN_KEY = getKey("core_pottery_pattern");
    private static final RegistryKey<String> FARMER_POTTERY_PATTERN_KEY = getKey("farmer_pottery_pattern");
    private static final RegistryKey<String> FARMLAND_POTTERY_PATTERN_KEY = getKey("farmland_pottery_pattern");
    private static final RegistryKey<String> BODY_POTTERY_PATTERN_KEY = getKey("body_pottery_pattern");
    private static final RegistryKey<String> PROPHECY_POTTERY_PATTERN_KEY = getKey("prophecy_pottery_pattern");
    private static final RegistryKey<String> FREEDOM_POTTERY_PATTERN_KEY = getKey("freedom_pottery_pattern");
    private static final RegistryKey<String> MOUNTAIN_POTTERY_PATTERN_KEY = getKey("mountain_pottery_pattern");
    private static final RegistryKey<String> AID_POTTERY_PATTERN_KEY = getKey("aid_pottery_pattern");
    private static final RegistryKey<String> SAFETY_POTTERY_PATTERN_KEY = getKey("safety_pottery_pattern");
    private static final RegistryKey<String> NATURE_POTTERY_PATTERN_KEY = getKey("nature_pottery_pattern");
    private static final RegistryKey<String> HEAT_POTTERY_PATTERN_KEY = getKey("heat_pottery_pattern");
    private static final RegistryKey<String> FIGHT_POTTERY_PATTERN_KEY = getKey("fight_pottery_pattern");
    private static final RegistryKey<String> GROWTH_POTTERY_PATTERN_KEY = getKey("growth_pottery_pattern");
    private static final RegistryKey<String> GHOST_POTTERY_PATTERN_KEY = getKey("ghost_pottery_pattern");

    public static final String RESONANCE_POTTERY_PATTERN = registerDecoratedPotPattern(RESONANCE_POTTERY_PATTERN_KEY, "resonance_pottery_pattern");
    public static final String CRYSTAL_POTTERY_PATTERN = registerDecoratedPotPattern(CRYSTAL_POTTERY_PATTERN_KEY, "crystal_pottery_pattern");
    public static final String CORE_POTTERY_PATTERN = registerDecoratedPotPattern(CORE_POTTERY_PATTERN_KEY, "core_pottery_pattern");
    public static final String FARMER_POTTERY_PATTERN = registerDecoratedPotPattern(FARMER_POTTERY_PATTERN_KEY, "farmer_pottery_pattern");
    public static final String FARMLAND_POTTERY_PATTERN = registerDecoratedPotPattern(FARMLAND_POTTERY_PATTERN_KEY, "farmland_pottery_pattern");
    public static final String BODY_POTTERY_PATTERN = registerDecoratedPotPattern(BODY_POTTERY_PATTERN_KEY, "body_pottery_pattern");
    public static final String PROPHECY_POTTERY_PATTERN = registerDecoratedPotPattern(PROPHECY_POTTERY_PATTERN_KEY, "prophecy_pottery_pattern");
    public static final String FREEDOM_POTTERY_PATTERN = registerDecoratedPotPattern(FREEDOM_POTTERY_PATTERN_KEY, "freedom_pottery_pattern");
    public static final String MOUNTAIN_POTTERY_PATTERN = registerDecoratedPotPattern(MOUNTAIN_POTTERY_PATTERN_KEY, "mountain_pottery_pattern");
    public static final String AID_POTTERY_PATTERN = registerDecoratedPotPattern(AID_POTTERY_PATTERN_KEY, "aid_pottery_pattern");
    public static final String SAFETY_POTTERY_PATTERN = registerDecoratedPotPattern(SAFETY_POTTERY_PATTERN_KEY, "safety_pottery_pattern");
    public static final String NATURE_POTTERY_PATTERN = registerDecoratedPotPattern(NATURE_POTTERY_PATTERN_KEY, "nature_pottery_pattern");
    public static final String HEAT_POTTERY_PATTERN = registerDecoratedPotPattern(HEAT_POTTERY_PATTERN_KEY, "heat_pottery_pattern");
    public static final String FIGHT_POTTERY_PATTERN = registerDecoratedPotPattern(FIGHT_POTTERY_PATTERN_KEY, "fight_pottery_pattern");
    public static final String GROWTH_POTTERY_PATTERN = registerDecoratedPotPattern(GROWTH_POTTERY_PATTERN_KEY, "growth_pottery_pattern");
    public static final String GHOST_POTTERY_PATTERN = registerDecoratedPotPattern(GHOST_POTTERY_PATTERN_KEY, "ghost_pottery_pattern");

    public static final Map<Item, RegistryKey<String>> SHERD_TO_PATTERN = Map.ofEntries(
            Map.entry(ModItems.RESONANCE_POTTERY_SHERD, RESONANCE_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.CRYSTAL_POTTERY_SHERD, CRYSTAL_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.CORE_POTTERY_SHERD, CORE_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.FARMER_POTTERY_SHERD, FARMER_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.FARMLAND_POTTERY_SHERD, FARMLAND_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.BODY_POTTERY_SHERD, BODY_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.PROPHECY_POTTERY_SHERD, PROPHECY_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.FREEDOM_POTTERY_SHERD, FREEDOM_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.MOUNTAIN_POTTERY_SHERD, MOUNTAIN_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.AID_POTTERY_SHERD, AID_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.SAFETY_POTTERY_SHERD, SAFETY_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.NATURE_POTTERY_SHERD, NATURE_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.HEAT_POTTERY_SHERD, HEAT_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.FIGHT_POTTERY_SHERD, FIGHT_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.GROWTH_POTTERY_SHERD, GROWTH_POTTERY_PATTERN_KEY),
            Map.entry(ModItems.GHOST_POTTERY_SHERD, GHOST_POTTERY_PATTERN_KEY)
    );

    private static RegistryKey<String> getKey(String name) {
        return RegistryKey.of(RegistryKeys.DECORATED_POT_PATTERN, new Identifier(MythicCharms.MOD_ID, name));
    }

    private static String registerDecoratedPotPattern(RegistryKey<String> key, String name) {

        return Registry.register(Registries.DECORATED_POT_PATTERN, key, name);

    }

    public static void registerModDecoratedPotPatterns() {



    }

}
