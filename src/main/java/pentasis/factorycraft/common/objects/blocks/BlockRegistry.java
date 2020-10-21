package pentasis.factorycraft.common.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import pentasis.factorycraft.common.objects.blocks.definition.BundledCableBlock;

import static pentasis.factorycraft.FactoryCraft.MODID;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> BUNDLED_CABLE = BLOCKS.register("bundled_cable", () -> new BundledCableBlock(Block.Properties.create(Material.ROCK)));

}
