package cf.brforgers.dynamiccraft.handler;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static cpw.mods.fml.common.registry.GameRegistry.addRecipe;
import static cpw.mods.fml.common.registry.GameRegistry.addShapelessRecipe;

public class CraftingHandler{
	
	public static void Init() {
		registerRecipe();
		registerShapeless();
	}
	
	private static void registerRecipe() {
		addRecipe(new ItemStack(BlockHandler.infusionAltar), "B B",
				"QPQ",
				"PEP", 'B', new ItemStack(Blocks.iron_bars), 'E', new ItemStack(Blocks.enchanting_table), 'P', new ItemStack(ItemHandler.dynamicPearl),
				'Q', new ItemStack(Items.quartz));

		addRecipe(new ItemStack(ItemHandler.dynamicPearl), "SRS",
				"RSR",
				"SRS", 'S', new ItemStack(ItemHandler.dynamicShard), 'R', new ItemStack(Items.redstone));
		
		addRecipe(new ItemStack(BlockHandler.blockDynamic),
				"DDD",
				"DDD",
				"DDD",
				'D', ItemHandler.dynamicPearl
		);

		addRecipe(new ItemStack(ItemHandler.magicFinder), "MMM",
				"POP",
				"MMM", 'M', new ItemStack(Blocks.log), 'P', new ItemStack(ItemHandler.dynamicPearl), 'O', new ItemStack(Items.ender_eye));
	}

	private static void registerShapeless() {
		addShapelessRecipe(new ItemStack(ItemHandler.dynamicPearl, 9), BlockHandler.blockDynamic);
	}
}
