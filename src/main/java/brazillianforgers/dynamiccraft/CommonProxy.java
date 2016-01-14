package brazillianforgers.dynamiccraft;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import brazillianforgers.dynamiccraft.entities.EntityFireBall;
import brazillianforgers.dynamiccraft.entities.EntityHandler;
import brazillianforgers.dynamiccraft.entities.EntityFireWizard;
import brazillianforgers.dynamiccraft.handler.APIHandler;
import brazillianforgers.dynamiccraft.handler.BlockHandler;
import brazillianforgers.dynamiccraft.handler.CraftingHandler;
import brazillianforgers.dynamiccraft.handler.GuiHandler;
import brazillianforgers.dynamiccraft.handler.InfusionAltarManager;
import brazillianforgers.dynamiccraft.handler.ItemHandler;
import brazillianforgers.dynamiccraft.handler.events.HandlerCommon;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import brazillianforgers.dynamiccraft.world.WorldGenerator;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	
    public void preInit() {
    	ItemHandler.init();
        BlockHandler.init();
        
        registerEntities();
        registerNetworkStuff();
        registerRender();
		registerRenderHandler();
    }
    
    public void init() {
    	CraftingHandler.Init();
    	InfusionAltarManager.Init();
    }
    
    public void postInit() {
    	GameRegistry.registerWorldGenerator(new WorldGenerator(), 1);
    	APIHandler.Load();
    }
	
    public void registerEvents() {
    	MinecraftForge.EVENT_BUS.register(new HandlerCommon());
    }
    
    public void registerRender() {} //This MUST HAVE NOTHING
    
    public void registerRenderHandler() {} //This MUST HAVE NOTHING
    
    public void registerEntities() {
        EntityRegistry.registerModEntity(EntityFireBall.class, "Fire Ball", 1, DynamicCraft.mod, 64, 10, true);
        
        EntityHandler.registerMobs(EntityFireWizard.class, "Fire Wizard");
        EntityRegistry.addSpawn(EntityFireWizard.class, 30, 0, 1, EnumCreatureType.monster, BiomeGenBase.hell);
        
        //Tile
        GameRegistry.registerTileEntity(TileEntityInfusionAltar.class, "TileEntityInfusionAltar");
    }
    
    public void registerNetworkStuff() {
    	NetworkRegistry.INSTANCE.registerGuiHandler(DynamicCraft.mod, new GuiHandler());
    }
    
}
