package cf.brforgers.dynamiccraft;

import cf.brforgers.core.lib.DungeonManager;
import cf.brforgers.dynamiccraft.entities.EntityAquaBall;
import cf.brforgers.dynamiccraft.entities.EntityFireBall;
import cf.brforgers.dynamiccraft.entities.EntityFireWizard;
import cf.brforgers.dynamiccraft.entities.EntityHandler;
import cf.brforgers.dynamiccraft.handler.*;
import cf.brforgers.dynamiccraft.handler.events.HandlerCommon;
import cf.brforgers.dynamiccraft.network.NetworkHandler;
import cf.brforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import cf.brforgers.dynamiccraft.world.WorldGenerator;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;

import static cf.brforgers.core.lib.DungeonManager.DungeonChests.*;

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

        registerEvents();
    }

    public void postInit() {
        GameRegistry.registerWorldGenerator(new WorldGenerator(), 1);
        APIHandler.Load();
    }

    public void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new HandlerCommon());
        FMLCommonHandler.instance().bus().register(new HandlerCommon());
    }

    public void registerRender() {
    } //This MUST HAVE NOTHING

    public void registerRenderHandler() {
    } //This MUST HAVE NOTHING

    public void registerEntities() {
        EntityRegistry.registerModEntity(EntityFireBall.class, "Fire Ball", 1, DynamicCraft.mod, 64, 10, true);
        EntityRegistry.registerModEntity(EntityAquaBall.class, "Aqua Ball", 2, DynamicCraft.mod, 64, 10, true);

        EntityHandler.registerMobs(EntityFireWizard.class, "fireWizard", 0x990000, 0x0);
        EntityRegistry.addSpawn(EntityFireWizard.class, 3, 0, 1, EnumCreatureType.monster, BiomeGenBase.hell);

        //Tile
        GameRegistry.registerTileEntity(TileEntityInfusionAltar.class, "TileEntityInfusionAltar");
    }

    public void registerNetworkStuff() {
        NetworkRegistry.INSTANCE.registerGuiHandler(DynamicCraft.mod, new GuiHandler());
        NetworkHandler.initServerMessages();
    }

    public void registerDungeonLoots() {
        DungeonManager.addChestLoot(new DungeonManager.DungeonChests[]{
                VILLAGE_BLACKSMITH, DUNGEON_CHEST, MINESHAFT_CORRIDOR
        }, new ItemStack(ItemHandler.baseRune), 1, 1, 30);
    }

}
