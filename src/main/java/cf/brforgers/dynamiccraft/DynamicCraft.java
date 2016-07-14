package cf.brforgers.dynamiccraft;

import cf.brforgers.dynamiccraft.handler.ItemHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.apache.logging.log4j.Logger;

/**
 * DynamicCraft Mod
 *
 * @author BrazilianForgers Team - By: Whyssky
 */

@Mod(modid = Strings.MODID, version = Strings.VERSION, name = Strings.MODNAME, dependencies = Strings.DEPENDENCIES)
public class DynamicCraft {
    /*
     * GUI'S
     */
    public static final int guiIdInfusion = 8;
    public static final int guiIdMagicFinder = 0;
    public static CreativeTabs dynamicTab = new CreativeTabs("dynamicTab") {
        public Item getTabIconItem() {
            return ItemHandler.dynamicPearl;
        }
    };
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
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent e) {
        proxy.init();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e) {
        proxy.postInit();
    }
}
