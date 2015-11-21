package brazillianforgers.dynamiccraft.blocks;

import java.util.Random;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockDynamicOre extends Block{

	public IIcon [] icons;
	
	public BlockDynamicOre() {
		super(Material.rock);
		setHardness(14f);
		setResistance(5f);
		setCreativeTab(DynamicCraft.dynamicTab);
		setStepSound(Block.soundTypeStone);
		setHarvestLevel("pickaxe", 2);
		
		icons = new IIcon[6];
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		for (int i = 0; i <=5; i++) {
			icons[i] = iconRegister.registerIcon(Strings.MODID + ":oreDynamic");
		}
		
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return icons[side];
	}
	
	@Override
	public int quantityDropped(Random rand) {
        rand = new Random();
        int q = rand.nextInt(3) + 1;
        return q;
    }

    public Item getItemDropped(int i, Random rand, int j) {
        return Item.getItemFromBlock(this);
    }

}
