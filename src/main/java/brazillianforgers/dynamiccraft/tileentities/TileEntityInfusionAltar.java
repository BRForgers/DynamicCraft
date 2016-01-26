package brazillianforgers.dynamiccraft.tileentities;

import java.util.Random;

import brazillianforgers.dynamiccraft.api.DynamicCraftAPI;
import brazillianforgers.dynamiccraft.api.infusion.InfusionAltarFuel;
import brazillianforgers.dynamiccraft.api.magic.IMagic;
import brazillianforgers.dynamiccraft.handler.InfusionAltarManager;
import brazillianforgers.dynamiccraft.handler.ItemHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInfusionAltar extends TileEntity implements ISidedInventory{

	private static final int[] slots_sides = new int[] {1, 2, 3};
	private ItemStack[] slots = new ItemStack[5];
	
	public int processSpeed = 400;
	public int magic = 0;
	public int maxMagic = 800;
	
	public int processTime;
	
	Random rand = new Random();
	
	@SideOnly(Side.CLIENT)
	public int getProgressScaled(int par1) {
  		return this.processTime * par1 / this.processSpeed;
	}

	public int getMagicRemainingScaled(int par1){
    	return this.magic * par1 / this.maxMagic;
	}

	public boolean hasMagic() {
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
    public int[] getAccessibleSlotsFromSide(int side) {
        return slots_sides;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stk, int side) {
        return isItemValidForSlot(slot, stk);
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return true;
    }
    
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
    	super.readFromNBT(par1NBTTagCompound);
    	this.magic = par1NBTTagCompound.getShort("power");
    	this.processTime = par1NBTTagCompound.getShort("processTime");
    	
    	NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", processTime);
    	this.slots = new ItemStack[this.getSizeInventory()];

    	for (int i = 0; i < nbttaglist.tagCount(); ++i)
    	{
    			NBTTagCompound tagCompound1 = nbttaglist.getCompoundTagAt(i);
        		byte b0 = tagCompound1.getByte("Slot");

        		if (b0 >= 0 && b0 < this.slots.length)
        		{
            		this.slots[b0] = ItemStack.loadItemStackFromNBT(tagCompound1);
        		}
    	}
	}

	/**
 	* Writes a tile entity to NBT.
 	*/
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
    	super.writeToNBT(par1NBTTagCompound);
    	par1NBTTagCompound.setShort("power", (short)this.magic);
    	par1NBTTagCompound.setShort("processTime", (short)this.processTime);
    	
    	NBTTagList nbttaglist = new NBTTagList();

    	for (int i = 0; i < this.slots.length; ++i)
    	{	
        		if (this.slots[i] != null)
        		{
            		NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            		nbttagcompound1.setByte("Slot", (byte)i);
            		this.slots[i].writeToNBT(nbttagcompound1);
            		nbttaglist.appendTag(nbttagcompound1);
        		}
    	}

    	par1NBTTagCompound.setTag("Items", nbttaglist);
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
        return 64;
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
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return slot == 4? false : (slot == 0? isMagicalItem(stack) > 0 : true);
    }

    @Override
    public void updateEntity() {
	    boolean flag = this.magic > 0;
		boolean flag1 = false;
		
		if(hasMagic() && magic > maxMagic) {
			magic = maxMagic;
		}
	
		if (hasMagic() && isActive()){
	    	this.magic-=2;
	    	
	    	if(this.getWorldObj().isRemote) {
	    		
	    		
		    	double f1 = rand.nextDouble() - 0.5;
		    	double f2 = rand.nextDouble() - 0.5;
		    	double f3 = rand.nextDouble() - 0.5;
		    	
		    	double x = this.xCoord;
		    	double y = this.yCoord;
		    	double z = this.zCoord;
						
		    	for(int i = 0; i <= 3; i++) {
		    		worldObj.spawnParticle("enchantmenttable", x + 1, y + 0.5, z + 0.5, f1, f2, f3);
		    		worldObj.spawnParticle("enchantmenttable", x, y + 0.5, z + 0.5, f1, f2, f3);
		    		worldObj.spawnParticle("enchantmenttable", x + 0.5, y + 1, z + 0.5, f1, f2, f3);
		    		worldObj.spawnParticle("enchantmenttable", x + 0.5, y, z + 0.5, f1, f2, f3);
		    		worldObj.spawnParticle("enchantmenttable", x + 0.5, y + 0.5, z + 1, f1, f2, f3);
		    		worldObj.spawnParticle("enchantmenttable", x + 0.5, y + 0.5, z, f1, f2, f3);
		    	}
	    	}
		}
	
		if (!this.worldObj.isRemote){
	    	if (isMagicalItem(this.slots[0]) > 0 && this.magic < this.maxMagic){
	    		this.magic += isMagicalItem(this.slots[0]);
	
	    		flag1 = true;
	    	
	    		if (this.slots[0] != null){
	            		this.slots[0].stackSize--;
	
	            		if (this.slots[0].stackSize == 0){
	                		this.slots[0] = this.slots[0].getItem().getContainerItem(slots[0]);
	            		}
	        	}                
	    	}
	
	    	if (this.hasMagic() && this.canSmelt())
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
    
    public static int isMagicalItem(ItemStack par0ItemStack){
    	if (par0ItemStack != null){
    		ItemStack i = par0ItemStack;
        	
    		if(i.getItem() instanceof IMagic) {
    			IMagic f = (IMagic) i.getItem();
    			
    			return f.getMagic();
    		}
    		
        	return 0;
    	}
        
    	return 0;
	}
    
    private boolean canSmelt(){
		if (this.slots[1] == null || slots[2] == null || slots[3] == null) {
			return false;
		} else {
			ItemStack itemstack = InfusionAltarManager.getResult(this.slots[1], this.slots[2], this.slots[3]);
			
			if (itemstack == null) return false;
			if (this.slots[4] == null) return true;
			if (!this.slots[4].isItemEqual(itemstack)) return false;
			int result = slots[4].stackSize + itemstack.stackSize;
			return result <= getInventoryStackLimit() && result <= this.slots[4].getMaxStackSize();
		}
	}
    
	public void smeltItem(){
    	if (this.canSmelt()) {
			ItemStack itemstack = InfusionAltarManager.getResult(this.slots[1], this.slots[2], this.slots[3]);

			if (this.slots[4] == null) {
				this.slots[4] = itemstack.copy();
			} else if (this.slots[2].getItem() == itemstack.getItem()) {
				this.slots[4].stackSize += itemstack.stackSize;
			}
			
			this.slots[1].stackSize--;
			this.slots[2] = null;
			this.slots[3].stackSize--;
			
			if(slots[1].stackSize == 0)
				slots[1] = null;
			if(slots[3].stackSize == 0)
				slots[3] = null;
		}
	}
}
