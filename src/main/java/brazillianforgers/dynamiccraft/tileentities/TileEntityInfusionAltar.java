package brazillianforgers.dynamiccraft.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInfusionAltar extends TileEntity implements ISidedInventory{

	private static final int[] slots_sides = new int[] {0, 1, 2, 3, 4};
	private ItemStack[] slots = new ItemStack[5];
	
	@Override
    public int getSizeInventory() {
        return this.slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int stk) {
        return this.slots[stk];
    }
    
    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return slots_sides;
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return true;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return true;
    }

    @Override
    public ItemStack decrStackSize(int slot, int i) {
        if(slots[slot] != null) {
            ItemStack stack;
            if(slots[slot].stackSize <= i) {
                stack = slots[slot];
                slots[slot] = null;
                return stack;
            }else {
                stack = slots[slot].splitStack(i);
                
                if(slots[slot].stackSize == 0) {
                    slots[slot] = null;
                }
                return stack;
            }
        }else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if(slots[i] != null) {
            ItemStack itemstack = slots[i];
            slots[i] = null;
            return itemstack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        slots[slot] = stack;
        
        if(stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return "container.infusionaltar";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack stack) {
        return stack != null;
    }

}
