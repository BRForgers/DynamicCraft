package cf.brforgers.dynamiccraft.api.magic;

import net.minecraft.item.ItemStack;

public interface IMagicalItem extends IMagic {

    /*
     * Extract magic from storage
     */
    int extractMagic(ItemStack stk, int extract);

    /*
     * Add magic to storage
     */
    int receiveMagic(ItemStack stk, int receive);

    /*
     * Get the max amount of magic that can be stored by item
     */
    int getMaxMagic(ItemStack stk);

}
