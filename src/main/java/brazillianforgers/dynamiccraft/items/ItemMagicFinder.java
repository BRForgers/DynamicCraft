package brazillianforgers.dynamiccraft.items;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.api.magic.ItemMagic;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMagicFinder extends ItemMagic{
	
	public ItemMagicFinder() {
		super(1000);
		
		setCreativeTab(DynamicCraft.dynamicTab);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		int x = entityPlayer.serverPosX;
		int y = entityPlayer.serverPosY;
		int z = entityPlayer.serverPosZ;
		if (!world.isRemote) {
			System.out.println("Opening the gui");
			FMLNetworkHandler.openGui(entityPlayer, DynamicCraft.mod, DynamicCraft.guiIdMagicFinder, world, x, y, z);
		}
		return super.onItemRightClick(itemStack, world, entityPlayer);
	}
	
}
