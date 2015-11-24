package brazillianforgers.dynamiccraft.handler;

import brazillianforgers.dynamiccraft.items.ItemFireWand;
import brazillianforgers.dynamiccraft.items.ItemRune;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemHandler {
    public static void init() {
        initializeItems();
        registerItems();
    }
    
    public static Item fireWand;
    public static Item baseRune;
    public static Item aquaRune;
    public static Item fireRune;
    public static Item earthRune;
    
    public static void initializeItems() {
        fireWand = new ItemFireWand().setUnlocalizedName("fireWand");
        baseRune = new ItemRune(1);
        aquaRune = new ItemRune(2);
        fireRune = new ItemRune(3);
        earthRune = new ItemRune(4);
    }
    
    public static void registerItems() {
        GameRegistry.registerItem(fireWand, fireWand.getUnlocalizedName());
        GameRegistry.registerItem(baseRune, baseRune.getUnlocalizedName());
        GameRegistry.registerItem(aquaRune, aquaRune.getUnlocalizedName());
        GameRegistry.registerItem(fireRune, fireRune.getUnlocalizedName());
        GameRegistry.registerItem(earthRune, earthRune.getUnlocalizedName());
    }
}
