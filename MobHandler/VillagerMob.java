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

public class VillagerMob extends EntityMob
{
    protected static final IAttribute field_110186_bp = (new RangedAttribute("zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).setDescription("Spawn Reinforcements Chance");
    private final EntityAIBreakDoor field_146075_bs = new EntityAIBreakDoor(this);
    private boolean field_146076_bu = false;
    private float field_146074_bv = -1.0F;
    private float field_146073_bw;
    private static final String __OBFID = "CL_00001702";

    public VillagerMob(World p_i1745_1_)
    {
        super(p_i1745_1_);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
        this.setSize(0.6F, 1.8F);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
        this.getAttributeMap().registerAttribute(field_110186_bp).setBaseValue(this.rand.nextDouble() * ForgeModContainer.zombieSummonBaseChance);
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

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }

    public boolean func_146072_bX()
    {
        return this.field_146076_bu;
    }

    public void func_146070_a(boolean p_146070_1_)
    {
        if (this.field_146076_bu != p_146070_1_)
        {
            this.field_146076_bu = p_146070_1_;

            if (p_146070_1_)
            {
                this.tasks.addTask(1, this.field_146075_bs);
            }
            else
            {
                this.tasks.removeTask(this.field_146075_bs);
            }
        }
    }

    /**
     * If Animal, checks if the age timer is negative
     */
    public boolean isChild()
    {
        return this.getDataWatcher().getWatchableObjectByte(12) == 1;
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int getExperiencePoints(EntityPlayer p_70693_1_)
    {
        if (this.isChild())
        {
            this.experienceValue = (int)((float)this.experienceValue * 2.5F);
        }

        return super.getExperiencePoints(p_70693_1_);
    }


    /**
     * Return whether this zombie is a villager.
     */
    public boolean isVillager()
    {
        return this.getDataWatcher().getWatchableObjectByte(13) == 1;
    }

    /**
     * Set whether this zombie is a villager.
     */
    public void setVillager(boolean p_82229_1_)
    {
        this.getDataWatcher().updateObject(13, Byte.valueOf((byte)(p_82229_1_ ? 1 : 0)));
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.villager.idle";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
    	 return "mob.villager.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.villager.death";
    }

    protected Item getDropItem()
    {
        return Items.wheat;
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
                this.dropItem(Items.emerald, 1);
                break;
            case 1:
                this.dropItem(Items.carrot, 1);
                break;
            case 2:
                this.dropItem(Items.potato, 1);
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


    public void func_146071_k(boolean p_146071_1_)
    {
        this.func_146069_a(p_146071_1_ ? 0.5F : 1.0F);
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