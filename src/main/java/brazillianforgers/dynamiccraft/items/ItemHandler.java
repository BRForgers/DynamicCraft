package brazillianforgers.dynamiccraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemHandler {
    public static void init() {
        initializeItems();
        registerItems();
    }
    
    public static Item fireWand;
    
    public static void initializeItems() {
        fireWand = new ItemFireWand().setUnlocalizedName("fireWand");
    }
    
    public static void registerItems() {
        GameRegistry.registerItem(fireWand, fireWand.getUnlocalizedName());
    }
}
