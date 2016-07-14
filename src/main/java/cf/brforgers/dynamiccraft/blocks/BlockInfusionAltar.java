package cf.brforgers.dynamiccraft.blocks;

import cf.brforgers.dynamiccraft.DynamicCraft;
import cf.brforgers.dynamiccraft.handler.BlockHandler;
import cf.brforgers.dynamiccraft.tileentities.TileEntityInfusionAltar;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockInfusionAltar extends BlockContainer {

    public BlockInfusionAltar() {
        super(Material.rock);

        setCreativeTab(DynamicCraft.dynamicTab);
        setHardness(6F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityInfusionAltar();
    }

    @Override
    public Item getItemDropped(int i, Random rand, int i2) {
        return Item.getItemFromBlock(BlockHandler.infusionAltar);
    }


    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            FMLNetworkHandler.openGui(player, DynamicCraft.mod, DynamicCraft.guiIdInfusion, world, x, y, z);
        }
        return true;
    }
}
