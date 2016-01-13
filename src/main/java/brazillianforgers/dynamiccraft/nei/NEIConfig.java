package brazillianforgers.dynamiccraft.nei;

import brazillianforgers.dynamiccraft.gui.GuiInfusionAltar;
import brazillianforgers.dynamiccraft.lib.Strings;
import net.minecraft.item.ItemStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIConfig implements IConfigureNEI{

	public void loadConfig() {
		
		API.registerRecipeHandler(new InfusionAltarHandler());
		API.registerUsageHandler(new InfusionAltarHandler());
		API.setGuiOffset(GuiInfusionAltar.class, 0, 0);
	}

	public String getName() {
		return "DynamicCraft Plugin";
	}

	public String getVersion() {
		return Strings.VERSION;
	}
	
}
