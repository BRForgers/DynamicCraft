package cf.brforgers.dynamiccraft.handler;

import cf.brforgers.dynamiccraft.items.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemHandler {
    public static Item fireWand;
    public static Item aquaWand;
    public static Item baseRune;
    public static Item aquaRune;
    public static Item fireRune;
    public static Item earthRune;
    public static Item dynamicShard;
    public static Item dynamicPearl;
    public static Item magicFinder;

    public static void init() {
        initializeItems();
        registerItems();
    }
    
    public static void initializeItems() {
        fireWand = new ItemFireWand().setUnlocalizedName("fireWand");
        aquaWand = new ItemAquaWand().setUnlocalizedName("aquaWand");
        baseRune = new ItemRune(ItemRune.RuneType.BASE);
        aquaRune = new ItemRune(ItemRune.RuneType.AQUA);
        fireRune = new ItemRune(ItemRune.RuneType.FIRE);
        earthRune = new ItemRune(ItemRune.RuneType.EATH);
        dynamicPearl = new DynamicGem(DynamicGem.GemType.PEARL);
        dynamicShard = new DynamicGem(DynamicGem.GemType.SHARD);
        magicFinder = new ItemMagicCollector().setUnlocalizedName("magicCollector");
    }
    
    private static void registerItems() {
        register(fireWand);
        register(aquaWand);
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
