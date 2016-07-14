package cf.brforgers.dynamiccraft.entities;

import cf.brforgers.dynamiccraft.Strings;
import cf.brforgers.dynamiccraft.handler.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityFireWizard extends EntityMob {

    private static final ItemStack defaultHeldItem;

    static {
        defaultHeldItem = new ItemStack(ItemHandler.fireWand, 1);
    }

    public EntityFireWizard(World world) {
        super(world);
        isImmuneToFire = true;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.5D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
    }

    @Override
    protected String getLivingSound() {
        return Strings.MODID + ":wizardAmbient";
    }

    protected boolean isAIEnabled() {
        return false;
    }

    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }

    @Override
    protected Item getDropItem() {
        return ItemHandler.fireWand;
    }

    @Override
    protected void dropRareDrop(int par1) {
        int i = this.rand.nextInt(1);
        switch (i) {
            case 0:
                this.dropItem(ItemHandler.fireWand, 1);
                break;
            case 1:
                this.dropItem(ItemHandler.fireWand, 1);
                break;
            case 2:
                this.dropItem(ItemHandler.fireWand, 1);
                break;
            default:
                System.out.println(i);
                this.dropItem(ItemHandler.fireWand, 1);
                break;
        }
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    public boolean getCanSpawnHere() {
        int i = (int) Math.floor(posX);
        int j = (int) Math.floor(boundingBox.minY);
        int k = (int) Math.floor(posZ);
        boolean[] spawnBlocks = new boolean[256];
        spawnBlocks[Block.getIdFromBlock(Blocks.nether_brick)] = true;

        int var1 = Block.getIdFromBlock(this.worldObj.getBlock(i, j - 1, k));

        return (spawnBlocks[var1]);
    }

    @Override
    public void attackEntity(Entity entity, float distancia) {
        this.arrowHitTimer++;

        if (this.arrowHitTimer < -40 || this.arrowHitTimer > 20) {
            this.arrowHitTimer = -20;
        }

        if (this.arrowHitTimer == 20) {

            Vec3 look = this.getLookVec();
            if (distancia > 2) {

                this.worldObj.spawnEntityInWorld(new EntityFireBall(this.worldObj, this));

                this.arrowHitTimer = -40;
            } else {
                this.arrowHitTimer = -20;
                attackEntityAsMob(entity);
            }
        }
    }

}