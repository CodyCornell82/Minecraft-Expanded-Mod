package com.codycornell82.minecraftPlus.MobHandler;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.ZombieEvent.SummonAidEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HumanEntity extends EntityMob
{
    private boolean field_146076_bu = false;
    private float field_146074_bv = -1.0F;
    private float field_146073_bw;
    private static final String __OBFID = "CL_00001702";

    public HumanEntity(World p_i1745_1_)
    {
        super(p_i1745_1_);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.setSize(0.6F, 1.8F);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
       
    }

    protected void entityInit()
    {
        super.entityInit();
        this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(14, Byte.valueOf((byte)0));
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue()
    {
        int i = super.getTotalArmorValue() + 2;

        if (i > 20)
        {
            i = 20;
        }

        return i;
    }

    public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        boolean flag = super.attackEntityAsMob(p_70652_1_);

        if (flag)
        {
            int i = this.worldObj.difficultySetting.getDifficultyId();

            if (this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float)i * 0.3F)
            {
                p_70652_1_.setFire(2 * i);
            }
        }

        return flag;
    }

    protected Item getDropItem()
    {
        return Items.apple;
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }

    protected void dropRareDrop(int p_70600_1_)
    {
        switch (this.rand.nextInt(3))
        {
            case 0:
                this.dropItem(Items.diamond, 1);
                break;
            case 1:
                this.dropItem(Items.iron_ingot, 1);
                break;
            case 2:
                this.dropItem(Items.gold_ingot, 1);
        }
    }

    /**
     * Makes entity wear random armor based on difficulty
     */
    protected void addRandomArmor()
    {
        super.addRandomArmor();
        if (this.rand.nextFloat() < (this.worldObj.difficultySetting == EnumDifficulty.HARD ? 0.05F : 0.01F))
        {
            int i = this.rand.nextInt(7);

            if (i == 0)
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
            }
            else if(i == 1)
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.fishing_rod));
            }
            else if(i == 2)
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_pickaxe));
            }
            else if(i == 3)
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_axe));
            }
            else if(i == 4)
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_hoe));
            }
            else if(i == 5)
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_shovel));
            }
            else
            {
            	this.setCurrentItemOrArmor(0, null);
            }
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
	public boolean interact(EntityPlayer p_70085_1_) {
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

		if (itemstack != null
				&& itemstack.getItem() == MinecraftPlus.TransformationWand) {
			if (!this.worldObj.isRemote) {
				itemstack.damageItem(1, this);
				EntityVillager entitypigzombie = new EntityVillager(this.worldObj);
				entitypigzombie.setLocationAndAngles(this.posX, this.posY,
						this.posZ, this.rotationYaw, this.rotationPitch);
				this.worldObj.spawnEntityInWorld(entitypigzombie);
				this.playSound("mp:Change", 1.0f, 1.0f);
				p_70085_1_.triggerAchievement(MinecraftPlus.ItJustChanged);
				p_70085_1_.triggerAchievement(MinecraftPlus.Village);
				this.setDead();
			}
		} else {
			return super.interact(p_70085_1_);
		}
		return true;
	}




    /**
     * Sets the width and height of the entity. Args: width, height
     */
    protected final void setSize(float p_70105_1_, float p_70105_2_)
    {
        boolean flag = this.field_146074_bv > 0.0F && this.field_146073_bw > 0.0F;
        this.field_146074_bv = p_70105_1_;
        this.field_146073_bw = p_70105_2_;

        if (!flag)
        {
            this.func_146069_a(1.0F);
        }
    }

    protected final void func_146069_a(float p_146069_1_)
    {
        super.setSize(this.field_146074_bv * p_146069_1_, this.field_146073_bw * p_146069_1_);
    }

    class GroupData implements IEntityLivingData
    {
        public boolean field_142048_a;
        public boolean field_142046_b;
        private static final String __OBFID = "CL_00001704";

        private GroupData(boolean p_i2348_2_, boolean p_i2348_3_)
        {
            this.field_142048_a = false;
            this.field_142046_b = false;
            this.field_142048_a = p_i2348_2_;
            this.field_142046_b = p_i2348_3_;
        }

        GroupData(boolean p_i2349_2_, boolean p_i2349_3_, Object p_i2349_4_)
        {
            this(p_i2349_2_, p_i2349_3_);
        }
    }
}