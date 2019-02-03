package com.codycornell82.minecraftPlus.MobHandler;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
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
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.codycornell82.minecraftPlus.MinecraftPlus;

public class PoisonSnail extends EntityMob {

	public PoisonSnail(World world) {
		super(world);
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
				EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));
		this.setSize(0.2f, 0.2f);
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.setBaseValue(64.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
		.setBaseValue(0.1D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.10D);
	}

	protected Item getDropItem() {
		return MinecraftPlus.snail;
	}
	public boolean attackEntityAsMob(Entity p_70652_1_) {
		if (super.attackEntityAsMob(p_70652_1_)) {

			((EntityLivingBase) p_70652_1_).addPotionEffect(new PotionEffect(
					Potion.poison.getId(), 100, 0, true));
			;
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
			this.dropItem(Items.spider_eye, 1);
			break;
		case 1:
			this.dropItem(Items.poisonous_potato, 1);
			break;
		case 2:
			this.dropItem(Items.slime_ball, 1);
		}
	}

	public boolean interact(EntityPlayer p_70085_1_) {
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

		if (itemstack != null
				&& itemstack.getItem() == MinecraftPlus.TransformationWand) {
			if (!this.worldObj.isRemote) {
				itemstack.damageItem(1, this);
				Snail entitypigzombie = new Snail(this.worldObj);
				entitypigzombie.setLocationAndAngles(this.posX, this.posY,
						this.posZ, this.rotationYaw, this.rotationPitch);
				this.worldObj.spawnEntityInWorld(entitypigzombie);
				this.playSound("mp:Change", 1.0f, 1.0f);
				p_70085_1_.triggerAchievement(MinecraftPlus.ItJustChanged);
				this.setDead();
			}
		} else {
			return super.interact(p_70085_1_);
		}
		return true;
	}
	public void onDeath(DamageSource p_70645_1_) {
		super.onDeath(p_70645_1_);

		if (p_70645_1_.getEntity() instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) p_70645_1_.getEntity();
			entityplayer.triggerAchievement(MinecraftPlus.JustAddSalt);

		}
	}
}
