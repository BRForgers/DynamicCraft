package brazillianforgers.dynamiccraft.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import brazillianforgers.lib.RecipeHelper.ICraftable;
import brazillianforgers.lib.RecipeHelper.Recipe;
import brazillianforgers.lib.RecipeHelper.RecipeValue;

public class CraftingHandler{
	
	public CraftingHandler() {
		registerRecipe();
		registerShapeless();
	}
	
	private void registerRecipe() {
		addRecipe(new ItemStack(BlockHandler.infusionAltar), new Object[] {
			"BDB",
			"POP",
			"OPO", 'B', new ItemStack(Blocks.iron_bars), 'D', new ItemStack(Items.diamond), 'P', new ItemStack(ItemHandler.dynamicPearl),
					'O', new ItemStack(Blocks.obsidian)
		});
	}
	
	private void registerShapeless() {
		
	}
	
	private void addRecipe(ItemStack result, Object[] recipe) {
		GameRegistry.addRecipe(result, recipe);
	}

}
