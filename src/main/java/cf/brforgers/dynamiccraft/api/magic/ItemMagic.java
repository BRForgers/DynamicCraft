package cf.brforgers.dynamiccraft.api.magic;

import cf.brforgers.core.lib.ItemHelper;
import cf.brforgers.dynamiccraft.items.BaseItem;
import net.minecraft.item.ItemStack;

public class ItemMagic extends BaseItem implements IMagicalItem {

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
        if (!ItemHelper.detectNBT(stk)) {
            return 0;
        }
        return ItemHelper.getInt(stk, "Magic", 0);
    }

    @Override
    public int extractMagic(ItemStack stk, int extract) {
        if (!ItemHelper.detectNBT(stk) || !ItemHelper.verifyExistance(stk, "Magic")) {
            return 0;
        }

        int magic = ItemHelper.getInt(stk, "Magic", 0);
        int magicExtracted = Math.min(magic, Math.min(this.extract, extract));

        magic -= magicExtracted;
        ItemHelper.setInt(stk, "Magic", magic);

        return magicExtracted;
    }

    @Override
    public int receiveMagic(ItemStack stk, int receive) {
        if (!ItemHelper.detectNBT(stk)) {
            ItemHelper.initNBT(stk);
        }

        int magic = ItemHelper.getInt(stk, "Magic", 0);
        int magicReceived = Math.min(capacity - magic, Math.min(this.receive, receive));

        magic += magicReceived;
        ItemHelper.setInt(stk, "Magic", magic);

        return magicReceived;
    }

    @Override
    public int getMaxMagic(ItemStack stk) {
        return capacity;
    }

    @Override
    public void setMagic(ItemStack stk, int amount) {
        if (!ItemHelper.detectNBT(stk)) {
            ItemHelper.initNBT(stk);
        }

        ItemHelper.setInt(stk, "Magic", amount);
    }

}
