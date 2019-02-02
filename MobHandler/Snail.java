package com.codycornell82.minecraftPlus.MobHandler;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.codycornell82.minecraftPlus.MinecraftPlus;

public class Snail extends EntityAnimal {

	private EntityAIEatGrass field_146087_bs = new EntityAIEatGrass(this);

	public Snail(World world) {
		super(world);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.setSize(0.2f, 0.2f);
	}

	public boolean isAIEnabled() {
		return true;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable age) {

		return null;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(0.1D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.10D);
	}

	protected Item getDropItem() {
		return this.isBurning() ? MinecraftPlus.snailCooked
				: MinecraftPlus.snail;
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(1) + 1 + this.rand.nextInt(1 + p_70628_2_);

		for (int k = 0; k < j; ++k) {
			if (this.isBurning()) {
				this.dropItem(MinecraftPlus.snailCooked, 1);
			} else {
				this.dropItem(MinecraftPlus.snail, 1);
			}
		}

	}

	public void eatGrassBonus() {
		this.setHealth(0.1F);
	}

	public boolean interact(EntityPlayer p_70085_1_) {
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

		if (itemstack != null
				&& itemstack.getItem() == MinecraftPlus.TransformationWand) {
			if (!this.worldObj.isRemote) {
				itemstack.damageItem(1, this);
				EntitySlime entitypigzombie = new EntitySlime(this.worldObj);
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

	public void onDeath(DamageSource p_70645_1_) {
		super.onDeath(p_70645_1_);

		if (p_70645_1_.getEntity() instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) p_70645_1_.getEntity();
			entityplayer.triggerAchievement(MinecraftPlus.JustAddSalt);

		}
	}
}
