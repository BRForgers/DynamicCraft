package brazillianforgers.dynamiccraft.handler;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.container.ContainerInfusionAltar;
import brazillianforgers.dynamiccraft.container.ContainerMagicCollector;
import brazillianforgers.dynamiccraft.container.InventoryMagicCollector;
import brazillianforgers.dynamiccraft.gui.GuiInfusionAltar;
import brazillianforgers.dynamiccraft.gui.GuiMagicCollector;
import brazillianforgers.dynamiccraft.items.ItemMagicCollector;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.network.IGuiHandler;

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
