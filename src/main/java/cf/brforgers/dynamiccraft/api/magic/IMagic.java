package cf.brforgers.dynamiccraft.api.magic;

import net.minecraft.item.ItemStack;

public interface IMagic {

    /*
     * Gets the amount of magic
     */
    int getMagic(ItemStack stk);

    void setMagic(ItemStack stk, int amount);

}
