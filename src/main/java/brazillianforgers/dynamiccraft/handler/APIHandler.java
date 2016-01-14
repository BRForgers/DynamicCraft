package brazillianforgers.dynamiccraft.handler;

import java.util.List;

import brazillianforgers.dynamiccraft.api.DynamicCraftAPI;
import brazillianforgers.dynamiccraft.api.infusion.InfusionAltarRecipe;

public class APIHandler {
	public static void Load()
	{
		List<InfusionAltarRecipe> recipesFromAPI = DynamicCraftAPI.infusionAltarRecipes;
		
		for (InfusionAltarRecipe recipe : recipesFromAPI) {
			InfusionAltarManager.addRecipe(recipe.itemResult, recipe.item1, recipe.item2, recipe.item3);
		}
	}
}
