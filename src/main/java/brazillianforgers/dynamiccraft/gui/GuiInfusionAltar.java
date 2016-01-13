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
	private TileEntityInfusionAltar altar;
	
	public GuiInfusionAltar(InventoryPlayer invPlayer, TileEntityInfusionAltar entity) {
		super(new ContainerInfusionAltar(invPlayer, entity));
		
		this.altar = entity;
		this.xSize = 176;
		this.ySize = 165;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int j, int i) {
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
			
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		int i1;

		if(this.altar.hasMagic()){
			i1 = this.altar.getMagicRemainingScaled(47);
			
			this.drawTexturedModalRect(guiLeft + 11, guiTop + 57 - i1, 177, 47 - i1, 9, i1);
		}
		
		i1 = this.altar.getProgressScaled(28);
		this.drawTexturedModalRect(guiLeft + 66, guiTop + 24, 187, 0, 59, i1);
	}

}