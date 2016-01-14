package brazillianforgers.dynamiccraft.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import brazillianforgers.lib.RecipeHelper.ICraftable;
import brazillianforgers.lib.RecipeHelper.Recipe;
import brazillianforgers.lib.RecipeHelper.RecipeValue;

public class CraftingHandler{
	
	public static void Init() {
		registerRecipe();
		registerShapeless();
	}
	
	private static void registerRecipe() {
		addRecipe(new ItemStack(BlockHandler.infusionAltar), new Object[] {
			"B B",
			"QPQ",
			"PEP", 'B', new ItemStack(Blocks.iron_bars), 'E', new ItemStack(Blocks.enchanting_table), 'P', new ItemStack(ItemHandler.dynamicPearl),
					'Q', new ItemStack(Items.quartz)
		});
	}
	
	private static void registerShapeless() {
		
	}
	
	private static void addRecipe(ItemStack result, Object[] recipe) {
		GameRegistry.addRecipe(result, recipe);
	}

}
