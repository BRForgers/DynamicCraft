package cf.brforgers.dynamiccraft.nei;

import cf.brforgers.dynamiccraft.Strings;
import cf.brforgers.dynamiccraft.gui.GuiInfusionAltar;
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
