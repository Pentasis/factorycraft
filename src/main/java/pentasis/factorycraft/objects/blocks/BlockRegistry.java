package pentasis.factorycraft.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import pentasis.factorycraft.objects.blocks.definition.CableConduitBlock;

import static pentasis.factorycraft.FactoryCraft.MODID;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> BUNDLED_CABLE = BLOCKS.register("bundled_cable", () -> new CableConduitBlock(Block.Properties.create(Material.ROCK)));

}
