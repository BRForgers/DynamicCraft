package brazillianforgers.dynamiccraft.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfusionRecipes {
	
	private static List<Item> fireRune = new ArrayList<Item>();
	
	public static void registerRecipes() {
		addRecipe(fireRune, Items.iron_ingot, Items.diamond, Items.gold_ingot);
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
		
		if(fireRune.contains(item) && fireRune.get(1) == item2 && fireRune.contains(item3)) {
			return new ItemStack(ItemHandler.fireRune, 1);
		}
		return null;
	}
}
