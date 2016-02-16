package brazillianforgers.dynamiccraft.container;

import brazillianforgers.dynamiccraft.api.magic.IMagicalItem;
import brazillianforgers.dynamiccraft.handler.ItemHandler;
import brazillianforgers.dynamiccraft.items.ItemMagicCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerMagicCollector extends Container{
	
	InventoryMagicCollector inventory = null;
	ItemStack finder = null;
	ItemMagicCollector iFinder = null;
	
	private int lastPowerTime;
	
	public ItemStack getCollectorStack() {
		return finder;
	}
	
	public ItemMagicCollector getCollectorItem() {
		return iFinder;
	}
	
	public ContainerMagicCollector(EntityPlayer player, InventoryPlayer inv, ItemStack stack, 
			InventoryMagicCollector inventoryItem) {
		
		this.finder = stack;
		this.iFinder = (ItemMagicCollector) stack.getItem();
		this.inventory = inventoryItem;
		
		this.addSlotToContainer(new Slot(inventoryItem, 0, 82, 28) {
			@Override
			public boolean isItemValid(ItemStack stack){
		        return stack.getItem() instanceof IMagicalItem;
		    }
		});
		
		int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18) {
                	public boolean canTakeStack(EntityPlayer player) {
    					if(this.getHasStack()) {
    						if(this.getStack().getItem() instanceof ItemMagicCollector) {
    							return false;
    						}
    					}
    					return true;
    				}
                });
            }
        }

		for (i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142) {
				public boolean canTakeStack(EntityPlayer player) {
					if(this.getHasStack()) {
						if(this.getStack().getItem() instanceof ItemMagicCollector) {
							return false;
						}
					}
					return true;
				}
			});
		}
	}
	
	public void addCraftingToCrafters(ICrafting par1ICrafting)
	{
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, iFinder.getMagic(finder));
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting)this.crafters.get(i);

			if (this.lastPowerTime != iFinder.getMagic(finder))
			{
				icrafting.sendProgressBarUpdate(this, 0, iFinder.getMagic(finder));
			}
		}

		this.lastPowerTime = iFinder.getMagic(finder);
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		this.iFinder.setMagic(finder, par2);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	@Override
	public void onContainerClosed(EntityPlayer player){
		World world = player.worldObj;

		if (!world.isRemote){
			ItemStack stack = player.getCurrentEquippedItem();
			inventory.writeToNBT(stack.getTagCompound());
		}

		super.onContainerClosed(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotn) {
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(slotn);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (slotn < inventory.getSizeInventory()) {
				if (!this.mergeItemStack(itemstack1, 1, inventorySlots.size(), true)) {
					return null;
				}
			}else {
				if(itemstack.getItem() instanceof IMagicalItem)
					if (!this.mergeItemStack(itemstack1, 0, inventorySlots.size(), false)) {
						return null;
					}
			}
                        
			if (itemstack1.stackSize <= 0) {
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
