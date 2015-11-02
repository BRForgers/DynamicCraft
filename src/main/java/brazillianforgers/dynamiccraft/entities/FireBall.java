package brazillianforgers.dynamiccraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class FireBall extends EntityThrowable{

    public FireBall(World world) {
        super(world);
    }
    public FireBall(World world, EntityLivingBase ent) {
        super(world, ent);
    }
    public FireBall(World world, double x, double y, double z) {
        super(world, x, y, z);
    }
    
    /**
    * Called when this EntityThrowable hits a block or entity.
     * @param movObjPos
    */
    @Override
    protected void onImpact(MovingObjectPosition movObjPos) {
        float power = 3;
        
        if (!this.worldObj.isRemote) {
            this.worldObj.newExplosion((Entity)null, this.posX, this.posY, this.posZ, power, true, false);
            this.setDead();
        }
    }
    
}