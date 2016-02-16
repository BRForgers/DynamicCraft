package brazillianforgers.dynamiccraft.items;

import java.util.List;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.Strings;
import brazillianforgers.dynamiccraft.api.magic.ItemMagic;
import brazillianforgers.lib.ItemNBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemBaseWand  extends ItemMagic{

	public ItemBaseWand(int capacity) {
		this(capacity, capacity, capacity);
	}

	public ItemBaseWand(int capacity, int maxTransfer) {
		this(capacity, maxTransfer, maxTransfer);
	}

	public ItemBaseWand(int capacity, int receive, int extract) {
		this.setMaxStackSize(1);
		setCreativeTab(DynamicCraft.dynamicTab);
		setMaxDamage(100);
		setHasSubtypes(true);
		
		this.capacity = capacity;
		this.receive = receive;
		this.extract = extract;
	}
	
	public int getTimer(ItemStack item) {
        return ItemNBTHelper.getInt(item, "timer", 0);
    }
	
	@Override
	public void onUpdate(ItemStack item, World world, Entity ent, int i, boolean b) { 
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
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		 String magic = EnumChatFormatting.DARK_PURPLE.toString() + getMagic(itemStack) + " Magic";
		 list.add(magic);
	}
	
}
