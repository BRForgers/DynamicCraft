package cf.brforgers.dynamiccraft.items;

import cf.brforgers.dynamiccraft.entities.EntityAquaBall;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAquaWand extends ItemBaseWand {

    public ItemAquaWand() {
        super(100, 50);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        if (canAttack(item)) {
            setCanAttack(item, false);

            extractMagic(item, 10);

            if (getMagic(item) <= 0) {
                int sort = itemRand.nextInt(10) + 1;
                if (sort >= 1 && sort <= 3) {
                    item.damageItem(101, player);
                }
            }

            if (!world.isRemote)
                world.spawnEntityInWorld(new EntityAquaBall(player.worldObj, player, item, player));

            resetTimer(item);
        }
        return item;
    }

}
