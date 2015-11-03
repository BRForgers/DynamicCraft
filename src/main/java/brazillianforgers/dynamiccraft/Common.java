package brazillianforgers.dynamiccraft;

import brazillianforgers.dynamiccraft.entities.EntityFireBall;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Common {
    
    public static void registerEntities() {
        EntityRegistry.registerModEntity(EntityFireBall.class, "Fire Ball", 1, DynamicCraft.mod, 64, 10, true);
    }
    
    public static void registerNetworkStuff() {
        
    }
}
