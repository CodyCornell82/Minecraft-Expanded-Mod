package com.codycornell82.minecraftPlus.MobHandler;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Angel extends EntityMob {

	public Angel(World world) {
		super(world);
		this.isImmuneToFire = true;
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, Demon.class,
				1.0D, true));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this,
				hellhound.class, 1.0D, true));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				Demon.class, 0, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				hellhound.class, 0, false));
		this.setSize(0.6F, 1.8F);
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
				.setBaseValue(8.0D);
		this.isImmuneToFire = true;
	}

	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender(float p_70070_1_) {
		return 15728880;
	}

	public void onLivingUpdate() {

		for (int i = 0; i < 2; ++i) {
			this.worldObj.spawnParticle("enchantmenttable", this.posX
					+ (this.rand.nextDouble() - 0.5D) * (double) this.width,
					this.posY + this.rand.nextDouble() * (double) this.height,
					this.posZ + (this.rand.nextDouble() - 0.5D)
							* (double) this.width, 0.0D, 0.0D, 0.0D);
		}

		super.onLivingUpdate();
	}

	protected Item getDropItem() {
		return Items.glowstone_dust;
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	protected void dropRareDrop(int p_70600_1_) {
		switch (this.rand.nextInt(3)) {
		case 0:
			this.dropItem(Items.gold_nugget, 1);
			break;
		case 1:
			this.dropItem(Items.golden_apple, 1);
			break;
		case 2:
			this.dropItem(Items.emerald, 1);
		}
	}

	public boolean interact(EntityPlayer p_70085_1_) {
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

		if (itemstack != null
				&& itemstack.getItem() == MinecraftPlus.TransformationWand) {
			if (!this.worldObj.isRemote) {
				itemstack.damageItem(1, this);
				Demon entitypigzombie = new Demon(this.worldObj);
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
			entityplayer.triggerAchievement(MinecraftPlus.FallenAngel);

		}
	}

}
