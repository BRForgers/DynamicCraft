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

public class InfusionAltarManager {
	
	private static HashMap<List<ItemStack>, ItemStack> recipes = new HashMap<List<ItemStack>, ItemStack>();
	
	//private static final InfusionAltarManager SMELTING_BASE = new InfusionAltarManager();
	//public static InfusionAltarManager smelting() {
	//	return SMELTING_BASE;
	//}
	
	//private static InfusionAltarManager instance = new InfusionAltarManager();
	//public static InfusionAltarManager getInstance() {
	//	return instance;
	//}
	
	public static HashMap getRecipeList() {
		return recipes;
	}
	
	private boolean init = false;
	public void Init() {
		if (init) return;
		
		addRecipe(new ItemStack(ItemHandler.fireRune), new ItemStack(Items.flint), new ItemStack(ItemHandler.baseRune), new ItemStack(Items.fire_charge));
		addRecipe(new ItemStack(ItemHandler.aquaRune), new ItemStack(Items.potionitem), new ItemStack(ItemHandler.baseRune), new ItemStack(Items.diamond_helmet));
		addRecipe(new ItemStack(ItemHandler.earthRune), new ItemStack(Items.sugar), new ItemStack(ItemHandler.baseRune), new ItemStack(Item.getItemById(2)));
	}
	
	public static void addRecipe(ItemStack result, ItemStack item1, ItemStack item2, ItemStack item3) {
		List<ItemStack> list = new ArrayList<ItemStack>();
		list.add(item1);
		list.add(item2);
		list.add(item3);
		
		recipes.put(list, result);
	}

	public static ItemStack getResult(ItemStack item1, ItemStack item2, ItemStack item3) {
		List<ItemStack> list = new ArrayList<ItemStack>();
		list.add(item1);
		list.add(item2);
		list.add(item3);
		
		return recipes.get(list);
	}
}
