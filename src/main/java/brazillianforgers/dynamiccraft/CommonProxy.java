package brazillianforgers.dynamiccraft;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import brazillianforgers.dynamiccraft.entities.*;
import brazillianforgers.dynamiccraft.handler.*;
import brazillianforgers.dynamiccraft.handler.events.HandlerClient;
import brazillianforgers.dynamiccraft.handler.events.HandlerCommon;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import brazillianforgers.dynamiccraft.world.WorldGenerator;
import brazillianforgers.lib.DungeonManager;
import static brazillianforgers.lib.DungeonManager.DungeonChests;

import cpw.mods.fml.common.FMLCommonHandler;
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
		registerDungeonLoots();
    }
    
    public void init() {
    	CraftingHandler.Init();
    	InfusionAltarManager.Init();
    	
    	new KeyBindings();
    	registerEvents();
    }
    
    public void postInit() {
    	GameRegistry.registerWorldGenerator(new WorldGenerator(), 1);
    	APIHandler.Load();
    }
	
    public void registerEvents() {
    	MinecraftForge.EVENT_BUS.register(new HandlerCommon());
    	FMLCommonHandler.instance().bus().register(new HandlerClient());
    }
    
    public void registerRender() {} //This MUST HAVE NOTHING
    
    public void registerRenderHandler() {} //This MUST HAVE NOTHING
    
    public void registerEntities() {
        EntityRegistry.registerModEntity(EntityFireBall.class, "Fire Ball", 1, DynamicCraft.mod, 64, 10, true);
        
        EntityHandler.registerMobs(EntityFireWizard.class, "fireWizard");
        EntityRegistry.addSpawn(EntityFireWizard.class, 3, 0, 1, EnumCreatureType.monster, BiomeGenBase.hell);
        
        //Tile
        GameRegistry.registerTileEntity(TileEntityInfusionAltar.class, "TileEntityInfusionAltar");
    }
    
    public void registerNetworkStuff() {
    	NetworkRegistry.INSTANCE.registerGuiHandler(DynamicCraft.mod, new GuiHandler());
    }
    
    public void registerDungeonLoots() {
    	DungeonManager.addChestLoot(new DungeonChests[] {
    			DungeonChests.VILLAGE_BLACKSMITH, DungeonChests.DUNGEON_CHEST, DungeonChests.MINESHAFT_CORRIDOR
    	}, new ItemStack(ItemHandler.baseRune), 1, 1, 30);
    }
    
}
