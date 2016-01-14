package test;

import brazillianforgers.dynamiccraft.api.DynamicCraftAPI;
import brazillianforgers.dynamiccraft.api.infusion.InfusionAltarFuel;
import brazillianforgers.dynamiccraft.api.infusion.InfusionAltarRecipe;
import brazillianforgers.dynamiccraft.handler.ItemHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

//@Mod(modid = "APITester")
public class TestMod {
	//@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		DynamicCraftAPI.infusionAltarFuel.add(
				new InfusionAltarFuel(
						new ItemStack(Items.ender_eye),
						400
						)
				);
		DynamicCraftAPI.infusionAltarRecipes.add(
				new InfusionAltarRecipe(
						new ItemStack(Items.ender_eye),
						new ItemStack(Items.ender_pearl),
						new ItemStack(ItemHandler.baseRune),
						new ItemStack(Items.blaze_powder)
						)
				);
	}
}
