package brazillianforgers.dynamiccraft.handler.events;

import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.client.KeyBindings;
import brazillianforgers.dynamiccraft.handler.ItemHandler;
import brazillianforgers.dynamiccraft.handler.UpdateHandler;
import brazillianforgers.dynamiccraft.items.ItemFireWand;
import brazillianforgers.dynamiccraft.network.MessageModeWand;
import brazillianforgers.dynamiccraft.network.NetworkHandler;
import brazillianforgers.lib.ItemNBTHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class HandlerClient {
	
	//@SubscribeEvent
	//public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent e) {
	//	e.player.addChatMessage(new ChatComponentText(UpdateHandler.updateStatus));
	//}
	
}
