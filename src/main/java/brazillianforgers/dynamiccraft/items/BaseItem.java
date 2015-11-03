package brazillianforgers.dynamiccraft.items;

import brazillianforgers.dynamiccraft.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

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
