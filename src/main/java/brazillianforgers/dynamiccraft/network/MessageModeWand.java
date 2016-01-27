package brazillianforgers.dynamiccraft.network;

import brazillianforgers.lib.ItemNBTHelper;
import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class MessageModeWand extends MessageBase<MessageModeWand>{
	
	private String tag;
	private String mode;
	
	public MessageModeWand() {}
	
	public MessageModeWand(String tag, String mode) {
		this.tag = tag;
		this.mode = mode;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		tag = ByteBufUtils.readUTF8String(buf);
		mode = ByteBufUtils.readUTF8String(buf);
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, tag);
		ByteBufUtils.writeUTF8String(buf, mode);
	}
	
	@Override
	public void handleClientSide(MessageModeWand message, EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(MessageModeWand message, EntityPlayer player) {
		ItemNBTHelper.setString(player.getHeldItem(), message.tag, message.mode);
	}

}