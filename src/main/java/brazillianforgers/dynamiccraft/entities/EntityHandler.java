package brazillianforgers.dynamiccraft.entities;

import java.util.Random;

import brazillianforgers.dynamiccraft.DynamicCraft;
import net.minecraft.entity.EntityList;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {
	
	public static void registerMobs(Class entityClass, String name, int mainColor, int subColor) {
		
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, DynamicCraft.mod, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColor, subColor));
		
	}
}
