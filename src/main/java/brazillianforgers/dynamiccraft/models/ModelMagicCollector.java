package brazillianforgers.dynamiccraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * MagicCollector - Whyssky_BR
 * Created using Tabula 4.0.0
 */
public class ModelMagicCollector extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape7;

    public ModelMagicCollector() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape7 = new ModelRenderer(this, 0, 18);
        this.shape7.setRotationPoint(-4.4F, 9.9F, 2.0F);
        this.shape7.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
        this.setRotateAngle(shape7, 0.27314402793711257F, 0.0F, -2.321986036853256F);
        this.shape2 = new ModelRenderer(this, 25, 0);
        this.shape2.setRotationPoint(-3.0F, 2.0F, 2.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 6, 6, 1);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-5.0F, 0.0F, 0.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 10, 10, 2);
        this.shape4 = new ModelRenderer(this, 0, 18);
        this.shape4.setRotationPoint(5.0F, 9.1F, 2.0F);
        this.shape4.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
        this.setRotateAngle(shape4, 0.27314402793711257F, 0.0F, 2.321287905152458F);
        this.shape3 = new ModelRenderer(this, 0, 13);
        this.shape3.setRotationPoint(-1.0F, 4.0F, 3.0F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape7.render(f5);
        this.shape2.render(f5);
        this.shape1.render(f5);
        this.shape4.render(f5);
        this.shape3.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
