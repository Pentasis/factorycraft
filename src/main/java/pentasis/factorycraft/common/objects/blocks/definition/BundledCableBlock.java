package pentasis.factorycraft.common.objects.blocks.definition;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;

import javax.annotation.Nonnull;

public class BundledCableBlock extends Block {

    public BundledCableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public IFactory<BlockItem> getItemBlockFactory() {
        return () -> new BundledCableBlockItem(this, this.getItemGroup());
    }

    public static class BundledCableBlockItem extends BlockItem {

        public BundledCableBlockItem(Block blockIn, ItemGroup group) {
            super(blockIn, new Properties().group(group));
            this.setRegistryName(blockIn.getRegistryName());
        }

        @Nonnull
        @Override
        public String getCreatorModId(ItemStack itemStack) {
            return new TranslationTextComponent("itemGroup." + this.group.getPath()).getString();
        }

    }
}
