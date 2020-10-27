package pentasis.factorycraft.config;

import net.minecraft.item.DyeColor;
import net.minecraftforge.common.ForgeConfigSpec;
import pentasis.factorycraft.FactoryCraft;

import java.util.ArrayList;
import java.util.List;

public class ServerConfig {

    final ForgeConfigSpec.BooleanValue serverBoolean;
    final ForgeConfigSpec.ConfigValue<List<String>> serverStringList;
    final ForgeConfigSpec.ConfigValue<DyeColor> serverEnumDyeColor;

    final ForgeConfigSpec.IntValue electricFurnaceEnergySmeltCostPerTick;
    final ForgeConfigSpec.IntValue heatCollectorTransferAmountPerTick;

    ServerConfig(final ForgeConfigSpec.Builder builder) {
        builder.push("general");
        serverBoolean = builder
              .comment("An example boolean in the server config")
              .translation(FactoryCraft.MODID + ".config.serverBoolean")
              .define("serverBoolean", true);
        serverStringList = builder
              .comment("An example list of Strings in the server config")
              .translation(FactoryCraft.MODID + ".config.serverStringList")
              .define("serverStringList", new ArrayList<>());
        serverEnumDyeColor = builder
              .comment("An example enum DyeColor in the server config")
              .translation(FactoryCraft.MODID + ".config.serverEnumDyeColor")
              .defineEnum("serverEnumDyeColor", DyeColor.WHITE);

        electricFurnaceEnergySmeltCostPerTick = builder
              .comment("How much energy for the Electric Furnace to consume to smelt an item per tick")
              .translation(FactoryCraft.MODID + ".config.electricFurnaceEnergySmeltCostPerTick")
              .defineInRange("electricFurnaceEnergySmeltCostPerTick", 100, 0, Integer.MAX_VALUE);
        heatCollectorTransferAmountPerTick = builder
              .comment("How much energy for the Heat Collector to try and transfer in each direction per tick")
              .translation(FactoryCraft.MODID + ".config.heatCollectorTransferAmountPerTick")
              .defineInRange("heatCollectorTransferAmountPerTick", 100, 0, Integer.MAX_VALUE);
        builder.pop();
    }
}
