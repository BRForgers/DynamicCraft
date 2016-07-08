package cf.brforgers.dynamiccraft.renders;

import cf.brforgers.dynamiccraft.Strings;
import cf.brforgers.dynamiccraft.entities.EntityFireBall;
import cf.brforgers.dynamiccraft.models.ModelFireBall;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderFireBall extends Render {
    
    private static final ResourceLocation texture = new ResourceLocation(Strings.MODID + ":textures/model/ModelFireBall.png");

    private final ModelFireBall model;
    
    public RenderFireBall() {
        model = new ModelFireBall();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        // this method should return your texture, which may be different based
        // on certain characteristics of your custom entity; if that is the case,
        // you may want to make a second method that takes your class:
        return getCustomTexture((EntityFireBall) entity);
    }
    
    private ResourceLocation getCustomTexture(EntityFireBall entity) {
        // now you have access to your custom entity fields and methods, if any,
        // and can base the texture to return upon those
        return texture;
    }
    
    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTick) {
        // again, if you need some information from your custom entity class, you can cast to your
        // custom class, either passing off to another method, or just doing it here
        // in this example, it is not necessary

        // if you are going to do any openGL matrix transformations, be sure to always Push and Pop
        GL11.glPushMatrix();

        // bind your texture:
        bindTexture(texture);
        // do whatever transformations you need, then render

        // typically you will at least want to translate for x/y/z position:
        GL11.glTranslated(x, y, z);
        
        // if you are using a model, you can do so like this:
        model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

        // note all the values are 0 except the final argument, which is scale
        // vanilla Minecraft almost excusively uses 0.0625F, but you can change it to whatever works

        GL11.glPopMatrix();
    }
}
