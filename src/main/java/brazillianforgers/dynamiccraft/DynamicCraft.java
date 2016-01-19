package brazillianforgers.dynamiccraft;

import brazillianforgers.core.UpdateChecker;
import brazillianforgers.dynamiccraft.handler.*;
import brazillianforgers.dynamiccraft.handler.events.*;
import brazillianforgers.dynamiccraft.world.WorldGenerator;
import brazillianforgers.lib.RecipeHelper.RecipeHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLStateEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Logger;

/**
 * DynamicCraft Mod
 * @author BrazillianForgers Team - By: Whyssky
 */

@Mod(modid = Strings.MODID , version = Strings.VERSION , name = Strings.MODNAME, dependencies = Strings.DEENDENCIES)
public class DynamicCraft {
	public static CreativeTabs dynamicTab = new CreativeTabs("dynamicTab") {
		public Item getTabIconItem() {
	            return ItemHandler.dynamicPearl;
		}
    };
	
	public static final int guiIdInfusion = 8;
    
    public static Logger logger;
    
    @Mod.Instance(Strings.MODID)
    public static DynamicCraft mod;
    
    @SidedProxy(clientSide = Strings.CLIENT, serverSide = Strings.COMMON)
    public static CommonProxy proxy;
        
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();
        logger.info("Start Loading...");
        
        proxy.preInit();
        
        UpdateChecker.addToUpdateChecker(Strings.MODID, Strings.MODNAME, Strings.UPDATEURL, Strings.VERSION, logger);
    }
	
    @Mod.EventHandler
    public static void init(FMLInitializationEvent e) {
    	proxy.init();
    	//MinecraftForge.EVENT_BUS.register(new HandlerClient());
    }
	
    @Mod.EventHandler 
    public static void postInit(FMLPostInitializationEvent e) {
    	proxy.postInit();
    	
    	//UpdateHandler.init();
    }    
}
