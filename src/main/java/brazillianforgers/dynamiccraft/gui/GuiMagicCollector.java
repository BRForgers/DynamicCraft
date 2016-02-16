package brazillianforgers.dynamiccraft.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import brazillianforgers.dynamiccraft.container.ContainerMagicCollector;
import brazillianforgers.dynamiccraft.container.InventoryMagicCollector;
import brazillianforgers.dynamiccraft.items.ItemMagicCollector;
import brazillianforgers.lib.ItemNBTHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;

public class GuiMagicCollector extends GuiContainer{

	private static final ResourceLocation texture = new ResourceLocation("dynamiccraft", "textures/gui/magicfinder.png");
	private ItemStack finder = null;
	private ItemMagicCollector iFinder = null;
	private EntityPlayer p;
	
	private int porc = 0;
	
	public GuiMagicCollector(EntityPlayer player, InventoryPlayer inv, ItemStack stack, InventoryMagicCollector inventoryItem) {
		super(new ContainerMagicCollector(player, inv, stack, inventoryItem));
		
		if(ItemNBTHelper.getString(stack, "biome", "").contains(BiomeGenBase.extremeHills.biomeName) ||
				ItemNBTHelper.getString(stack, "biome", "").contains(BiomeGenBase.swampland.biomeName)) {
			porc = 25;
		}else {
			porc = 5;
		}
		
		this.p = player;
		this.finder = stack;
		this.iFinder = (ItemMagicCollector) stack.getItem();
				
		this.xSize = 176;
		this.ySize = 165;
	}
	
	float mouseX;
	float mouseY;
	
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
		
		if (this.mouseX > guiLeft + 21 && mouseX < guiLeft + 21 + 135) {//Basically checking if mouse is in the correct area
			if (mouseY > guiTop + 12 && mouseY < guiTop + 12 + 11){
				List list = new ArrayList();
				
				list.add(EnumChatFormatting.DARK_PURPLE + EnumChatFormatting.BOLD.toString() + "Magic: " + iFinder.getMagic(finder) + "/" + iFinder.getMaxMagic(finder));
				this.drawHoveringText(list, (int)mouseX - k, (int)mouseY - l, Minecraft.getMinecraft().fontRenderer);
			}
		}
		
		String s = "Chance: " + porc + "%";
		
		this.fontRendererObj.drawString(s, 112, 66, 0x808080);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		int i1;

		if(iFinder.getMagic(finder) > 0){
			i1 = iFinder.getMagic(finder) * 135 / iFinder.getMaxMagic(finder);
			
			this.drawTexturedModalRect(guiLeft + 21, guiTop + 10, 0, 166, i1, 11);
		}
	}

}
