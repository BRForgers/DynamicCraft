package brazillianforgers.dynamiccraft.blocks;

import java.util.Random;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.handler.BlockHandler;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockInfusionAltar extends BlockContainer{

	public BlockInfusionAltar() {
		super(Material.rock);
		
		setCreativeTab(DynamicCraft.dynamicTab);
        setHardness(6F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityInfusionAltar();
	}

	@Override
    public Item getItemDropped(int i, Random rand, int i2) {
        return Item.getItemFromBlock(BlockHandler.infusionAltar);
    }
	

    @Override
    public boolean renderAsNormalBlock() {
    	return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
