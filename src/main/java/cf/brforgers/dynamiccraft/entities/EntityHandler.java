package cf.brforgers.dynamiccraft.entities;

import cf.brforgers.dynamiccraft.DynamicCraft;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;

public class EntityHandler {
	
	public static void registerMobs(Class entityClass, String name, int mainColor, int subColor) {
		
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, DynamicCraft.mod, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColor, subColor));
		
	}
}
