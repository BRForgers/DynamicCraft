package brazillianforgers.dynamiccraft.container.slot;

import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotInfusionResult extends Slot{
	
	TileEntityInfusionAltar altar;

	public SlotInfusionResult(IInventory iiventory, int i, int j, int k) {
		super(iiventory, i, j, k);
		
		altar = (TileEntityInfusionAltar) iiventory;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
    }
}
