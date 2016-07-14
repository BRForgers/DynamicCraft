package cf.brforgers.dynamiccraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFireBall extends EntityThrowable {

    public EntityFireBall(World world) {
        super(world);
    }

    public EntityFireBall(World world, EntityLivingBase ent) {
        super(world, ent);
    }

    public EntityFireBall(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     *
     * @param movObjPos
     */
    @Override
    protected void onImpact(MovingObjectPosition movObjPos) {
        float power = 2;

        if (!this.worldObj.isRemote) {
            this.worldObj.newExplosion(null, this.posX, this.posY, this.posZ, power, true, false);
            this.setDead();
        }
    }

}