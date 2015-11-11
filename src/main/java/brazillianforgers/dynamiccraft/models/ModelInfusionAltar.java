package brazillianforgers.dynamiccraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * InfusionAltar - Whyssky_BR
 * Created using Tabula 4.0.0
 */
public class ModelInfusionAltar extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape2_1;
    public ModelRenderer shape2_2;
    public ModelRenderer shape2_3;
    public ModelRenderer shape7;

    public ModelInfusionAltar() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape2_2 = new ModelRenderer(this, 22, 28);
        this.shape2_2.setRotationPoint(2.9F, 3.1F, -3.5F);
        this.shape2_2.addBox(0.0F, 0.0F, 0.0F, 1, 11, 3);
        this.setRotateAngle(shape2_2, -0.5918411493512771F, -0.7740535232594852F, 0.0F);
        this.shape7 = new ModelRenderer(this, 0, 0);
        this.shape7.setRotationPoint(-1.8F, 11.0F, -1.8F);
        this.shape7.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
        this.shape2_3 = new ModelRenderer(this, 7, 28);
        this.shape2_3.setRotationPoint(-1.8F, 4.8F, 1.0F);
        this.shape2_3.addBox(0.0F, 0.0F, 0.0F, 1, 11, 3);
        this.setRotateAngle(shape2_3, 0.5918411493512771F, -0.7740535232594852F, 0.0F);
        this.shape2 = new ModelRenderer(this, 14, 28);
        this.shape2.setRotationPoint(-3.6F, 3.1F, -2.8F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 1, 11, 3);
        this.setRotateAngle(shape2, -0.5918411493512771F, 0.7740535232594852F, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1.addBox(-8.0F, 12.0F, -8.0F, 16, 12, 16);
        this.shape2_1 = new ModelRenderer(this, 0, 28);
        this.shape2_1.setRotationPoint(1.2F, 4.6F, 1.7F);
        this.shape2_1.addBox(0.0F, 0.0F, 0.0F, 1, 11, 3);
        this.setRotateAngle(shape2_1, 0.5918411493512771F, 0.7740535232594852F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape2_2.render(f5);
        this.shape7.render(f5);
        this.shape2_3.render(f5);
        this.shape2.render(f5);
        this.shape1.render(f5);
        this.shape2_1.render(f5);
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
