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
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.codycornell82.minecraftPlus.MinecraftPlus;

public class NewEnder extends EntityMob {

	public NewEnder(World world) {
		super(world);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
				EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, ToxicMob.class,
				1.0D, true));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				ToxicMob.class, 0, false));
		this.setSize(0.6F, 1.5F);
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.30000001192092896D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(3.0D);
	}

	protected String getLivingSound() {
		return "mp:entityNew.say";
	}

	protected String getHurtSound() {
		return "mp:entityNew.hit";
	}

	protected String getDeathSound() {
		return "mp:entityNew.death";
	}

	public void onLivingUpdate() {
		if (this.isWet()) {
			this.attackEntityFrom(DamageSource.drown, 1.0F);
		}
		for (int i = 0; i < 2; ++i) {
			this.worldObj.spawnParticle("portal",
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
			this.dropItem(Items.ender_pearl, 1);
		}

		j = this.rand.nextInt(2 + p_70628_2_);

		for (k = 0; k < j; ++k) {
			this.dropItem(Items.glowstone_dust, 1);
		}
	}

	public boolean attackEntityAsMob(Entity p_70652_1_) {
		if (super.attackEntityAsMob(p_70652_1_)) {

			((EntityLivingBase) p_70652_1_).addPotionEffect(new PotionEffect(
					MinecraftPlus.Jump.id, 200));
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
			this.dropItem(Items.ender_eye, 1);
			break;
		case 1:
			this.dropItem(Items.record_ward, 1);
			break;
		case 2:
			this.dropItem(Items.experience_bottle, 1);
		}
	}

	public boolean interact(EntityPlayer p_70085_1_) {
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

		if (itemstack != null
				&& itemstack.getItem() == MinecraftPlus.TransformationWand) {
			if (!this.worldObj.isRemote) {
				itemstack.damageItem(1, this);
				EntityEnderman entitypigzombie = new EntityEnderman(
						this.worldObj);
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
