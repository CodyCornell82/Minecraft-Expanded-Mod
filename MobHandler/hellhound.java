package com.codycornell82.minecraftPlus.MobHandler;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class hellhound extends EntityMob {

	public hellhound(World world) {
		super(world);
		this.getNavigator().setBreakDoors(true);
		this.isImmuneToFire = true;
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
				EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this,
				EntityVillager.class, 1.0D, true));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, Angel.class,
				1.0D, true));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks
				.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityVillager.class, 0, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				Angel.class, 0, false));
		this.setSize(0.6F, 0.8F);
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.25);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(6.0D);
		this.isImmuneToFire = true;
		this.experienceValue = 10;
	}

	protected void func_145780_a(int p_145780_1_, int p_145780_2_,
			int p_145780_3_, Block p_145780_4_) {
		this.playSound("mob.wolf.step", 0.15F, 1.0F);
	}

	protected String getLivingSound() {
		return "mob.wolf.growl";
	}

	protected String getHurtSound() {
		return "mob.wolf.hurt";
	}

	protected String getDeathSound() {
		return "mob.wolf.death";
	}

	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender(float p_70070_1_) {
		return 15728880;
	}

	public void onLivingUpdate() {
		if (!this.worldObj.isRemote) {
			if (this.isWet()) {
				this.attackEntityFrom(DamageSource.drown, 1.0F);
			}
		}

		if (this.rand.nextInt(24) == 0) {
			this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D,
					this.posZ + 0.5D, "fire.fire",
					1.0F + this.rand.nextFloat(),
					this.rand.nextFloat() * 0.7F + 0.3F);
		}

		for (int i = 0; i < 2; ++i) {
			this.worldObj.spawnParticle("flame",
					this.posX + (this.rand.nextDouble() - 0.5D)
							* (double) this.width,
					this.posY + this.rand.nextDouble() * (double) this.height,
					this.posZ + (this.rand.nextDouble() - 0.5D)
							* (double) this.width, 0.0D, 0.0D, 0.0D);
		}

		super.onLivingUpdate();
	}

	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(2 + p_70628_2_);
		int k;

		for (k = 0; k < j; ++k) {
			this.dropItem(Items.leather, 1);
		}

		j = this.rand.nextInt(2 + p_70628_2_);

		for (k = 0; k < j; ++k) {
			this.dropItem(Items.blaze_powder, 1);
		}
	}

	public boolean attackEntityAsMob(Entity p_70652_1_) {
		if (super.attackEntityAsMob(p_70652_1_)) {

			((EntityLivingBase) p_70652_1_).setFire(8);
		}
		return true;
	}

	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	protected void dropRareDrop(int p_70600_1_) {
		switch (this.rand.nextInt(3)) {
		case 0:
			this.dropItem(Items.nether_wart, 1);
			break;
		case 1:
			this.dropItem(Items.bone, 1);
			break;
		case 2:
			this.dropItem(Items.netherbrick, 1);
		}
	}

	public boolean interact(EntityPlayer p_70085_1_) {
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

		if (itemstack != null
				&& itemstack.getItem() == MinecraftPlus.TransformationWand) {
			if (!this.worldObj.isRemote) {
				itemstack.damageItem(1, this);
				EntityWolf entitypigzombie = new EntityWolf(this.worldObj);
				entitypigzombie.setLocationAndAngles(this.posX, this.posY,
						this.posZ, this.rotationYaw, this.rotationPitch);
				this.worldObj.spawnEntityInWorld(entitypigzombie);
				this.playSound("random.fizz", 1.0f, 1.0f);
				p_70085_1_.triggerAchievement(MinecraftPlus.ItJustChanged);
				this.setDead();
			}
		} else {
			return super.interact(p_70085_1_);
		}
		return true;
	}

}
