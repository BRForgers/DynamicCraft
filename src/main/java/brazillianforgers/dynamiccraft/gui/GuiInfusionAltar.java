package brazillianforgers.dynamiccraft.gui;

import org.lwjgl.opengl.GL11;

import brazillianforgers.dynamiccraft.container.ContainerInfusionAltar;
import brazillianforgers.dynamiccraft.lib.Strings;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiInfusionAltar extends GuiContainer{
	
	private static final ResourceLocation texture = new ResourceLocation("dynamiccraft", "textures/gui/infusionaltar.png");

	public GuiInfusionAltar(InventoryPlayer invPlayer, TileEntityInfusionAltar entity) {
		super(new ContainerInfusionAltar(invPlayer, entity));
		
		this.xSize = 176;
		this.ySize = 165;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int j, int i) {
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
			
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

}