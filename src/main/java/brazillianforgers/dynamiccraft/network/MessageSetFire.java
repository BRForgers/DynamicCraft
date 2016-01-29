package brazillianforgers.dynamiccraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class MessageSetFire extends MessageBase<MessageSetFire>{

	private int id;
	
	public MessageSetFire() {}
	
	public MessageSetFire(int id) {
		this.id = id;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		id = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(id);
	}
	
	@Override
	public void handleClientSide(MessageSetFire message, EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(MessageSetFire message, EntityPlayer player) {
		for(Object o : player.worldObj.getLoadedEntityList()) {
			Entity ent = (Entity) o;
			
			if(ent.hashCode() == message.id) {
				ent.setFire(5);
			}
		}
	}

}
