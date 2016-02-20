package brazillianforgers.dynamiccraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityAquaBall extends EntityThrowable {

	private ItemStack stack;
	
	public EntityAquaBall(World world) {
        super(world);
    }
    public EntityAquaBall(World world, EntityLivingBase ent, ItemStack stack) {
        super(world, ent);
        
        this.stack = stack;
    }
    public EntityAquaBall(World world, double x, double y, double z) {
        super(world, x, y, z);
    }
    
    /**
    * Called when this EntityThrowable hits a block or entity.
     * @param movObjPos
    */
    @Override
    protected void onImpact(MovingObjectPosition mop) {
        
        if (!this.worldObj.isRemote) {
        	if(mop.entityHit != null) {
        		Entity ent = mop.entityHit;
        		int x = (int) ent.posX;
        		int y = (int) ent.posY;
        		int z = (int) ent.posZ;
        		
        		worldObj.setBlock(x, y, z, Blocks.ice);
        	}
        }
    }
	
}
