package brazillianforgers.dynamiccraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import rennancge.dynamic.lib.Strings;

public class BaseItem extends Item{
    
    public BaseItem() {
        super();
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Strings.MODID + ":" + getUnlocalizedName().substring(5).toLowerCase());
    }
}
