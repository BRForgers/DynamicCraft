package brazillianforgers.dynamiccraft;

import brazillianforgers.dynamiccraft.lib.Strings;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * DynamicCraft Mod
 * @author BrazillianForgers Team
 */

@Mod(modid = Strings.MODID , version = Strings.VERSION , name = Strings.MODNAME)
public class DynamicCraft {
    
    @Mod.Instance(Strings.MODID)
    public static DynamicCraft mod;
    
    @SidedProxy(clientSide = Strings.CLIENT, serverSide = Strings.COMMON)
    public static Common proxy;
        
    @Mod.EventHandler
    public static void preLoad(FMLPreInitializationEvent event) {
		
    }
	
    @Mod.EventHandler
    public static void load(FMLInitializationEvent event) {
        
    }
	
    @Mod.EventHandler 
    public static void postLoad(FMLPostInitializationEvent event) {
		
    }
    
}