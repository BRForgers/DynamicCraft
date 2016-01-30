package brazillianforgers.dynamiccraft.entities;

import brazillianforgers.dynamiccraft.network.MessageSetFire;
import brazillianforgers.dynamiccraft.network.NetworkHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFireMode extends EntityFireball{

	public EntityFireMode(World p_i1761_1_, EntityLivingBase p_i1761_2_, double p_i1761_3_, double p_i1761_5_,
			double p_i1761_7_) {
		super(p_i1761_1_, p_i1761_2_, p_i1761_3_, p_i1761_5_, p_i1761_7_);
		
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		double f1 = rand.nextDouble() - 0.5;
    	double f2 = rand.nextDouble() - 0.5;
    	double f3 = rand.nextDouble() - 0.5;
    	
    	double vx = accelerationX;
    	double vy = accelerationY;
    	double vz = accelerationZ;
    	
    	double x = posX;
    	double y = posY;
    	double z = posZ;
				
    	worldObj.spawnParticle("flame", x + 0.5, y + 0.5, z + 0.5, vx, vy, vz);
    	worldObj.spawnParticle("flame", x - 0.5, y - 0.5, z - 0.5, vx, vy, vz);
    	worldObj.spawnParticle("flame", x, y + 1, z, vx, vy, vz);
    	worldObj.spawnParticle("flame", x + f1, y - f1, z + f1, vx, vy, vz);
    	worldObj.spawnParticle("flame", x + f2, y + f2, z - f2, vx, vy, vz);
    	worldObj.spawnParticle("flame", x - f3, y - f1, z - f2, vx, vy, vz);
    	
    	worldObj.spawnParticle("flame", x + 0.8, y + 0.7, z + 0.2, vx, vy, vz);
    	worldObj.spawnParticle("flame", x - 0.8, y - 0.7, z - 0.4, vx, vy, vz);
    	worldObj.spawnParticle("flame", x + f1 - 0.5, y - f1, z + f1 - 0.5, vx, vy, vz);
    	worldObj.spawnParticle("flame", x + f2 + 0.2, y + f2, z + f2, vx, vy, vz);
    	worldObj.spawnParticle("flame", x - 0.4 + f1, y + f3, z + f3, vx, vy, vz);
    	worldObj.spawnParticle("flame", x - 0.5 - f3, y - f3 - 0.2, z - 0.2, vx, vy, vz);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if(mop.entityHit != null) {
			NetworkHandler.sendToServer(new MessageSetFire(mop.entityHit.hashCode()));
		}
		setDead();
	}

}
