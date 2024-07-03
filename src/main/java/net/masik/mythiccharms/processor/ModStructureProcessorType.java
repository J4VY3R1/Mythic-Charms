package net.masik.mythiccharms.processor;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.processor.StructureProcessorType;

public class ModStructureProcessorType {

    public static StructureProcessorType<WaterloggedProcessor> WATERLOGGED_PROCESSOR = Registry.register(Registries.STRUCTURE_PROCESSOR,
            "mythic_charms:waterlogged", () -> WaterloggedProcessor.CODEC);

    public static void registerProcessors() {

    }
}
