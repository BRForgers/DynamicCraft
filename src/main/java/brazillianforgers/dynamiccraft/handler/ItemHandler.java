package brazillianforgers.dynamiccraft.handler;

import brazillianforgers.dynamiccraft.items.DynamicGem;
import brazillianforgers.dynamiccraft.items.ItemFireWand;
import brazillianforgers.dynamiccraft.items.ItemMagicFinder;
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
    
    public static Item dynamicShard;
    public static Item dynamicPearl;
    
    public static Item magicFinder;
    
    public static void initializeItems() {
        fireWand = new ItemFireWand().setUnlocalizedName("fireWand");
        baseRune = new ItemRune(ItemRune.RuneType.BASE);
        aquaRune = new ItemRune(ItemRune.RuneType.AQUA);
        fireRune = new ItemRune(ItemRune.RuneType.FIRE);
        earthRune = new ItemRune(ItemRune.RuneType.EATH);
        
        dynamicPearl = new DynamicGem(DynamicGem.GemType.PEARL);
        dynamicShard = new DynamicGem(DynamicGem.GemType.SHARD);
        
        magicFinder = new ItemMagicFinder();
    }
    
    private static void registerItems() {
        register(fireWand);
        register(baseRune);
        register(aquaRune);
        register(fireRune);
        register(earthRune);
        
        register(dynamicShard);
        register(dynamicPearl);
        
        register(magicFinder);
    }
    
    private static void register(Item item) {
    	GameRegistry.registerItem(item, item.getUnlocalizedName());
    }
}
