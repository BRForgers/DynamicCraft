package cf.brforgers.dynamiccraft.items;

import cf.brforgers.core.lib.ItemHelper;
import cf.brforgers.dynamiccraft.DynamicCraft;
import cf.brforgers.dynamiccraft.api.magic.ItemMagic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class ItemMagicCollector extends ItemMagic{
	
	public ItemMagicCollector() {
		super(1000);
		
		setCreativeTab(DynamicCraft.dynamicTab);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
			player.openGui(DynamicCraft.mod, DynamicCraft.guiIdMagicFinder, world, (int) player.posX, (int) player.posY, 
					(int) player.posZ);
		return itemStack;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity ent, int slot, boolean selected) {
		super.onUpdate(stack, world, ent, slot, selected);
		
		EntityPlayer p = (EntityPlayer)ent;
		int r = itemRand.nextInt(100) + 1;
		
		if(!world.isRemote) {
			if(p.getHeldItem() == stack) {
				BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenAt((int) p.posX, (int) p.posZ);

				ItemHelper.setString(stack, "biome", biomegenbase.biomeName);				
				if(biomegenbase == BiomeGenBase.extremeHills || biomegenbase == BiomeGenBase.swampland) {
					if(r <= 4) {
						((ItemMagicCollector)stack.getItem()).receiveMagic(stack, 10);
					}
				}else {
					if(r == 1) {
						((ItemMagicCollector)stack.getItem()).receiveMagic(stack, 10);
					}
				}
				
			}
			
		}
	}
	
}
