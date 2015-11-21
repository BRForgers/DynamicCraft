package brazillianforgers.dynamiccraft;

import brazillianforgers.dynamiccraft.entities.EntityFireBall;
import brazillianforgers.dynamiccraft.entities.EntityFireWizard;
import brazillianforgers.dynamiccraft.handler.ItemHandler;
import brazillianforgers.dynamiccraft.renders.RenderFireBall;
import brazillianforgers.dynamiccraft.renders.RenderFireWand;
import brazillianforgers.dynamiccraft.renders.RenderFireWizard;
import brazillianforgers.dynamiccraft.renders.RenderInfusionAltar;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLStateEvent;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class Client extends Common{
	
	public static void init() {
		registerRender();
		registerRenderHandler();
	}
    
    public static void registerRender() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFireBall.class, new RenderFireBall());
        RenderingRegistry.registerEntityRenderingHandler(EntityFireWizard.class, new RenderFireWizard(new ModelBiped(), 0.3F));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfusionAltar.class, new RenderInfusionAltar());
        
        MinecraftForgeClient.registerItemRenderer(ItemHandler.fireWand, (IItemRenderer) new RenderFireWand());
    }
    
    public static void registerRenderHandler() {
        
    }
}
