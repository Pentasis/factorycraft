package pentasis.factorycraft.objects.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import pentasis.factorycraft.objects.items.definition.CableBenderItem;

import static pentasis.factorycraft.FactoryCraft.MODID;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> CABLE_BENDER = ITEMS.register("cable_bender", CableBenderItem::new);

}
