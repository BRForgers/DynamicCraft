package brazillianforgers.dynamiccraft;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import brazillianforgers.dynamiccraft.entities.EntityFireBall;
import brazillianforgers.dynamiccraft.entities.EntityHandler;
import brazillianforgers.dynamiccraft.entities.EntityFireWizard;
import brazillianforgers.dynamiccraft.handler.GuiHandler;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import brazillianforgers.dynamiccraft.world.WorldGenerator;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Common {
    
    public static void registerEntities() {
        EntityRegistry.registerModEntity(EntityFireBall.class, "Fire Ball", 1, DynamicCraft.mod, 64, 10, true);
        
        EntityHandler.registerMobs(EntityFireWizard.class, "Fire Wizard");
        EntityRegistry.addSpawn(EntityFireWizard.class, 30, 0, 1, EnumCreatureType.monster, BiomeGenBase.hell);
        
        //Tile
        GameRegistry.registerTileEntity(TileEntityInfusionAltar.class, "TileEntityInfusionAltar");
    }
    
    public static void registerNetworkStuff() {
    	NetworkRegistry.INSTANCE.registerGuiHandler(DynamicCraft.mod, new GuiHandler());
    }
}
