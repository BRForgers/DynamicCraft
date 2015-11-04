package brazillianforgers.dynamiccraft.renders;

import brazillianforgers.dynamiccraft.lib.Strings;
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
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch(type){
            case EQUIPPED: 
                return true;
            case EQUIPPED_FIRST_PERSON: 
                return true;
            default: 
                return false;
        }
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch(type){
           
            case EQUIPPED:
                GL11.glPushMatrix();
                   
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                   
                GL11.glRotatef(110, 0F, 1F, 0F);
                GL11.glRotatef(130, 1F, 0F, 0F);
                GL11.glRotatef(30, 1F, 0F, 1F);
                GL11.glTranslatef(0.2F, -1.3F, -0.6F);
                GL11.glScalef(1.5F, 1.5F, 1.5F);
                    
                this.wand.render((Entity)data[1], 0, 0, 0, 0, 0, 0.0625F);
                   
                GL11.glPopMatrix();
           
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();
                   
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                   
                GL11.glRotatef(110, 0F, 1F, 0F);
                GL11.glRotatef(130, 1F, 0F, 0F);
                GL11.glRotatef(30, 1F, 0F, 1F);
                GL11.glTranslatef(0.2F, -1.3F, -0.6F);
                GL11.glScalef(1.5F, 1.5F, 1.5F);
                
                this.wand.render((Entity)data[1], 0, 0, 0, 0, 0, 0.0625F);
                   
                GL11.glPopMatrix();
            default:
                break;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }
}
