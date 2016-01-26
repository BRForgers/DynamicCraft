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

public class ItemFireWand extends ItemMagic{
    
    public ItemFireWand() {
    	super(100, 50);
    	
        setCreativeTab(DynamicCraft.dynamicTab);
		setHasSubtypes(true);
		setMaxDamage(100);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Strings.MODID + ":" + getUnlocalizedName().substring(5));
    }
    
    public int getTimer(ItemStack item) {
        return ItemNBTHelper.getInt(item, "timer", 0);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
	if(ItemNBTHelper.getBoolean(item, "canAttack", true)) {
            ItemNBTHelper.setBoolean(item, "canAttack", false);
            item.damageItem(1, player);
            
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
    
    @Override
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int p_77648_4_,
    		int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
    	
    	receiveMagic(item, 20);
    	
    	return true;
    }
    
    @Override
    public void onUpdate(ItemStack item, World world, Entity ent, int i, boolean b) {
    	setDamage(item, getMaxMagic(item) - getMagic(item));
    	
        if(ItemNBTHelper.detectNBT(item)) {
            if(!(getTimer(item) >= 40)) {
                ItemNBTHelper.setInt(item, "timer", getTimer(item) + 1);
            }
            else if(getTimer(item) >= 40 && getMagic(item) >= 10)
                ItemNBTHelper.setBoolean(item, "canAttack", true);
        }else {
            ItemNBTHelper.initNBT(item);
            ItemNBTHelper.setInt(item, "timer", 0);
            ItemNBTHelper.setBoolean(item, "canAttack", false);
        }
    }
    
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		String cshift = EnumChatFormatting.DARK_PURPLE.toString() + getMagic(itemStack) + " Magic";
		list.add(cshift);
	}
    
}
