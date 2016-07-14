package cf.brforgers.dynamiccraft.handler;

import cf.brforgers.dynamiccraft.blocks.BlockDynamic;
import cf.brforgers.dynamiccraft.blocks.BlockDynamicOre;
import cf.brforgers.dynamiccraft.blocks.BlockInfusionAltar;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockHandler {

    public static Block infusionAltar, oreDynamic, blockDynamic;

    public static void init() {
        initializeBlocks();
        registerBlocks();
    }

    public static void initializeBlocks() {
        infusionAltar = new BlockInfusionAltar().setBlockName("blockInfusionAltar");
        oreDynamic = new BlockDynamicOre().setBlockName("oreDynamic");
        blockDynamic = new BlockDynamic().setBlockName("blockDynamic");
    }

    public static void registerBlocks() {
        GameRegistry.registerBlock(infusionAltar, infusionAltar.getUnlocalizedName());
        GameRegistry.registerBlock(oreDynamic, oreDynamic.getUnlocalizedName());
        GameRegistry.registerBlock(blockDynamic, blockDynamic.getUnlocalizedName());
    }
}
