package cf.brforgers.dynamiccraft.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

public class EntityAquaBall extends EntityThrowable {

	private ItemStack stack;
	private EntityPlayer player;
	
	public EntityAquaBall(World world) {
        super(world);
    }
    public EntityAquaBall(World world, EntityLivingBase ent, ItemStack stack, EntityPlayer p) {
        super(world, ent);
        
        this.player = p;
        this.stack = stack;
    }
    public EntityAquaBall(World world, double x, double y, double z) {
        super(world, x, y, z);
    }
    
    /**
    * Called when this EntityThrowable hits a block or entity.
     * @param mop
    */
    @Override
    protected void onImpact(MovingObjectPosition mop) {
        
        if (!this.worldObj.isRemote) {
        	if(mop.entityHit != null) {
        		final Entity ent = mop.entityHit;
        		final int x = (int) ent.posX;
        		final int y = (int) ent.posY;
        		final int z = (int) ent.posZ;
        		
        		final HashMap<Integer[], Integer> blocks = new HashMap<Integer[], Integer>();
        		
        		blocks.put(new Integer[] {x, y - 1, z}, Block.getIdFromBlock(worldObj.getBlock(x, y - 1, z)));
        		blocks.put(new Integer[] {x, y, z}, Block.getIdFromBlock(worldObj.getBlock(x, y, z)));
        		blocks.put(new Integer[] {x, y + 1, z}, Block.getIdFromBlock(worldObj.getBlock(x, y + 1, z)));
        		blocks.put(new Integer[] {x, y + 2, z}, Block.getIdFromBlock(worldObj.getBlock(x, y + 2, z)));
        		blocks.put(new Integer[] {x, y, z + 1}, Block.getIdFromBlock(worldObj.getBlock(x, y, z + 1)));
        		blocks.put(new Integer[] {x, y + 1, z + 1}, Block.getIdFromBlock(worldObj.getBlock(x, y + 1, z + 1)));
        		blocks.put(new Integer[] {x + 1, y, z}, Block.getIdFromBlock(worldObj.getBlock(x + 1, y, z)));
        		blocks.put(new Integer[] {x + 1, y + 1, z}, Block.getIdFromBlock(worldObj.getBlock(x + 1, y + 1, z)));
        		blocks.put(new Integer[] {x - 1, y, z}, Block.getIdFromBlock(worldObj.getBlock(x - 1, y, z)));
        		blocks.put(new Integer[] {x - 1, y + 1, z}, Block.getIdFromBlock(worldObj.getBlock(x - 1, y + 1, z)));
        		
        		worldObj.setBlock(x, y - 1, z, Blocks.ice);
        		worldObj.setBlock(x, y, z, Blocks.ice);
        		worldObj.setBlock(x, y + 1, z, Blocks.ice);
        		worldObj.setBlock(x, y + 2, z, Blocks.ice);
        		worldObj.setBlock(x, y, z + 1, Blocks.ice);
        		worldObj.setBlock(x, y + 1, z + 1, Blocks.ice);
        		worldObj.setBlock(x + 1, y, z, Blocks.ice);
        		worldObj.setBlock(x + 1, y + 1, z, Blocks.ice);
        		worldObj.setBlock(x, y, z - 1, Blocks.ice);
        		worldObj.setBlock(x, y + 1, z - 1, Blocks.ice);
        		worldObj.setBlock(x - 1, y, z, Blocks.ice);
        		worldObj.setBlock(x - 1, y + 1, z, Blocks.ice);
        		
        		Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                	int count = 5;
                    public void run() {
                        if(count > 0) {
                        	ent.setPosition(x, y, z);
                        	ent.attackEntityFrom(DamageSource.causePlayerDamage(player), 1);
                            count--;
                        }else {
                        	Iterator<Entry<Integer[], Integer>> iterator = blocks.entrySet().iterator();
                        	Entry<Integer[], Integer> entry = null;
                        	
                        	do {
                        		if(!iterator.hasNext()) {
                        			break;
                        		}
                        		entry = iterator.next();
                        		
                        		worldObj.setBlock(entry.getKey()[0], entry.getKey()[1], entry.getKey()[2], Block.getBlockById(entry.getValue()));
                        	}while(entry != null);
                        	this.cancel();
                        }
                    }
                }, 0, 1*1000);  //subsequent rate
        	}
        }
    }
	
}
