package pentasis.factorycraft.objects.blocks.definition;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import pentasis.factorycraft.objects.blocks.BaseBlock;

import javax.annotation.Nonnull;

public class CableConduitBlock extends BaseBlock {

    public CableConduitBlock(Properties properties) {
        super(properties);
    }

    @Override
    public IFactory<BlockItem> getItemBlockFactory() {
        return () -> new CableConduitBlockItem(this, this.getItemGroup());
    }

    public static class CableConduitBlockItem extends BlockItem {

        public CableConduitBlockItem(Block blockIn, ItemGroup group) {
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
