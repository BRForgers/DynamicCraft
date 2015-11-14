package brazillianforgers.dynamiccraft.handler;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.dynamiccraft.container.ContainerInfusionAltar;
import brazillianforgers.dynamiccraft.gui.GuiInfusionAltar;
import brazillianforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null){
			switch (ID) {
				case DynamicCraft.guiIdInfusion:
					if(entity instanceof TileEntityInfusionAltar) {
						return new ContainerInfusionAltar(player.inventory, (TileEntityInfusionAltar) entity);
					} 
					return null;
				default:
					return null;
			}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null){
			switch (ID) {
				case DynamicCraft.guiIdInfusion:
					if(entity instanceof TileEntityInfusionAltar) {
						return new GuiInfusionAltar(player.inventory, (TileEntityInfusionAltar) entity);
					} 
					return null;
				default:
					return null;
			}
		}
		return null;
	}

}
