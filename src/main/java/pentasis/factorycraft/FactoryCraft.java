package pentasis.factorycraft;

import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pentasis.factorycraft.common.objects.blocks.BlockRegistry;
import pentasis.factorycraft.common.objects.items.ItemRegistry;

import java.util.stream.Collectors;

@Mod(FactoryCraft.MODID)
public class FactoryCraft {

    public static final String MODID = "factorycraft";
    public static final String MOD_NAME = "FactoryCraft";

    // Reference the logger and make it annotate the log entries with the name of the mod.
    private static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    // Not strictly needed, but some consider this best practice. Not sure why, I guess it creates a singleton?
    public static FactoryCraft instance;

    // Forge sequence:
    // 1) Construction of mod class
    // 2) Registry events for blocks, items, recipes, entities, sound events, etc - these allow you to tell Forge about new blocks
    // 3) SetupEvents (FMLCommonSetupEvent, FMLClientSetupEvent)
    // ----------------------------------------------------------------------------------------

    // 1)
    public FactoryCraft() {
        instance = this; // Again, something to do with singletons?

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // 2)
        BlockRegistry.BLOCKS.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);
        modEventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    // 3)
    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("factorycraft", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }


    //@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    //public static class RegistryEvents {
    //    @SubscribeEvent
    //    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
    //        // register a new block here
    //        LOGGER.info("HELLO from Register Block");
    //    }
    //}
}
