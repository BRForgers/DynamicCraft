package brazillianforgers.dynamiccraft.container.slot;

import brazillianforgers.dynamiccraft.handler.ItemHandler;
import brazillianforgers.dynamiccraft.lib.Strings;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

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
	
	@Override
	public boolean isItemValid(ItemStack stack){
        return stack.getItem() == ItemHandler.baseRune;
    }
}
