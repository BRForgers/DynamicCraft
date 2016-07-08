package cf.brforgers.dynamiccraft.gui;

import cf.brforgers.dynamiccraft.container.ContainerInfusionAltar;
import cf.brforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class GuiInfusionAltar extends GuiContainer{
	
	private static final ResourceLocation texture = new ResourceLocation("dynamiccraft", "textures/gui/infusionaltar.png");
	float mouseX;
	float mouseY;
	private TileEntityInfusionAltar altar;
	public GuiInfusionAltar(InventoryPlayer invPlayer, TileEntityInfusionAltar entity) {
		super(new ContainerInfusionAltar(invPlayer, entity));

		this.altar = entity;
		this.xSize = 176;
		this.ySize = 165;
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3) {
        this.mouseX = (float)par1;
        this.mouseY = (float)par2;
        super.drawScreen(par1, par2, par3);
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		int k = (this.width - this.xSize) / 2; //X asis on GUI
		int l = (this.height - this.ySize) / 2; //Y asis on GUI
		if (this.mouseX > guiLeft + 11 && mouseX < guiLeft + 11 + 10) {//Basically checking if mouse is in the correct area
			if (mouseY > guiTop + 10 && mouseY < guiTop + 10 + 48){
				List list = new ArrayList();
				list.add(EnumChatFormatting.DARK_PURPLE + EnumChatFormatting.BOLD.toString() + "Magic: " + altar.magic + "/" + altar.maxMagic);
				this.drawHoveringText(list, (int)mouseX - k, (int)mouseY - l, Minecraft.getMinecraft().fontRenderer);
			}
		}
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