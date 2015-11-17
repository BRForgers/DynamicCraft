package brazillianforgers.dynamiccraft.container.slot;

import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotInfusionPower extends Slot{

	TileEntityInfusionAltar altar;
	
	public SlotInfusionPower(IInventory iiventory, int i, int j, int k) {
		super(iiventory, i, j, k);
		
		this.altar = (TileEntityInfusionAltar) iiventory;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return altar.getItemPower(stack) > 0;
    }
	
	@Override
	public int getSlotStackLimit() {
        return 64;
    }

}