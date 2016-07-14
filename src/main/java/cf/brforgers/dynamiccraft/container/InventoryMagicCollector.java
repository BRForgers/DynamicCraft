package cf.brforgers.dynamiccraft.container;

import cf.brforgers.dynamiccraft.api.magic.IMagicalItem;
import cf.brforgers.dynamiccraft.items.ItemMagicCollector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class InventoryMagicCollector implements IInventory {
    /**
     * Provides NBT Tag Compound to reference
     */
    private final ItemStack invItem;

    private ItemStack slot;

    public InventoryMagicCollector(ItemStack stack) {
        invItem = stack;

        // Create a new NBT Tag Compound if one doesn't already exist, or you will crash
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        // note that it's okay to use stack instead of invItem right there
        // both reference the same memory location, so whatever you change using
        // either reference will change in the other

        // Read the inventory contents from NBT
        readFromNBT(stack.getTagCompound());
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.slot;
    }

    @Override
    public ItemStack decrStackSize(int slotID, int i) {
        if (slot != null) {
            ItemStack stack;
            if (slot.stackSize <= i) {
                stack = slot;
                slot = null;
                return stack;
            } else {
                stack = slot.splitStack(i);

                if (slot.stackSize == 0) {
                    slot = null;
                }
                return stack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int I) {
        if (slot != null) {
            ItemStack itemstack = slot;
            slot = null;
            return itemstack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int slotID, ItemStack stack) {
        slot = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
        markDirty();
    }

    @Override
    public String getInventoryName() {
        return "Magic Finder";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    /**
     * This is the method that will handle saving the inventory contents, as it is called (or should be called!)
     * anytime the inventory changes. Perfect. Much better than using onUpdate in an Item, as this will also
     * let you change things in your inventory without ever opening a Gui, if you want.
     */
    @Override
    public void markDirty() {
        for (int i = 0; i < getSizeInventory(); ++i) {
            if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0) {
                slot = null;
            }
        }

        // This line here does the work:
        writeToNBT(invItem.getTagCompound());
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return true;
    }

    @Override
    public void openInventory() {
        if (!invItem.hasTagCompound()) {
            invItem.setTagCompound(new NBTTagCompound());
        }
        readFromNBT(invItem.getTagCompound());
    }

    @Override
    public void closeInventory() {
        markDirty();
    }

    @Override
    public boolean isItemValidForSlot(int slotID, ItemStack stack) {
        return stack.getItem() instanceof IMagicalItem;
    }

    public void readFromNBT(NBTTagCompound NBTTagCompound) {
        ItemMagicCollector mf = (ItemMagicCollector) invItem.getItem();
        mf.setMagic(invItem, NBTTagCompound.getShort("Magic"));

        slot = ItemStack.loadItemStackFromNBT(NBTTagCompound);
    }

    /**
     * Writes a tile entity to NBT.
     */

    public void writeToNBT(NBTTagCompound NBTTagCompound) {
        ItemMagicCollector mf = (ItemMagicCollector) invItem.getItem();
        if (slot != null) {
            slot.writeToNBT(NBTTagCompound);
        }
    }
}
