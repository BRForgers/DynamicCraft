package cf.brforgers.dynamiccraft.handler.events;

import cf.brforgers.dynamiccraft.api.magic.IMagicalItem;
import cf.brforgers.dynamiccraft.container.ContainerMagicCollector;
import cf.brforgers.dynamiccraft.items.ItemMagicCollector;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.item.ItemStack;

public class HandlerCommon {
	
	@SubscribeEvent
	public void magicCollectorUpdate(TickEvent.PlayerTickEvent e) {
		if(e.player.worldObj.isRemote)
			return;
		
		if(e.player.openContainer == null)
			return;
		
		if(!(e.player.openContainer instanceof ContainerMagicCollector))
			return;
		
		ContainerMagicCollector cont = (ContainerMagicCollector) e.player.openContainer;
		ItemStack stack = cont.getCollectorStack();
		ItemMagicCollector item = cont.getCollectorItem();
		
		ItemStack magicItem = (ItemStack) cont.getInventory().get(0);
		
		if(item.getMagic(stack) < 1) 
			return;
		
		if(magicItem == null)
			return;
		
		if(((IMagicalItem) magicItem.getItem()).getMagic(magicItem) >= ((IMagicalItem) magicItem.getItem()).getMaxMagic(magicItem))
			return;

		if (item.getMagic(stack) >= item.getMaxMagic(stack))
			return;
		
		item.extractMagic(stack, 1);
		((IMagicalItem) magicItem.getItem()).receiveMagic(magicItem, 1);
	}
	
}
