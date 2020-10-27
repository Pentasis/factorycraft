package pentasis.factorycraft;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pentasis.factorycraft.config.ConfigManager;
import pentasis.factorycraft.core.RegistryManager;

@Mod(FactoryCraft.MODID)
public class FactoryCraft {

    public static final String MODID = "factorycraft";
    public static final String MOD_NAME = "FactoryCraft";

    private static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    public FactoryCraft() {

        ConfigManager.init();
        RegistryManager.init();

        //MinecraftForge.EVENT_BUS.register(this);
    }

}
