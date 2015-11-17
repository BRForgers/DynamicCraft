package brazillianforgers.dynamiccraft.container.slot;

import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotInfusionMiddle extends Slot{

	TileEntityInfusionAltar altar;
	
	public SlotInfusionMiddle(IInventory iiventory, int i, int j, int k) {
		super(iiventory, i, j, k);
		
		this.altar = (TileEntityInfusionAltar) iiventory;
	}
	
	@Override
	public int getSlotStackLimit() {
        return 1;
    }
}
