package cf.brforgers.dynamiccraft;

import cf.brforgers.dynamiccraft.client.KeyBindings;
import cf.brforgers.dynamiccraft.client.KeyInputHandler;
import cf.brforgers.dynamiccraft.entities.EntityAquaBall;
import cf.brforgers.dynamiccraft.entities.EntityFireBall;
import cf.brforgers.dynamiccraft.entities.EntityFireMode;
import cf.brforgers.dynamiccraft.entities.EntityFireWizard;
import cf.brforgers.dynamiccraft.gui.GuiMagicBar;
import cf.brforgers.dynamiccraft.handler.BlockHandler;
import cf.brforgers.dynamiccraft.handler.ItemHandler;
import cf.brforgers.dynamiccraft.handler.events.HandlerClient;
import cf.brforgers.dynamiccraft.network.NetworkHandler;
import cf.brforgers.dynamiccraft.renders.*;
import cf.brforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy{
	
    public void registerRender() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFireBall.class, new RenderFireBall());
        RenderingRegistry.registerEntityRenderingHandler(EntityAquaBall.class, new RenderFireBall());
        RenderingRegistry.registerEntityRenderingHandler(EntityFireWizard.class, new RenderFireWizard(new ModelBiped(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFireMode.class, new RenderFireMode());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfusionAltar.class, new RenderInfusionAltar(new TileEntityInfusionAltar()));

        MinecraftForgeClient.registerItemRenderer(ItemHandler.fireWand, new RenderFireWand());
        MinecraftForgeClient.registerItemRenderer(ItemHandler.magicFinder, new RenderMagicCollector());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockHandler.infusionAltar), new RenderInfusionAltar(new TileEntityInfusionAltar()));
    }
    
    public void registerRenderHandler() {
        
    }
    
    public void registerEvents() {
    	super.registerEvents();
    	
    	MinecraftForge.EVENT_BUS.register(new HandlerClient());
    	MinecraftForge.EVENT_BUS.register(new GuiMagicBar(Minecraft.getMinecraft()));
    	FMLCommonHandler.instance().bus().register(new HandlerClient());
    	FMLCommonHandler.instance().bus().register(new KeyInputHandler());
    }
    
    public void registerNetworkStuff() {
    	super.registerNetworkStuff();
    	
    	NetworkHandler.initClientMessages();
    	for(KeyBindings kb : KeyBindings.values()) {
    		KeyBinding key = kb.getKeybind();
    		
    		ClientRegistry.registerKeyBinding(key);
    	}
    }
}
