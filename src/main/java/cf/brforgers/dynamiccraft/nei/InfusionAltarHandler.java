package cf.brforgers.dynamiccraft.nei;

import cf.brforgers.dynamiccraft.Strings;
import cf.brforgers.dynamiccraft.gui.GuiInfusionAltar;
import cf.brforgers.dynamiccraft.handler.InfusionAltarManager;
import cf.brforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import codechicken.nei.ItemList;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;

public class InfusionAltarHandler extends TemplateRecipeHandler{

    public static ArrayList<FuelPair> afuels;
    public static HashSet<Block> efuels;

    private static Set<Item> excludedFuels() {
        Set<Item> efuels = new HashSet<Item>();
        return efuels;
    }

    private static void findFuels() {
        afuels = new ArrayList<FuelPair>();
        Set<Item> efuels = excludedFuels();
        for (ItemStack item : ItemList.items)
            if (!efuels.contains(item.getItem())) {
                int burnTime = TileEntityInfusionAltar.isMagicalItem(item);
                if (burnTime > 0)
                    afuels.add(new FuelPair(item, burnTime));
            }
    }

	public String getRecipeName() {
		return "Infusion Altar";
	}

	public String getGuiTexture() {

		return new ResourceLocation(Strings.MODID, "textures/gui/infusionaltar.png").toString();
	}

    public void loadTransferRects() {
    	transferRects.add(new RecipeTransferRect(new Rectangle(78, 34, 24, 18), "infusion"));
    }

    public Class<? extends GuiContainer> getGuiClass() {
    	return GuiInfusionAltar.class;
    }

    public TemplateRecipeHandler newInstance() {
        if (afuels == null)
            findFuels();
        return super.newInstance();
    }

    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals("infusion") && getClass() == InfusionAltarHandler.class) {//don't want subclasses getting a hold of this
            Map<List<ItemStack>, ItemStack> recipes = (Map<List<ItemStack>, ItemStack>) InfusionAltarManager.getRecipeMap();
            for (Entry<List<ItemStack>, ItemStack> recipe : recipes.entrySet())
                arecipes.add(new SmeltingPair(recipe.getKey(), recipe.getValue()));
            	
        } else
            super.loadCraftingRecipes(outputId, results);
    }

    public void loadCraftingRecipes(ItemStack result) {
        Map<List<ItemStack>, ItemStack> recipes = (Map<List<ItemStack>, ItemStack>) InfusionAltarManager.getRecipeMap();
        for (Entry<List<ItemStack>, ItemStack> recipe : recipes.entrySet())
            if (NEIServerUtils.areStacksSameType(recipe.getValue(), result))
            	arecipes.add(new SmeltingPair(recipe.getKey(), recipe.getValue()));
        	
    }

    public void loadUsageRecipes(String inputId, Object... ingredients) {
        if (inputId.equals("infusion") && getClass() == InfusionAltarHandler.class)//don't want subclasses getting a hold of this
            loadCraftingRecipes("infusion");
        else
            super.loadUsageRecipes(inputId, ingredients);
    }

    public void loadUsageRecipes(ItemStack ingredient) {
        Map<List<ItemStack>, ItemStack> recipes = (Map<List<ItemStack>, ItemStack>) InfusionAltarManager.getRecipeMap();
        for (Entry<List<ItemStack>, ItemStack> recipe : recipes.entrySet())
            if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getValue(), ingredient)) {
                SmeltingPair arecipe = new SmeltingPair(recipe.getKey(), recipe.getValue());
                
                List l = new ArrayList();
            	l.add(arecipe.ingred1);
            	l.add(arecipe.ingred2);
            	l.add(arecipe.ingred3);
            	
                arecipe.setIngredientPermutation(l, ingredient);
                arecipes.add(arecipe);
            }
    }

    public void drawExtras(int recipe) {
    	drawProgressBar(6, 0, 177, 2, 9, 47, 48, 3);
    	drawProgressBar(62, 13, 188, 0, 59, 28, 48, 1);
    }

    public String getOverlayIdentifier() {
        return "infusion";
    }

    public static class FuelPair {
        public PositionedStack stack;
        public int burnTime;

        public FuelPair(ItemStack ingred, int burnTime) {
            this.stack = new PositionedStack(ingred, 3, 49, false);
            this.burnTime = burnTime;
        }
    }

    public class SmeltingPair extends CachedRecipe {
        PositionedStack ingred1;
        PositionedStack ingred2;
        PositionedStack ingred3;
        PositionedStack result;

        public SmeltingPair(List<ItemStack> ingred, ItemStack result) {

            this.ingred1 = new PositionedStack(ingred.get(0), 48, 5);
            this.ingred2 = new PositionedStack(ingred.get(1), 84, -5);
            this.ingred3 = new PositionedStack(ingred.get(2), 120, 5);

            this.result = new PositionedStack(result, 84, 46);
        }

        public List<PositionedStack> getIngredients() {
            List<PositionedStack> l = new ArrayList<PositionedStack>();
            l.add(ingred1);
            l.add(ingred2);
            l.add(ingred3);

            return getCycledIngredients(cycleticks / 48, l);
        }

        public PositionedStack getResult() {
            return result;
        }

        public PositionedStack getOtherStack() {
            return afuels.get((cycleticks / 48) % afuels.size()).stack;
        }
    }
}
