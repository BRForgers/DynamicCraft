package brazillianforgers.dynamiccraft;

import brazillianforgers.dynamiccraft.entities.EntityFireBall;
import brazillianforgers.dynamiccraft.entities.EntityWizard;
import brazillianforgers.dynamiccraft.items.ItemHandler;
import brazillianforgers.dynamiccraft.renders.RenderFireBall;
import brazillianforgers.dynamiccraft.renders.RenderFireWand;
import brazillianforgers.dynamiccraft.renders.RenderWizard;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class Client extends Common{
    
    public static void registerRender() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFireBall.class, new RenderFireBall());
        RenderingRegistry.registerEntityRenderingHandler(EntityWizard.class, new RenderWizard(new ModelBiped(), 0.3F));
        
        MinecraftForgeClient.registerItemRenderer(ItemHandler.fireWand, (IItemRenderer) new RenderFireWand());
    }
    
    public static void registerRenderHandler() {
        
    }
}
