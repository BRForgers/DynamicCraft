package brazillianforgers.dynamiccraft.container;

import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerInfusionAltar extends Container{

	private TileEntityInfusionAltar altar;
	
	public ContainerInfusionAltar(InventoryPlayer inventoryPlayer, TileEntityInfusionAltar tilealtar) {
		this.altar = tilealtar;
        
        this.addSlotToContainer(new Slot(tilealtar, 0, 8, 62));
        this.addSlotToContainer(new Slot(tilealtar, 1, 53, 16));
        this.addSlotToContainer(new Slot(tilealtar, 2, 89, 6));
        this.addSlotToContainer(new Slot(tilealtar, 3, 125, 16));
        this.addSlotToContainer(new Slot(tilealtar, 4, 88, 57));
        
        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

		for (i = 0; i < 9; ++i) {
	            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer p) {
		return this.altar.isUseableByPlayer(p);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotn) {
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(slotn);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
                        
                        if (slotn < altar.getSizeInventory()) {
                            if (!this.mergeItemStack(itemstack1, altar.getSizeInventory(), 36+altar.getSizeInventory(), true)) {
                                return null;
                            }
                        }else if(itemstack1.stackSize > 1) {
                            itemstack.stackSize -= (itemstack.stackSize - 1);
                            Slot slt = (Slot) this.inventorySlots.get(0);
                            if(!slt.getHasStack()) {
                                if (this.mergeItemStack(itemstack, 0, altar.getSizeInventory(), false)) {
                                    itemstack1.stackSize -= 1;
                                    return null;
                                }
                                return null;
                            }
                            slot.onSlotChange(itemstack1, itemstack);
                            return null;
                        }else {
                            if (!this.mergeItemStack(itemstack1, 0, altar.getSizeInventory(), false)) {
                                return null;
                            }
                        }
                        
                        if (itemstack1.stackSize == 0) {
                                slot.putStack(null);
                        }else {
                                slot.onSlotChanged();
                        }

                        if (itemstack1.stackSize == itemstack.stackSize) {
                                return null;
                        }
                        slot.onPickupFromSlot(player, itemstack1);
		}

		return itemstack;
	}
}
