package cf.brforgers.dynamiccraft.handler;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class InfusionAltarManager {
	
	private static final HashMap<List<ItemStack>, ItemStack> RECIPES = new HashMap<List<ItemStack>, ItemStack>();
	
	//private static final InfusionAltarManager SMELTING_BASE = new InfusionAltarManager();
	//public static InfusionAltarManager smelting() {
	//	return SMELTING_BASE;
	//}
	
	//private static InfusionAltarManager instance = new InfusionAltarManager();
	//public static InfusionAltarManager getInstance() {
	//	return instance;
	//}
	private static boolean init = false;
	
	public static HashMap getRecipeMap() {
		return RECIPES;
	}

	public static void Init() {
		if (init) return;
		
		addRecipe(new ItemStack(ItemHandler.fireRune), new ItemStack(Items.flint), new ItemStack(ItemHandler.baseRune), new ItemStack(Items.fire_charge));
		addRecipe(new ItemStack(ItemHandler.aquaRune), new ItemStack(Items.potionitem), new ItemStack(ItemHandler.baseRune), new ItemStack(Items.diamond_helmet));
		addRecipe(new ItemStack(ItemHandler.earthRune), new ItemStack(Items.sugar), new ItemStack(ItemHandler.baseRune), new ItemStack(Item.getItemById(2)));
		init = true;
	}
	
	private static List<ItemStack> generateRecipeList(ItemStack item1, ItemStack item2, ItemStack item3)
	{
		List<ItemStack> list = new ArrayList<ItemStack>();
		list.add(item1);
		list.add(item2);
		list.add(item3);
		return list;
	}
	
	public static void addRecipe(ItemStack result, ItemStack item1, ItemStack item2, ItemStack item3) {
		RECIPES.put(generateRecipeList(item1, item2, item3), result);
	}

	public static ItemStack getResult(ItemStack item1, ItemStack item2, ItemStack item3) {
		Iterator iterator = RECIPES.entrySet().iterator();
		Entry entry;
		
		do {
			if (!iterator.hasNext()) {
				return null;
			}
			entry = (Entry) iterator.next();
		} while (!canBe(generateRecipeList(item1, item2, item3), (List<ItemStack>) entry.getKey()));
		
		return (ItemStack) entry.getValue();
	}
	
	public static boolean canBe(List<ItemStack> lista, List<ItemStack> igre) {
		return (lista.get(0).isItemEqual((igre.get(0))) || lista.get(0).isItemEqual(igre.get(2))) && lista.get(1).isItemEqual(igre.get(1)) &&
				(lista.get(2).isItemEqual(igre.get(2)) || lista.get(2).isItemEqual(igre.get(0)));
	}
}
