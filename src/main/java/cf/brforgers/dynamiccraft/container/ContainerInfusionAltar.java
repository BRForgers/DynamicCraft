package cf.brforgers.dynamiccraft.container;

import cf.brforgers.dynamiccraft.handler.ItemHandler;
import cf.brforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerInfusionAltar extends Container{

	private TileEntityInfusionAltar altar;
	private int lastProgressTime;
	private int lastPowerTime;
	
	public ContainerInfusionAltar(InventoryPlayer inv, TileEntityInfusionAltar tilealtar) {
		this.altar = tilealtar;
        
        this.addSlotToContainer(new Slot(tilealtar, 0, 8, 62) {
        	@Override
        	public boolean isItemValid(ItemStack stack) {
				return TileEntityInfusionAltar.isMagicalItem(stack) > 0;
			}
        });
        this.addSlotToContainer(new Slot(tilealtar, 1, 53, 16));
        this.addSlotToContainer(new Slot(tilealtar, 2, 89, 6) {
        	@Override
        	public boolean isItemValid(ItemStack stack){
                return stack.getItem() == ItemHandler.baseRune;
            }
        });
        this.addSlotToContainer(new Slot(tilealtar, 3, 125, 16));
        this.addSlotToContainer(new Slot(tilealtar, 4, 88, 57) {
        	@Override
        	public boolean isItemValid(ItemStack stack) {
        		return false;
            }
        });
        
        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

		for (i = 0; i < 9; ++i) {
	            this.addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
		}
	}
	
	public void addCraftingToCrafters(ICrafting par1ICrafting)
	{
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.altar.processTime);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.altar.magic);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting)this.crafters.get(i);

			if (this.lastProgressTime != this.altar.processTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, this.altar.processTime);
			}

			if (this.lastPowerTime != this.altar.magic)
			{
				icrafting.sendProgressBarUpdate(this, 1, this.altar.magic);
			}
		}

		this.lastProgressTime = this.altar.processTime;
		this.lastPowerTime = this.altar.magic;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0)
		{
			this.altar.processTime = par2;
		}

		if (par1 == 1)
		{
			this.altar.magic = par2;
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

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (slotn < altar.getSizeInventory()) {
				if (!this.mergeItemStack(itemstack1, 5, inventorySlots.size(), true)) {
					return null;
				}
			}else {
				Slot p = (Slot)this.inventorySlots.get(0);
				if(p.isItemValid(itemstack1) && !this.mergeItemStack(itemstack1, 0, altar.getSizeInventory() - 1, false)) {
					return null;
				}else if(!p.isItemValid(itemstack1)){
					if (!this.mergeItemStack(itemstack1, 1, altar.getSizeInventory() - 1, false)) {
						return null;
					}
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
