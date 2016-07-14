package cf.brforgers.dynamiccraft.handler;

import cf.brforgers.dynamiccraft.api.DynamicCraftAPI;
import cf.brforgers.dynamiccraft.api.infusion.InfusionAltarRecipe;

import java.util.List;

public class APIHandler {
    public static void Load() {
        List<InfusionAltarRecipe> recipesFromAPI = DynamicCraftAPI.infusionAltarRecipes;

        for (InfusionAltarRecipe recipe : recipesFromAPI) {
            InfusionAltarManager.addRecipe(recipe.itemResult, recipe.item1, recipe.item2, recipe.item3);
        }
    }
}
