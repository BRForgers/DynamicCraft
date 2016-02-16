package brazillianforgers.dynamiccraft.blocks;

import java.util.Random;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.Strings;
import brazillianforgers.dynamiccraft.handler.ItemHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockDynamicOre extends Block{

	public IIcon icon;
	
	public BlockDynamicOre() {
		super(Material.iron);
		setHardness(14f);
		setResistance(5f);
		setCreativeTab(DynamicCraft.dynamicTab);
		setStepSound(Block.soundTypeStone);
		setHarvestLevel("pickaxe", 2);
		
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		icon = iconRegister.registerIcon(Strings.MODID + ":oreDynamic");
		
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return icon;
	}
	
	@Override
	public int quantityDropped(Random rand) {
        rand = new Random();
        int q = rand.nextInt(5) + 1;
        return q;
    }

	@Override
    public Item getItemDropped(int i, Random rand, int i2) {
		rand = new Random();
		int item = rand.nextInt(3) + 1;
		
		switch(item) {
			case 1:
				return ItemHandler.dynamicPearl;
			default:
				return ItemHandler.dynamicShard;
		}
    }
	
	 @SideOnly(Side.CLIENT)
	 @Override
	 public void randomDisplayTick(World world, int x, int y, int z, Random random) {		
		 this.sparkle(world, x, y, z);
	 }
	
	private void sparkle(World par1World, int par2, int par3, int par4)
    {
	    Random var5 = par1World.rand;
	    double var6 = 0.0625D;
	    for (int var8 = 0; var8 < 6; ++var8)
	    {
		    double var9 = (double)((float)par2 + var5.nextFloat());
		    double var11 = (double)((float)par3 + var5.nextFloat());
		    double var13 = (double)((float)par4 + var5.nextFloat());
		    if (var8 == 0 && !par1World.getBlock(par2, par3 + 1, par4).isOpaqueCube())
		    {
			    var11 = (double)(par3 + 1) + var6;
		    }
		    if (var8 == 1 && !par1World.getBlock(par2, par3 - 1, par4).isOpaqueCube())
		    {
			    var11 = (double)(par3 + 0) - var6;
		    }
		    if (var8 == 2 && !par1World.getBlock(par2, par3, par4 + 1).isOpaqueCube())
		    {
			    var13 = (double)(par4 + 1) + var6;
		    }
		    if (var8 == 3 && !par1World.getBlock(par2, par3, par4 - 1).isOpaqueCube())
		    {
			    var13 = (double)(par4 + 0) - var6;
		    }
		    if (var8 == 4 && !par1World.getBlock(par2 + 1, par3, par4).isOpaqueCube())
		    {
			    var9 = (double)(par2 + 1) + var6;
		    }
		    if (var8 == 5 && !par1World.getBlock(par2 - 1, par3, par4).isOpaqueCube())
		    {
			    var9 = (double)(par2 + 0) - var6;
		    }
		    if (var9 < (double)par2 || var9 > (double)(par2 + 1) || var11 < 0.0D || var11 > (double)(par3 + 1) || var13 < (double)par4 || var13 > (double)(par4 + 1))
		    {
			    par1World.spawnParticle("portal", var9, var11, var13, 0.0D, 0.0D, 0.0D);
		    }
	    }
    }

}
