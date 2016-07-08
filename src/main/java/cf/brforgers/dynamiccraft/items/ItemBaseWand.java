package cf.brforgers.dynamiccraft.items;

import cf.brforgers.core.lib.ItemHelper;
import cf.brforgers.dynamiccraft.DynamicCraft;
import cf.brforgers.dynamiccraft.api.magic.ItemMagic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemBaseWand extends ItemMagic {

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
	
	public boolean canAttack(ItemStack item) {
		return ItemHelper.getBoolean(item, "canAttack", true);
	}
	
	public int getTimer(ItemStack item) {
		return ItemHelper.getInt(item, "timer", 0);
	}
	
	public void resetTimer(ItemStack item) {
		ItemHelper.setInt(item, "timer", 0);
	}
	
	public void setCanAttack(ItemStack item, boolean b) {
		ItemHelper.setBoolean(item, "canAttack", false);
	}
	
	@Override
	public void onUpdate(ItemStack item, World world, Entity ent, int i, boolean b) {
		if (ItemHelper.detectNBT(item)) {
			if(!(getTimer(item) >= 40)) {
				ItemHelper.setInt(item, "timer", getTimer(item) + 1);
			}
			else if(getTimer(item) >= 40 && getMagic(item) >= 10)
				ItemHelper.setBoolean(item, "canAttack", true);
		}else {
			ItemHelper.initNBT(item);
			ItemHelper.setInt(item, "timer", 0);
			ItemHelper.setBoolean(item, "canAttack", false);
		}
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		 String magic = EnumChatFormatting.DARK_PURPLE.toString() + getMagic(itemStack) + " Magic";
		 list.add(magic);
	}
	
}
