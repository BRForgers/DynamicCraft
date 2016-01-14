package brazillianforgers.dynamiccraft.renders;

import org.lwjgl.opengl.GL11;

import brazillianforgers.dynamiccraft.Strings;
import brazillianforgers.dynamiccraft.models.ModelInfusionAltar;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class RenderInfusionAltar extends TileEntitySpecialRenderer implements IItemRenderer{

	private final ModelInfusionAltar model;
    ItemStack stack;
    
    public static RenderInfusionAltar instance;
    
    public static ResourceLocation texture = new ResourceLocation(Strings.MODID + ":textures/model/ModelInfusionAltar.png");
    
    private TileEntity tile;
	
    public RenderInfusionAltar(TileEntity ent) {
    	tile = ent;
        model = new ModelInfusionAltar();
        instance = this;
    }
    
	@Override
    public void renderTileEntityAt(TileEntity ent, double x, double y, double z, float f) {
		TileEntityInfusionAltar altar = (TileEntityInfusionAltar) ent;
        
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        model.render((Entity) null, 0, 0, 0, 0, 0, 0.0625F);
        GL11.glPopMatrix();
        
        if(altar.getStackInSlot(4) == null && altar.getStackInSlot(2) != null) {
        	stack = altar.getStackInSlot(2);
        }else if(altar.getStackInSlot(4) != null) {
        	stack = altar.getStackInSlot(4);
        }
        
        if(altar.getStackInSlot(2) != null || altar.getStackInSlot(4) != null) {
        	EntityItem entItem = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, stack);
        	
        	GL11.glPushMatrix();
            GL11.glTranslatef((float)x + 0.5F,(float)y + 0.75F,(float)z + 0.5F);
            GL11.glRotatef(360,0,1,1);
            entItem.hoverStart = 0.0F;
            
            if(entItem.getEntityItem().getItem() instanceof ItemBlock && Block.getBlockFromItem(entItem.getEntityItem().getItem()).isBlockNormalCube()) {
                GL11.glScalef(1.3F, 1.3F, 1.3F);
            }
            
            GL11.glEnable(GL11.GL_CULL_FACE);
            if(Minecraft.isFancyGraphicsEnabled()) {
                float rotationAngle=(float)(720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
                GL11.glRotatef(rotationAngle,0F,1F,0F);
            }
            RenderManager.instance.renderEntityWithPosYaw(entItem, 0, 0, 0, 0, 0);
       
            GL11.glPopMatrix();
        }
    }

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if(type == IItemRenderer.ItemRenderType.ENTITY)
			GL11.glTranslatef(-0.5F, 0.0F, -0.5F);


		this.renderTileEntityAt(this.tile, 0.0D, 0.0D, 0.0D, 0.0F);
	}
}
