package pentasis.factorycraft.config;

import net.minecraft.item.DyeColor;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public final class ConfigManager {

    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final ForgeConfigSpec SERVER_SPEC;
    static final ClientConfig CLIENT_CONFIG;
    static final ServerConfig SERVER_CONFIG;

    static {
        {
            final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
            CLIENT_CONFIG = specPair.getLeft();
            CLIENT_SPEC = specPair.getRight();
        }
        {
            final Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
            SERVER_CONFIG = specPair.getLeft();
            SERVER_SPEC = specPair.getRight();
        }
    }

    // Client config values
    public static boolean clientBoolean;
    public static List<String> clientStringList;
    public static DyeColor clientDyeColorEnum;

    public static boolean modelTranslucency;
    public static float modelScale;

    // Server config values
    public static boolean serverBoolean;
    public static List<String> serverStringList;
    public static DyeColor serverEnumDyeColor;

    public static int electricFurnaceEnergySmeltCostPerTick = 100;
    public static int heatCollectorTransferAmountPerTick = 100;

    public static void init() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_SPEC);
    }

    // These get called during the ModConfig event
    // TODO: Combine into one method
    public static void getClientConfig(final ModConfig config) {
        clientBoolean = CLIENT_CONFIG.clientBoolean.get();
        clientStringList = CLIENT_CONFIG.clientStringList.get();
        clientDyeColorEnum = CLIENT_CONFIG.clientDyeColorEnum.get();

        modelTranslucency = CLIENT_CONFIG.modelTranslucency.get();
        modelScale = CLIENT_CONFIG.modelScale.get().floatValue();
    }

    public static void getServerConfig(final ModConfig config) {
        serverBoolean = SERVER_CONFIG.serverBoolean.get();
        serverStringList = SERVER_CONFIG.serverStringList.get();
        serverEnumDyeColor = SERVER_CONFIG.serverEnumDyeColor.get();

        electricFurnaceEnergySmeltCostPerTick = SERVER_CONFIG.electricFurnaceEnergySmeltCostPerTick.get();
        heatCollectorTransferAmountPerTick = SERVER_CONFIG.heatCollectorTransferAmountPerTick.get();
    }
}
