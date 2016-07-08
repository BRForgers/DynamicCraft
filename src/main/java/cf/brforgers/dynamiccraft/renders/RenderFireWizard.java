package cf.brforgers.dynamiccraft.renders;

import cf.brforgers.dynamiccraft.Strings;
import cf.brforgers.dynamiccraft.entities.EntityFireWizard;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderFireWizard extends RenderBiped {
	
    private static final ResourceLocation mobTextures = new ResourceLocation(Strings.MODID + ":textures/entity/FireWizard.png");
    
    public RenderFireWizard(ModelBiped par1ModelBase, float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(EntityFireWizard par1EntityThief) {
        return mobTextures;
    }
 
    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEntityTexture((EntityFireWizard)par1Entity);
    }
    
    @Override
    public void doRender(Entity p_76986_1_, double x, double y, double z, float p_76986_8_, float p_76986_9_) {
        
        GL11.glEnable(GL11.GL_NORMALIZE); // optional
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        
        this.doRender((EntityLiving)p_76986_1_, x, y, z, p_76986_8_, p_76986_9_);
        
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glColor4f(1, 1, 1, 1); // resets the color to white, just in case  
    }
}
