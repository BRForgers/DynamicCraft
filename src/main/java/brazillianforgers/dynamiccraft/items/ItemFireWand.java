package brazillianforgers.dynamiccraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.Strings;
import brazillianforgers.dynamiccraft.api.magic.ItemMagic;
import brazillianforgers.dynamiccraft.entities.EntityFireBall;
import brazillianforgers.dynamiccraft.entities.EntityFireMode;
import brazillianforgers.lib.ItemNBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemFireWand extends ItemBaseWand{
    
    public ItemFireWand() {
    	super(100, 50);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
    	if(ItemNBTHelper.getBoolean(item, "canAttack", true)) {
    		ItemNBTHelper.setBoolean(item, "canAttack", false);
            
            extractMagic(item, 10);
            
            if(getMagic(item) <= 0) {
            	int sort = itemRand.nextInt(10) + 1;
            	if(sort >= 1 && sort <= 3 ) {
            		item.damageItem(101, player);
            	}
            }
            
            if(ItemNBTHelper.getString(item, "mode", "PROJECTILE").equals("PROJECTILE")) {
	            if(!world.isRemote) {
	                world.spawnEntityInWorld(new EntityFireBall(player.worldObj, player));
	            }
    		}else if(ItemNBTHelper.getString(item, "mode", "PROJECTILE").equals("FIRE")) {
    			if(world.isRemote) {
	    			Vec3 look = player.getLookVec();
	    			
	    			double vx = look.xCoord;
	    			double vy = look.yCoord;
	    			double vz = look.zCoord;
	    			
	    			player.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)player.posX, (int)player.posY, (int)player.posZ, 0);
	    			
					EntityFireMode ent = new EntityFireMode(player.worldObj, player, vx, vy, vz);
					ent.setPosition(player.posX + vx, player.posY + vy, player.posZ + vz);
					ent.accelerationX = look.xCoord * 0.1;
					ent.accelerationY = look.yCoord * 0.1;
					ent.accelerationZ = look.zCoord * 0.1;
					
			        player.worldObj.spawnEntityInWorld(ent);
			        
			        player.worldObj.playSoundAtEntity(ent, "random.bow", 1, 1);
    			}
    		}
    	
            
            ItemNBTHelper.setInt(item, "timer", 0);
    	}
    	return item;
    }
    
    public void onUpdate(ItemStack item, World world, Entity ent, int i, boolean b) {
    	super.onUpdate(item, world, ent, i, b); 
    	
    	if(ItemNBTHelper.detectNBT(item)) {
			if(!ItemNBTHelper.verifyExistance(item, "mode")) {
				ItemNBTHelper.setString(item, "mode", "PROJECTILE");
			}
		}else {
			ItemNBTHelper.initNBT(item);
			ItemNBTHelper.setString(item, "mode", "PROJECTILE");
		}
	 }
    
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		 super.addInformation(itemStack, player, list, par4);
		 
		 String nbtmode = ItemNBTHelper.getString(itemStack, "mode", "PROJECTILE");
		 
		 String mod = EnumChatFormatting.GRAY + "Mode: " + EnumChatFormatting.AQUA + EnumChatFormatting.BOLD + nbtmode;
		 list.add(mod);
    }
    
}
