package brazillianforgers.dynamiccraft.handler;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfusionRecipes {
	
	private static List<Item> first = new ArrayList<Item>();
	
	public static void registerRecipes() {
		addRecipe(first, Items.iron_ingot, Items.diamond, Items.gold_ingot);
	}
	
	private static void addRecipe(List<Item> list, Item item, Item item2, Item item3) {
		list.add(item);
		list.add(item2);
		list.add(item3);
	}
	
	public static ItemStack getSmeltingResult(Item item, Item item2, Item item3) {
		return getOutput(item, item2, item3);
	}

	public static ItemStack getOutput(Item item, Item item2, Item item3) {
		
		if(first.contains(item) && first.contains(item2) && first.contains(item3)) {
			return new ItemStack(Items.bone, 1);
		}
		return null;
	}
}
