package cf.brforgers.dynamiccraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * InfusionAltar - Whyssky_BR
 * Created using Tabula 4.0.0
 */
public class ModelInfusionAltar extends ModelBase {
    public ModelRenderer altar;
	public ModelRenderer center;
    public ModelRenderer pillar1;
    public ModelRenderer pillar2;
    public ModelRenderer pillar3;
    public ModelRenderer pillar4;


    public ModelInfusionAltar() {
		//Configurate Texture
        this.textureWidth = 64;
        this.textureHeight = 64;
		
		//Add Altar
		this.altar = new ModelRenderer(this, 0, 0);
        this.altar.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.altar.addBox(-8.0F, 12.0F, -8.0F, 16, 12, 16);
		
		//Add Altar thing
		this.center = new ModelRenderer(this, 0, 0);
        this.center.setRotationPoint(-1.8F, 11.0F, -1.8F);
        this.center.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
		
		//Add Pillars
		this.pillar1 = new ModelRenderer(this, 0, 28);
        this.pillar1.setRotationPoint(-3.6F, 3.1F, -2.8F);
        this.pillar1.addBox(0.0F, 0.0F, 0.0F, 1, 11, 3);
        this.setRotateAngle(pillar1, -0.5918411493512771F, 0.7740535232594852F, 0.0F);
        this.pillar2 = new ModelRenderer(this, 0, 28);
        this.pillar2.setRotationPoint(1.2F, 4.6F, 1.7F);
        this.pillar2.addBox(0.0F, 0.0F, 0.0F, 1, 11, 3);
        this.setRotateAngle(pillar2, 0.5918411493512771F, 0.7740535232594852F, 0.0F);
        this.pillar3 = new ModelRenderer(this, 0, 28);
        this.pillar3.setRotationPoint(2.9F, 3.1F, -3.5F);
        this.pillar3.addBox(0.0F, 0.0F, 0.0F, 1, 11, 3);
        this.setRotateAngle(pillar3, -0.5918411493512771F, -0.7740535232594852F, 0.0F);
        this.pillar4 = new ModelRenderer(this, 0, 28);
        this.pillar4.setRotationPoint(-1.8F, 4.8F, 1.0F);
        this.pillar4.addBox(0.0F, 0.0F, 0.0F, 1, 11, 3);
        this.setRotateAngle(pillar4, 0.5918411493512771F, -0.7740535232594852F, 0.0F);

    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.altar.render(f5);
		this.center.render(f5);
		
		this.pillar1.render(f5);
        this.pillar2.render(f5);
        this.pillar3.render(f5);
        this.pillar4.render(f5);
        
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
