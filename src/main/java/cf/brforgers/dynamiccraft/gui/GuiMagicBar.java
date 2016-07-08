package cf.brforgers.dynamiccraft.gui;

import cf.brforgers.dynamiccraft.api.magic.IMagicalItem;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import org.lwjgl.opengl.GL11;

//
//GuiBuffBar implements a simple status bar at the top of the screen which 
//shows the current buffs/debuffs applied to the character.
//
public class GuiMagicBar extends Gui
{
	private Minecraft mc;

	public GuiMagicBar(Minecraft mc) {
		super();
	 
	 	// We need this to invoke the render engine.
	 	this.mc = mc;
	}

	/*
	* This event is called by GuiIngameForge during each frame by
	* GuiIngameForge.pre() and GuiIngameForce.post().
	*/
	@SubscribeEvent(priority = EventPriority.LOW)
	public void onRenderBar(RenderGameOverlayEvent event) {
		if(event.isCancelable() || event.type != ElementType.ALL || mc.thePlayer.getHeldItem() == null ||
				!(mc.thePlayer.getHeldItem().getItem() instanceof IMagicalItem)) {  
			return;
		}
		
		IMagicalItem f = (IMagicalItem) mc.thePlayer.getHeldItem().getItem();

		// Starting position for the buff bar - 2 pixels from the top left corner.
		int xPos = 2;
		int yPos = 100;

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("dynamiccraft", "textures/gui/magic.png"));      
		
		this.drawTexturedModalRect(xPos, yPos, 6, 0, 5, 70);
		
		int i1;
		if(f.getMagic(mc.thePlayer.getHeldItem()) > 0) {
			i1 = f.getMagic(mc.thePlayer.getHeldItem()) * 70 / f.getMaxMagic(mc.thePlayer.getHeldItem());
			
			this.drawTexturedModalRect(xPos, yPos + 70 - i1, 0, 70 - i1, 5, i1);
		}
		
	}
}