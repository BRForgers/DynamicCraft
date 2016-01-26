package brazillianforgers.dynamiccraft.api.magic;

import net.minecraft.item.ItemStack;

public interface IMagicalItem {
	
	/*
	 * Gets the amount of magic currently stored
	 */
	int getMagic(ItemStack stk);
	
	
	int extractMagic(ItemStack stk, int extract);
	
	int receiveMagic(ItemStack stk, int receive);
	
	/*
	 * Get the max amount of magic that can be stored by item
	 */
	int getMaxMagic(ItemStack stk);
	
}
