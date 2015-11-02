package brazillianforgers.dynamiccraft;

import brazillianforgers.dynamiccraft.lib.Strings;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

/**
 * DynamicCraft Mod
 * @author BrazillianForgers Team
 */

@Mod(modid = Strings.MODID , version = Strings.VERSION , name = Strings.MODNAME, dependencies = "required-after:BRForgersCore@[1.0, 2.0]")
public class DynamicCraft {
    
    static Logger log;
    
    @Mod.Instance(Strings.MODID)
    public static DynamicCraft mod;
    
    @SidedProxy(clientSide = Strings.CLIENT, serverSide = Strings.COMMON)
    public static Common proxy;
        
    @Mod.EventHandler
    public static void preLoad(FMLPreInitializationEvent e) {
        //Get Logger
        log = e.getModLog();
        //Init Logger
        log.info("Start Loading...");
        
        
        
        //End Logger
        log.info("All Pre-Init modules enabled!");
    }
	
    @Mod.EventHandler
    public static void load(FMLInitializationEvent e) {
        
    }
	
    @Mod.EventHandler 
    public static void postLoad(FMLPostInitializationEvent e) {
		
    }
    
}