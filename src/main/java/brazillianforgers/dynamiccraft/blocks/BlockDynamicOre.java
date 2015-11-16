package brazillianforgers.dynamiccraft.blocks;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockDynamicOre extends Block{

	public IIcon [] icons;
	
	public BlockDynamicOre() {
		super(Material.rock);
		setHardness(14f);
		setResistance(5f);
		setCreativeTab(DynamicCraft.dynamicTab);
		setStepSound(Block.soundTypeStone);
		
		icons = new IIcon[6];
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		for (int i = 0; i <=5; i++) {
			icons[i] = iconRegister.registerIcon(Strings.MODID + ":" + getUnlocalizedName());
		}
		
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return icons[side];
	}

}
