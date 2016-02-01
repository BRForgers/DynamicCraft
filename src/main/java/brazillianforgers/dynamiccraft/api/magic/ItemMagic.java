package brazillianforgers.dynamiccraft.api.magic;

import brazillianforgers.dynamiccraft.items.BaseItem;
import brazillianforgers.lib.ItemNBTHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMagic extends BaseItem implements IMagicalItem{

	protected int capacity;
	protected int receive;
	protected int extract;
	
	public ItemMagic() {

	}

	public ItemMagic(int capacity) {

		this(capacity, capacity, capacity);
	}

	public ItemMagic(int capacity, int maxTransfer) {

		this(capacity, maxTransfer, maxTransfer);
	}

	public ItemMagic(int capacity, int receive, int extract) {
		this.setMaxStackSize(1);
		
		this.capacity = capacity;
		this.receive = receive;
		this.extract = extract;
	}
	
	public ItemMagic setCapacity(int capacity) {

		this.capacity = capacity;
		return this;
	}

	public void setMaxTransfer(int maxTransfer) {

		setMaxReceive(maxTransfer);
		setMaxExtract(maxTransfer);
	}

	public void setMaxReceive(int maxReceive) {

		this.receive = maxReceive;
	}

	public void setMaxExtract(int maxExtract) {

		this.extract = maxExtract;
	}
	
	@Override
	public int getMagic(ItemStack stk) {
		if (!ItemNBTHelper.detectNBT(stk)) {
			return 0;
		}
		return ItemNBTHelper.getInt(stk, "Magic", 0);
	}

	@Override
	public int extractMagic(ItemStack stk, int extract) {
		if (!ItemNBTHelper.detectNBT(stk) || !ItemNBTHelper.verifyExistance(stk, "Magic")) {
			return 0;
		}
		
		int magic = ItemNBTHelper.getInt(stk, "Magic", 0);
		int magicExtracted = Math.min(magic, Math.min(this.extract, extract));
		
		magic -= magicExtracted;
		ItemNBTHelper.setInt(stk, "Magic", magic);
		
		return magicExtracted;
	}

	@Override
	public int receiveMagic(ItemStack stk, int receive) {
		if(!ItemNBTHelper.detectNBT(stk)) {
			ItemNBTHelper.initNBT(stk);
		}
		
		int magic = ItemNBTHelper.getInt(stk, "Magic", 0);
		int magicReceived = Math.min(capacity - magic, Math.min(this.receive, receive));
		
		magic += magicReceived;
		ItemNBTHelper.setInt(stk, "Magic", magic);
		
		return magicReceived;
	}

	@Override
	public int getMaxMagic(ItemStack stk) {
		return capacity;
	}

	@Override
	public void setMagic(ItemStack stk, int amount) {
		if(!ItemNBTHelper.detectNBT(stk)) {
			ItemNBTHelper.initNBT(stk);
		}
		
		ItemNBTHelper.setInt(stk, "Magic", amount);
	}

}
