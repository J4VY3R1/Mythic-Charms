package net.masik.mythiccharms.util;

import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

import java.util.ArrayList;

public class BotanicBlessingHelper {

    public static final ArrayList<IntProperty> AGES = new ArrayList<>() {{
        add(Properties.AGE_1);
        add(Properties.AGE_2);
        add(Properties.AGE_3);
        add(Properties.AGE_4);
        add(Properties.AGE_5);
        add(Properties.AGE_7);
        add(Properties.AGE_15);
        add(Properties.AGE_25);
        add(Properties.STAGE);
    }};

    public static final ArrayList<Integer> MAX_AGES = new ArrayList<>() {{
        add(Properties.AGE_1_MAX);
        add(Properties.AGE_2_MAX);
        add(Properties.AGE_3_MAX);
        add(Properties.AGE_4_MAX);
        add(Properties.AGE_5_MAX);
        add(Properties.AGE_7_MAX);
        add(Properties.AGE_15_MAX);
        add(Properties.AGE_25_MAX);
        add(1);
    }};

}
