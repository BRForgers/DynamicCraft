package brazillianforgers.dynamiccraft.entities;

import brazillianforgers.dynamiccraft.items.ItemHandler;
import brazillianforgers.dynamiccraft.lib.Strings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityWizard extends EntityMob{
	
    public EntityWizard(World world) {
		super(world);
		isImmuneToFire = true;
    }
	
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
		
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.5D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
    }
    
    @Override
    protected String getLivingSound() {
        return Strings.MODID + ":wizardAmbient";
    }
	
    protected boolean isAIEnabled() {
        return false;
    }

    private static final ItemStack defaultHeldItem;
	
    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }
	
    static {
        defaultHeldItem = new ItemStack(ItemHandler.fireWand, 1);
    }
	
    @Override
    public Item getDropItem(){
        return ItemHandler.fireWand;
    }

    @Override
    protected boolean isValidLightLevel() {
	return true;
    }
	 
    @Override
    public boolean getCanSpawnHere() {
	return true; 
    }
	
    @Override
    public void attackEntity(Entity entity, float distancia) {
        this.arrowHitTimer++;
        
        if(this.arrowHitTimer < -40 || this.arrowHitTimer > 20) {
            this.arrowHitTimer = -20;
        }
        
        if (this.arrowHitTimer == 20) {
                
            Vec3 look = this.getLookVec();
	    if(distancia > 2) {
				
                this.worldObj.spawnEntityInWorld(new EntityFireBall(this.worldObj, this));
                
            	this.arrowHitTimer = -40;
	    }else {
	        this.arrowHitTimer = -20;
	        attackEntityAsMob(entity);
	    }
        }
    }
	
}