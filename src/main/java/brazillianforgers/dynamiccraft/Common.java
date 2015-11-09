package brazillianforgers.dynamiccraft;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import brazillianforgers.dynamiccraft.entities.EntityFireBall;
import brazillianforgers.dynamiccraft.entities.EntityHandler;
import brazillianforgers.dynamiccraft.entities.EntityFireWizard;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Common {
    
    public static void registerEntities() {
        EntityRegistry.registerModEntity(EntityFireBall.class, "Fire Ball", 1, DynamicCraft.mod, 64, 10, true);
        
        EntityHandler.registerMobs(EntityFireWizard.class, "Fire Wizard");
        EntityRegistry.addSpawn(EntityFireWizard.class, 1, 0, 1, EnumCreatureType.monster, BiomeGenBase.swampland);
    }
    
    public static void registerNetworkStuff() {
        
    }
}
