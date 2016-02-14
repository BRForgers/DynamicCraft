package brazillianforgers.dynamiccraft.items;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.api.magic.ItemMagic;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMagicFinder extends ItemMagic{
	
	public ItemMagicFinder() {
		super(1000);
		
		setCreativeTab(DynamicCraft.dynamicTab);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
			player.openGui(DynamicCraft.mod, DynamicCraft.guiIdMagicFinder, world, (int) player.posX, (int) player.posY, 
					(int) player.posZ);
		return itemStack;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity ent, int i, boolean b) {
		super.onUpdate(stack, world, ent, i, b);
		
		int r = this.itemRand.nextInt(100) + 1;
		
		
	}
	
}
