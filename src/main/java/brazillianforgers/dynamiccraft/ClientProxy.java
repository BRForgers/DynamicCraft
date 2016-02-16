package brazillianforgers.dynamiccraft;

import brazillianforgers.dynamiccraft.client.KeyBindings;
import brazillianforgers.dynamiccraft.client.KeyInputHandler;
import brazillianforgers.dynamiccraft.entities.EntityFireBall;
import brazillianforgers.dynamiccraft.entities.EntityFireMode;
import brazillianforgers.dynamiccraft.entities.EntityFireWizard;
import brazillianforgers.dynamiccraft.gui.GuiMagicBar;
import brazillianforgers.dynamiccraft.handler.BlockHandler;
import brazillianforgers.dynamiccraft.handler.ItemHandler;
import brazillianforgers.dynamiccraft.handler.events.HandlerClient;
import brazillianforgers.dynamiccraft.network.NetworkHandler;
import brazillianforgers.dynamiccraft.renders.RenderFireBall;
import brazillianforgers.dynamiccraft.renders.RenderFireMode;
import brazillianforgers.dynamiccraft.renders.RenderFireWand;
import brazillianforgers.dynamiccraft.renders.RenderFireWizard;
import brazillianforgers.dynamiccraft.renders.RenderInfusionAltar;
import brazillianforgers.dynamiccraft.renders.RenderMagicCollector;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLStateEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy{
	
    public void registerRender() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFireBall.class, new RenderFireBall());
        RenderingRegistry.registerEntityRenderingHandler(EntityFireWizard.class, new RenderFireWizard(new ModelBiped(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFireMode.class, new RenderFireMode());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfusionAltar.class, new RenderInfusionAltar(new TileEntityInfusionAltar()));
        
        MinecraftForgeClient.registerItemRenderer(ItemHandler.fireWand, (IItemRenderer) new RenderFireWand());
        MinecraftForgeClient.registerItemRenderer(ItemHandler.magicFinder, (IItemRenderer) new RenderMagicCollector());
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
