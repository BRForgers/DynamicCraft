package cf.brforgers.dynamiccraft.handler;

import cf.brforgers.dynamiccraft.DynamicCraft;
import cf.brforgers.dynamiccraft.container.ContainerInfusionAltar;
import cf.brforgers.dynamiccraft.container.ContainerMagicCollector;
import cf.brforgers.dynamiccraft.container.InventoryMagicCollector;
import cf.brforgers.dynamiccraft.gui.GuiInfusionAltar;
import cf.brforgers.dynamiccraft.gui.GuiMagicCollector;
import cf.brforgers.dynamiccraft.items.ItemMagicCollector;
import cf.brforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		ItemStack stack = null;
		if(player.getHeldItem() != null)
			stack = player.getHeldItem();

		switch (ID) {
			case DynamicCraft.guiIdInfusion:
				if(entity instanceof TileEntityInfusionAltar) {
					return new ContainerInfusionAltar(player.inventory, (TileEntityInfusionAltar) entity);
				} 
				return null;
			case DynamicCraft.guiIdMagicFinder:
				if(stack.getItem() instanceof ItemMagicCollector) {
					return new ContainerMagicCollector(player, player.inventory, stack, new InventoryMagicCollector(player.getHeldItem()));
				}
				return null;
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		ItemStack stack = null;
		if(player.getHeldItem() != null)
			stack = player.getHeldItem();
		
		switch (ID) {
		case DynamicCraft.guiIdInfusion:
			if(entity instanceof TileEntityInfusionAltar) {
				return new GuiInfusionAltar(player.inventory, (TileEntityInfusionAltar) entity);
			} 
			return null;
		case DynamicCraft.guiIdMagicFinder:
			if(stack.getItem() instanceof ItemMagicCollector) {
				return new GuiMagicCollector(player, player.inventory, stack, new InventoryMagicCollector(player.getHeldItem()));
			}
			return null;
		default:
			return null;
		}
	}

}
