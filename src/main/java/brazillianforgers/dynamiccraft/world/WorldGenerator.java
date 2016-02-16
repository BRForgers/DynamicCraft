package brazillianforgers.dynamiccraft.world;

import java.util.Random;

import brazillianforgers.dynamiccraft.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator
			, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		
			case 0: generateOverworld(random, world, chunkX * 16, chunkZ * 16); break;
			case 1: generateENd(random, world, chunkX * 16, chunkZ * 16); break;
			case -1: generateNether(random, world, chunkX * 16, chunkZ * 16); break;
			default: generateOverworld(random, world, chunkX * 16, chunkZ * 16);
		
		}
		
	}
	
	private void generateNether(Random random, World world, int x, int z) { }

	private void generateENd(Random random, World world, int x, int z) { }

	private void generateOverworld(Random random, World world, int x, int z) {
		addOreSpawn(BlockHandler.oreDynamic, world, random, x, z, 2, 4, 10, 0, 35);
	}
	
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize,
			int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		
		WorldGenMinable minable = new WorldGenMinable(block, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), Blocks.stone);
		
		for(int i = 0;i <= chancesToSpawn; i++) {
			
			int posX = blockXPos + random.nextInt(15);
			int posZ = blockZPos + random.nextInt(15);
			int posY = minY + random.nextInt(maxY - minY);

			minable.generate(world, random, posX, posY, posZ);
		}
		
	}
	
	public void addNetherOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize,
			int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		
	    WorldGenMinable minable = new WorldGenMinable(block, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), Blocks.netherrack);
	   
	    for (int i = 0; i < chancesToSpawn; i++) {
		    int posX = blockXPos + random.nextInt(16);
		    int posY = minY + random.nextInt(maxY - minY);
		    int posZ = blockZPos + random.nextInt(16);
		    minable.generate(world, random, posX, posY, posZ);
	    }
	}
}
