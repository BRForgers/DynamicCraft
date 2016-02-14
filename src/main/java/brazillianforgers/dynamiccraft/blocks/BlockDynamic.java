package brazillianforgers.dynamiccraft.blocks;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDynamic extends Block {

	public BlockDynamic() {
		super(Material.iron);
		setCreativeTab(DynamicCraft.dynamicTab);
		setBlockTextureName(Strings.MODID + ":blockDynamic");
	}

}
