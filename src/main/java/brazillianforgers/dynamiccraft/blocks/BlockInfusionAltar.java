package brazillianforgers.dynamiccraft.blocks;

import java.util.Random;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.handler.BlockHandler;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockInfusionAltar extends BlockContainer{
	
	private TileEntityInfusionAltar tile;

	public BlockInfusionAltar() {
		super(Material.rock);
		
		setCreativeTab(DynamicCraft.dynamicTab);
        setHardness(6F);
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		if(this.tile.isActive() && this.tile.hasMagic()) {
			double f1 = rand.nextDouble() - 0.5;
			double f2 = rand.nextDouble() - 0.5;
			double f3 = rand.nextDouble() - 0.5;
				
			for(int i = 0; i <= 3; i++) {
				world.spawnParticle("enchantmenttable", x + 1, y + 0.5, z + 0.5, f1, f2, f3);
				world.spawnParticle("enchantmenttable", x, y + 0.5, z + 0.5, f1, f2, f3);
				world.spawnParticle("enchantmenttable", x + 0.5, y + 1, z + 0.5, f1, f2, f3);
				world.spawnParticle("enchantmenttable", x + 0.5, y, z + 0.5, f1, f2, f3);
				world.spawnParticle("enchantmenttable", x + 0.5, y + 0.5, z + 1, f1, f2, f3);
				world.spawnParticle("enchantmenttable", x + 0.5, y + 0.5, z, f1, f2, f3);
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		tile = new TileEntityInfusionAltar();
		return tile;
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
    
    @Override
    public int getRenderType() {
    	return -1;
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
    	if(!world.isRemote) {
    		FMLNetworkHandler.openGui(player, DynamicCraft.mod, DynamicCraft.guiIdInfusion, world, x, y, z);
    	}
    	return true;
    }
}
