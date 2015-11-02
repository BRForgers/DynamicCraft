package brazillianforgers.dynamiccraft.items;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.entities.FireBall;
import brazillianforgers.lib.ItemNBTHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FireWand extends BaseItem{
    
    public FireWand() {
        setCreativeTab(DynamicCraft.dynamicTab);
        setMaxStackSize(1);
	setHasSubtypes(true);
	setMaxDamage(10);
    }
    
    public int getTimer(ItemStack item) {
        return ItemNBTHelper.getInt(item, "timer", 0);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
	if(ItemNBTHelper.getBoolean(item, "canAttack", true)) {
            ItemNBTHelper.setBoolean(item, "canAttack", false);
            item.damageItem(1, player);
            
            if(!world.isRemote) {
                world.spawnEntityInWorld(new FireBall(player.worldObj, player));
            }
            
            ItemNBTHelper.setInt(item, "timer", 0);
        }
        return item;
    }
    
    @Override
    public void onUpdate(ItemStack item, World world, Entity ent, int i, boolean b) {
        
        if(ItemNBTHelper.detectNBT(item)) {
            if(!(getTimer(item) >= 40)) {
                ItemNBTHelper.setInt(item, "timer", getTimer(item) + 1);

                if(getTimer(item) >= 40) {
                    ItemNBTHelper.setBoolean(item, "canAttack", true);
                }
            }
        }else {
            ItemNBTHelper.initNBT(item);
            ItemNBTHelper.setInt(item, "timer", 0);
            ItemNBTHelper.setBoolean(item, "canAttack", true);
        }
    }
    
}
