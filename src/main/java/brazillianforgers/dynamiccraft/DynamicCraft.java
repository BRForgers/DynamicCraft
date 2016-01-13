package brazillianforgers.dynamiccraft;

import brazillianforgers.dynamiccraft.handler.*;
import brazillianforgers.dynamiccraft.handler.events.*;
import brazillianforgers.dynamiccraft.lib.Strings;
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
 * @author BrazillianForgers Team - By: rennancge (Whyssky_BR)
 */

@Mod(modid = Strings.MODID , version = Strings.VERSION , name = Strings.MODNAME, dependencies = Strings.DEENDENCIES)
public class DynamicCraft {
	
	public static final int guiIdInfusion = 8;
    
    public static Logger log;
    
    @Mod.Instance(Strings.MODID)
    public static DynamicCraft mod;
    
    @SidedProxy(clientSide = Strings.CLIENT, serverSide = Strings.COMMON)
    public static Common proxy;
        
    @Mod.EventHandler
    public static void preLoad(FMLPreInitializationEvent e) {
        log = e.getModLog();
        log.info("Start Loading...");
        
        ItemHandler.init();
        BlockHandler.init();
        
        Common.registerEntities();
        Common.registerNetworkStuff();
        
        if(e.getSide() == Side.CLIENT) {
        	Client.init();
        }
        
        log.info("All Pre-Init modules enabled!");
    }
	
    @Mod.EventHandler
    public static void load(FMLInitializationEvent e) {
    	FMLCommonHandler.instance().bus().register(new HandlerClient());
    	MinecraftForge.EVENT_BUS.register(new HandlerCommon());
    	
    	new CraftingHandler();
    }
	
    @Mod.EventHandler 
    public static void postLoad(FMLPostInitializationEvent e) {
    	GameRegistry.registerWorldGenerator(new WorldGenerator(), 1);
    	UpdateHandler.init();
    }
    
    public static CreativeTabs dynamicTab = new CreativeTabs("dynamicTab") {
		public Item getTabIconItem() {
	            return ItemHandler.dynamicPearl;
		}
    };
    
}
