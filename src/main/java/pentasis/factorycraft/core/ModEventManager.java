package pentasis.factorycraft.core;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import pentasis.factorycraft.FactoryCraft;
import pentasis.factorycraft.config.ConfigManager;

@EventBusSubscriber(modid = FactoryCraft.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventManager {

    // This event fires when a config changes
    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {
        final ModConfig config = event.getConfig();

        // TODO: Combine into one method = one call
        if (config.getSpec() == ConfigManager.CLIENT_SPEC) {
            ConfigManager.getClientConfig(config);
        } else if (config.getSpec() == ConfigManager.SERVER_SPEC) {
            ConfigManager.getServerConfig(config);
        }
    }
}
