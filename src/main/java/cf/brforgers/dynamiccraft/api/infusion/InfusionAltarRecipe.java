package cf.brforgers.dynamiccraft.api.infusion;

import net.minecraft.item.ItemStack;

public class InfusionAltarRecipe {
	public ItemStack item1, item2, item3, itemResult;
	
	public InfusionAltarRecipe(ItemStack result, ItemStack item1, ItemStack item2, ItemStack item3)
	{
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.itemResult = result;
	}
}
