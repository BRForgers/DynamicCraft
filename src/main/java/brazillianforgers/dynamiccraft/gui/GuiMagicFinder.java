package brazillianforgers.dynamiccraft.gui;

import org.lwjgl.opengl.GL11;

import brazillianforgers.dynamiccraft.container.ContainerMagicFinder;
import brazillianforgers.dynamiccraft.container.InventoryMagicFinder;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiMagicFinder extends GuiContainer{

	private static final ResourceLocation texture = new ResourceLocation("dynamiccraft", "textures/gui/magicfinder.png");
	
	public GuiMagicFinder(EntityPlayer player, InventoryPlayer inv, ItemStack stack,InventoryMagicFinder inventoryItem) {
		super(new ContainerMagicFinder(player, inv, stack, inventoryItem));

		this.xSize = 176;
		this.ySize = 165;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
