package cf.brforgers.dynamiccraft.items;

import cf.brforgers.dynamiccraft.DynamicCraft;
import cf.brforgers.dynamiccraft.api.magic.IMagic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class DynamicGem extends BaseItem implements IMagic {

	private GemType type;
	
	public DynamicGem(GemType type) {
		setCreativeTab(DynamicCraft.dynamicTab);
		this.type = type;
		setName();
	}
	
	private void setName() {
		if(type == GemType.PEARL) setUnlocalizedName("dynamicPearl");
		if(type == GemType.SHARD) setUnlocalizedName("dynamicShard");
	}
	
	public GemType getType() {
		return type;
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		String cshift = EnumChatFormatting.DARK_PURPLE + EnumChatFormatting.BOLD.toString()
				+ StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(itemStack) + ".description.magic").trim()
				+ ": " + getMagic(itemStack);
		String cshift2 = EnumChatFormatting.DARK_PURPLE + EnumChatFormatting.BOLD.toString() + "Stack: " + getMagic(itemStack) * itemStack.stackSize;

		String sshift = EnumChatFormatting.DARK_PURPLE +  "<Press Shift>";

		if(!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.add(sshift);
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.add(cshift);

			if(itemStack.stackSize > 1)
				list.add(cshift2);
		}
	}

	@Override
	public int getMagic(ItemStack stk) {
		switch(type) {
			case PEARL:
				return 50;
			case SHARD:
				return 10;
		default:
			return 0;
		}
	}

	@Override
	public void setMagic(ItemStack stk, int amount) {
		return;
	}

	public enum GemType {
		SHARD,
		PEARL
	}
	
}
