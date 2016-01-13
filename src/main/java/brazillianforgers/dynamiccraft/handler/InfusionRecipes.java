package brazillianforgers.dynamiccraft.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfusionRecipes {
	
	private HashMap<ItemStack, List<Item>> recipes = new HashMap<ItemStack,List<Item>>();
	
	//Arrays
	private List<Item> fireRune = new ArrayList<Item>();
	private List<Item> aquaRune = new ArrayList<Item>();
	private List<Item> earthRune = new ArrayList<Item>();
	
	private static final InfusionRecipes SMELTING_BASE = new InfusionRecipes();
	public static InfusionRecipes smelting() {
		return SMELTING_BASE;
	}
	
	private static InfusionRecipes instance = new InfusionRecipes();
	public static InfusionRecipes getInstance() {
		return instance;
	}
	
	public HashMap getRecipeList() {
		return recipes;
	}
	
	private InfusionRecipes() {
		addRecipe(new ItemStack(ItemHandler.fireRune, 1), fireRune, Items.flint, ItemHandler.baseRune, Items.fire_charge);
		addRecipe(new ItemStack(ItemHandler.aquaRune, 1), aquaRune, Items.potionitem, ItemHandler.baseRune, Items.diamond_helmet);
		addRecipe(new ItemStack(ItemHandler.earthRune, 1), earthRune, Items.sugar, ItemHandler.baseRune, Item.getItemById(2));
	}
	
	private void addRecipe(ItemStack result, List<Item> list, Item item, Item item2, Item item3) {
		list.add(item);
		list.add(item2);
		list.add(item3);
		
		recipes.put(result, list);
	}

	public ItemStack getResult(Item item, Item item2, Item item3) {
		List<Item> list = new ArrayList();
		list.add(item);
		list.add(item2);
		list.add(item3);
		
		Iterator iterator = recipes.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}
			entry = (Entry) iterator.next();
		} while (!canBe(list, (List<Item>)entry.getValue()));
		return (ItemStack) entry.getKey();
	}
	
	private boolean canBe(List<Item> list, List<Item> recipeList) {
		return recipeList.contains(list.get(0)) && recipeList.get(1) == list.get(1) && recipeList.contains(list.get(2));
	}
}
