package brazillianforgers.dynamiccraft.renders;

import brazillianforgers.dynamiccraft.Strings;
import brazillianforgers.dynamiccraft.models.ModelFireWand;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderFireWand implements IItemRenderer{
    private final ModelFireWand wand;
    
    public static ResourceLocation texture = new ResourceLocation(Strings.MODID + ":textures/model/ModelFireWand.png");
   
    public RenderFireWand() {
        wand = new ModelFireWand();
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch(type){    
        	case EQUIPPED: 
	            GL11.glPushMatrix();
	           
	            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	           
	            GL11.glRotatef(25, 0F, 1F, 0F);
	            GL11.glRotatef(150, 1F, 0F, 0F);
	            GL11.glRotatef(0, 0F, 0F, 1F);
	            GL11.glTranslatef(0.2F, -2F, -1F);
	            GL11.glScalef(1.7F, 1.7F, 1.7F);
	            
	            wand.render((Entity)data[1], 0, 0, 0, 0, 0, 0.0625F);
	           
	            GL11.glPopMatrix();
	            break;
        	case EQUIPPED_FIRST_PERSON:
	            GL11.glPushMatrix();
	           
	            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	           
	            GL11.glRotatef(25, 0F, 1F, 0F);
	            GL11.glRotatef(180, 1F, 0F, 0F);
	            GL11.glRotatef(0, 1F, 0F, 1F);
	            GL11.glTranslatef(-0.1F, -2F, -0.6F);
	            GL11.glScalef(1.2F, 1.2F, 1.2F);
	            
	            wand.render((Entity)data[1], 0, 0, 0, 0, 0, 0.0625F);
	           
	            GL11.glPopMatrix();
	            break;
	            
        	case ENTITY:
        		GL11.glPushMatrix();
  	           
 	            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
 	           
 	            GL11.glRotatef(0, 0F, 1F, 0F);
 	            GL11.glRotatef(150, 1F, 0F, 0F);
 	            GL11.glRotatef(00, 0F, 0F, 1F);
 	            GL11.glTranslatef(0F, -0.6F, 0F);
 	            GL11.glScalef(0.7F, 0.7F, 0.7F);
 	            
 	            wand.render((Entity)data[1], 0, 0, 0, 0, 0, 0.0625F);
 	           
 	            GL11.glPopMatrix();
 	            break;
            default:
            	break;
        }
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
    	switch(type){
           
    		case EQUIPPED: return true;
            case EQUIPPED_FIRST_PERSON: return true;
            case ENTITY: return true;
            default: return false;
           
    	}
    }

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
}
