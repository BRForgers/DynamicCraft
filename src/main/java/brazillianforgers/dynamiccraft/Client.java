package brazillianforgers.dynamiccraft;

import brazillianforgers.dynamiccraft.entities.EntityFireBall;
import brazillianforgers.dynamiccraft.renders.RenderFireBall;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class Client extends Common{
    
    public static void registerRender() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFireBall.class, new RenderFireBall());
    }
    
    public static void registerRenderHandler() {
        
    }
}
