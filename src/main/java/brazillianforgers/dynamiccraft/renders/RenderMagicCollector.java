package brazillianforgers.dynamiccraft.renders;

import org.lwjgl.opengl.GL11;

import brazillianforgers.dynamiccraft.Strings;
import brazillianforgers.dynamiccraft.models.ModelMagicCollector;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class RenderMagicCollector implements IItemRenderer{
	public static ResourceLocation texture = new ResourceLocation(Strings.MODID + ":textures/model/ModelMagicCollector.png");
	   
	public static ModelMagicCollector model;
	
    public RenderMagicCollector() {
        model = new ModelMagicCollector();
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch(type){   
        
    		case EQUIPPED_FIRST_PERSON:
	    		GL11.glPushMatrix();
	       
	    		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	       
	    		GL11.glRotatef(130, 0F, 1F, 0F);
		        GL11.glRotatef(0, 1F, 0F, 0F);
		        GL11.glRotatef(0, 0F, 0F, 1F);
		        GL11.glTranslatef(-0.4F, 1F, -0.7F);
		        
		        
		        this.model.render((Entity)data[1], 0, 0, 0, 0, 0, 0.0625F);
		       
		        GL11.glPopMatrix();
		        break;
        
        	case EQUIPPED: 
	            
	            GL11.glPushMatrix();
	           
	            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	           
	            GL11.glRotatef(0, 0F, 0F, 1F);
                GL11.glRotatef(0, 1F, 0F, 0F);
                GL11.glRotatef(220, 0F, 1F, 0F);
                GL11.glTranslatef(-0.1F, 0.3F, -1F);
	            
	            this.model.render((Entity)data[1], 0, 0, 0, 0, 0, 0.0625F);
	           
	            GL11.glPopMatrix();
	            break;
	            
        	case ENTITY:
            	GL11.glPushMatrix();
                
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                
                GL11.glRotatef(0, 0F, 0F, 1F);
                GL11.glRotatef(0, 1F, 0F, 0F);
                GL11.glRotatef(90, 0F, 1F, 0F);
                GL11.glTranslatef(0F, -0.3F, 0F);
                GL11.glScalef(0.9F, 0.9F, 0.9F);
                
                model.render((Entity)data[1], 0, 0, 0, 0, 0, 0.0625F);
                   
                GL11.glPopMatrix();
                break;
            case INVENTORY:
            	 GL11.glPushMatrix();
            	 
            	 GL11.glRotatef(0, 0F, 0F, 1F);
            	 GL11.glRotatef(0, 1F, 0F, 0F);
            	 GL11.glRotatef(45, 0F, 1F, 0F);
            	 GL11.glTranslatef(0F, -0.3F, 0F);
            	 GL11.glScalef(1.5F, 1.5F, 1.5F);
            	 
            	 Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            	 model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            	 0.0625F);
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
            case INVENTORY: return true;
            case ENTITY: return true;
            default: return false;
           
    	}
    }

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
}
