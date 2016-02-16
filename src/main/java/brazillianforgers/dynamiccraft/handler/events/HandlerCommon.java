package brazillianforgers.dynamiccraft.handler.events;

import brazillianforgers.dynamiccraft.api.magic.IMagicalItem;
import brazillianforgers.dynamiccraft.container.ContainerMagicCollector;
import brazillianforgers.dynamiccraft.handler.ItemHandler;
import brazillianforgers.dynamiccraft.items.ItemMagicCollector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

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
		
		if(((IMagicalItem) item).getMagic(stack) >= ((IMagicalItem) item).getMaxMagic(stack))
			return;
		
		item.extractMagic(stack, 1);
		((IMagicalItem) magicItem.getItem()).receiveMagic(magicItem, 1);
	}
	
}
