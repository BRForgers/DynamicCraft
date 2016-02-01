package brazillianforgers.dynamiccraft.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class ContainerMagicFinder extends Container{

	public ContainerMagicFinder(EntityPlayer player, InventoryPlayer inv, ItemStack stack, 
			InventoryMagicFinder inventoryItem) {
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
}
