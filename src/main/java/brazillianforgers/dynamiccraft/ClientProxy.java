package brazillianforgers.dynamiccraft;

import brazillianforgers.dynamiccraft.client.KeyInputHandler;
import brazillianforgers.dynamiccraft.entities.EntityFireBall;
import brazillianforgers.dynamiccraft.entities.EntityFireWizard;
import brazillianforgers.dynamiccraft.handler.BlockHandler;
import brazillianforgers.dynamiccraft.handler.ItemHandler;
import brazillianforgers.dynamiccraft.handler.events.HandlerClient;
import brazillianforgers.dynamiccraft.renders.RenderFireBall;
import brazillianforgers.dynamiccraft.renders.RenderFireWand;
import brazillianforgers.dynamiccraft.renders.RenderFireWizard;
import brazillianforgers.dynamiccraft.renders.RenderInfusionAltar;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLStateEvent;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy{
	
    public void registerRender() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFireBall.class, new RenderFireBall());
        RenderingRegistry.registerEntityRenderingHandler(EntityFireWizard.class, new RenderFireWizard(new ModelBiped(), 0.3F));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfusionAltar.class, new RenderInfusionAltar(new TileEntityInfusionAltar()));
        
        MinecraftForgeClient.registerItemRenderer(ItemHandler.fireWand, (IItemRenderer) new RenderFireWand());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockHandler.infusionAltar), new RenderInfusionAltar(new TileEntityInfusionAltar()));
    }
    
    public void registerRenderHandler() {
        
    }
    
    public void registerEvents() {
    	super.registerEvents();
    	
    	MinecraftForge.EVENT_BUS.register(new HandlerClient());
    	FMLCommonHandler.instance().bus().register(new HandlerClient());
    	FMLCommonHandler.instance().bus().register(new KeyInputHandler());
    }
}
