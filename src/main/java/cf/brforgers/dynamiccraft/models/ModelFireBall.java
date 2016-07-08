package cf.brforgers.dynamiccraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFireBall extends ModelBase{
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    public ModelRenderer shape6;
    public ModelRenderer shape7;

    public ModelFireBall() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, -6.5F, 0.0F);
        this.shape1.addBox(-1.5F, 10.0F, -1.5F, 3, 3, 3);
        
        this.shape2 = new ModelRenderer(this, 12, 0);
        this.shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape2.addBox(-0.5F, 9.0F, -0.5F, 1, 1, 1);
        this.shape1.addChild(this.shape2);
        
        this.shape7 = new ModelRenderer(this, 32, 0);
        this.shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape7.addBox(-2.5F, 11.0F, -0.5F, 1, 1, 1);
        this.shape1.addChild(this.shape7);
        
        this.shape3 = new ModelRenderer(this, 16, 0);
        this.shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape3.addBox(-0.5F, 13.0F, -0.5F, 1, 1, 1);
        this.shape1.addChild(this.shape3);
        
        this.shape4 = new ModelRenderer(this, 20, 0);
        this.shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape4.addBox(-0.5F, 11.0F, -2.5F, 1, 1, 1);
        this.shape1.addChild(this.shape4);
        
        this.shape6 = new ModelRenderer(this, 28, 0);
        this.shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape6.addBox(1.5F, 11.0F, -0.5F, 1, 1, 1);
        this.shape1.addChild(this.shape6);
        
        this.shape5 = new ModelRenderer(this, 24, 0);
        this.shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape5.addBox(-0.5F, 11.0F, 1.5F, 1, 1, 1);
        this.shape1.addChild(this.shape5);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
