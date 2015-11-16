package brazillianforgers.dynamiccraft.tileentities;

import brazillianforgers.dynamiccraft.handler.InfusionRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInfusionAltar extends TileEntity implements ISidedInventory{

	private static final int[] slots_sides = new int[] {1, 2, 3};
	private ItemStack[] slots = new ItemStack[5];
	
	public int processSpeed = 400;
	public int magic;
	public int maxMagic = 800;
	
	public int processTime;
	
	@SideOnly(Side.CLIENT)
	public int getProgressScaled(int par1) {
  		return this.processTime * par1 / this.processSpeed;
	}

	public int getMagicRemainingScaled(int par1){
    	return this.magic * par1 / this.maxMagic;
	}

	public boolean hasPower() {
    	return this.magic > 0;
	}

	public boolean isActive(){
		return this.processTime > 0;
	}
	
	public int getPower() {
		return magic;
	}
	
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
    
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
    	super.readFromNBT(par1NBTTagCompound);
    	this.magic = par1NBTTagCompound.getShort("power");
    	this.processTime = par1NBTTagCompound.getShort("cookTime");
	}

	/**
 	* Writes a tile entity to NBT.
 	*/
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
    	super.writeToNBT(par1NBTTagCompound);
    	par1NBTTagCompound.setShort("power", (short)this.magic);
    	par1NBTTagCompound.setShort("CookTime", (short)this.processTime);
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

    @Override
    public void updateEntity() {
    	System.out.println(magic);
	    boolean flag = this.magic > 0;
		boolean flag1 = false;
	
		if (hasPower() && isActive()){
	    		this.magic-=2;
		}
	
		if (!this.worldObj.isRemote){
	    	if (this.magic < this.maxMagic && this.getItemPower(this.slots[0]) > 0){
	    		this.magic += getItemPower(this.slots[0]);
	
	    		flag1 = true;
	    	
	    		if (this.slots[0] != null){
	            		this.slots[0].stackSize--;
	
	            		if (this.slots[0].stackSize == 0){
	                		this.slots[0] = this.slots[0].getItem().getContainerItem(slots[0]);
	            		}
	        	}                
	    	}
	
	    	if (this.hasPower() && this.canSmelt())
	    	{
	        	++this.processTime;
	
	        	if (this.processTime == this.processSpeed)
	        	{
	            	this.processTime = 0;
	            	this.smeltItem();
	           	flag1 = true;
	        	}
	    	}
	    	else
	    	{
	        	this.processTime = 0;
	    	}
		}
	
		if (flag1){
	    		this.markDirty();
		}
    }
    
    public static int getItemPower(ItemStack par0ItemStack){
    	if (par0ItemStack == null){
        	return 0;
    	}else{
    		ItemStack i = par0ItemStack;
    	
    		if (i.getItem() == Items.apple) return 50;
        	return 0;
    	}
	}
    
    private boolean canSmelt(){
		if (this.slots[1] == null || slots[2] == null || slots[3] == null) {
			return false;
		} else {
			ItemStack itemstack = InfusionRecipes.getSmeltingResult(this.slots[1].getItem(), this.slots[2].getItem(), this.slots[3].getItem());
			
			if (itemstack == null) return false;
			if (this.slots[4] == null) return true;
			if (!this.slots[4].isItemEqual(itemstack)) return false;
			int result = slots[4].stackSize + itemstack.stackSize;
			return result <= getInventoryStackLimit() && result <= this.slots[4].getMaxStackSize();
		}
	}
    
	public void smeltItem(){
    	if (this.canSmelt()) {
			ItemStack itemstack = InfusionRecipes.getSmeltingResult(this.slots[1].getItem(), this.slots[2].getItem(), this.slots[3].getItem());

			if (this.slots[4] == null) {
				this.slots[4] = itemstack.copy();
			} else if (this.slots[2].getItem() == itemstack.getItem()) {
				this.slots[4].stackSize += itemstack.stackSize;
			}
			
			this.slots[1] = null;
			this.slots[2] = null;
			this.slots[3] = null;
		}
	}
}