package brazillianforgers.dynamiccraft.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import brazillianforgers.dynamiccraft.blocks.BlockInfusionAltar;
import net.minecraft.block.Block;

public class BlockHandler {
	
	public static void init() {
		initializeBlocks();
		registerBlocks();
	}
	
	public static Block infusionAltar;
	
	public static void initializeBlocks() {
		infusionAltar = new BlockInfusionAltar().setBlockName("blockInfusionAltar");
	}
	
	public static void registerBlocks() {
		GameRegistry.registerBlock(infusionAltar, infusionAltar.getUnlocalizedName());
	}
}
