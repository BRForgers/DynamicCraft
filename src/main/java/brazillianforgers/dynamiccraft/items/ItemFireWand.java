package brazillianforgers.dynamiccraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.Strings;
import brazillianforgers.dynamiccraft.api.magic.ItemMagic;
import brazillianforgers.dynamiccraft.entities.EntityFireBall;
import brazillianforgers.lib.ItemNBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemFireWand extends ItemBaseWand{
    
    public ItemFireWand() {
    	super(100, 50);
    	
        setCreativeTab(DynamicCraft.dynamicTab);
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
            
            if(!world.isRemote) {
                world.spawnEntityInWorld(new EntityFireBall(player.worldObj, player));
            }
            
            ItemNBTHelper.setInt(item, "timer", 0);
    	}
    	return item;
    }
    
}
