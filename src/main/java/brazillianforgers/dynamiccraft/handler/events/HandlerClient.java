package brazillianforgers.dynamiccraft.handler.events;

import brazillianforgers.dynamiccraft.handler.UpdateHandler;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class HandlerClient {
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent e) {
		e.player.addChatMessage(new ChatComponentText(UpdateHandler.updateStatus));
	}
	
}
