package com.codycornell82.minecraftPlus.MobHandler;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MagicAI extends EntityMob implements IRangedAttackMob {
	private static final UUID field_110184_bp = UUID
			.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
	private static final AttributeModifier field_110185_bq = (new AttributeModifier(
			field_110184_bp, "Drinking speed penalty", -0.25D, 0))
			.setSaved(false);
	/** List of items a witch should drop on death. */
	private static final Item[] witchDrops = new Item[] { Items.bone,
			MinecraftPlus.Powder, Items.coal, Items.ender_pearl,
			Items.glass_bottle, Items.experience_bottle, MinecraftPlus.FarNug,
			MinecraftPlus.VoidPowder };
	/**
	 * Timer used as interval for a witch's attack, decremented every tick if
	 * aggressive and when reaches zero the witch will throw a potion at the
	 * target entity.
	 */
	private int witchAttackTimer;
	private static final String __OBFID = "CL_00001701";

	public MagicAI(World p_i1744_1_) {
		super(p_i1744_1_);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 60, 10.0F));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));
	}

	protected void entityInit() {
		super.entityInit();
		this.getDataWatcher().addObject(21, Byte.valueOf((byte) 0));
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {
		return "mob.skeleton.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "mob.skeleton.hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "mob.skeleton.death";
	}

	protected void func_145780_a(int p_145780_1_, int p_145780_2_,
			int p_145780_3_, Block p_145780_4_) {
		this.playSound("mob.skeleton.step", 0.15F, 1.0F);
	}

	/**
	 * Set whether this witch is aggressive at an entity.
	 */
	public void setAggressive(boolean p_82197_1_) {
		this.getDataWatcher().updateObject(21,
				Byte.valueOf((byte) (p_82197_1_ ? 1 : 0)));
	}

	/**
	 * Return whether this witch is aggressive at an entity.
	 */
	public boolean getAggressive() {
		return this.getDataWatcher().getWatchableObjectByte(21) == 1;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(26.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.25D);
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		if (this.isWet()) {
			this.attackEntityFrom(DamageSource.drown, 1.0F);
		}

		int k;

		int i;
		int j;
		Block block;

		for (k = 0; k < 2; ++k) {
			this.worldObj.spawnParticle("portal",
					this.posX + (this.rand.nextDouble() - 0.5D)
							* (double) this.width,
					this.posY + this.rand.nextDouble() * (double) this.height
							- 0.25D, this.posZ
							+ (this.rand.nextDouble() - 0.5D)
							* (double) this.width,
					(this.rand.nextDouble() - 0.5D) * 2.0D,
					-this.rand.nextDouble(),
					(this.rand.nextDouble() - 0.5D) * 2.0D);
		}
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote) {
			float f = this.getBrightness(1.0F);

			if (f > 0.5F
					&& this.worldObj.canBlockSeeTheSky(
							MathHelper.floor_double(this.posX),
							MathHelper.floor_double(this.posY),
							MathHelper.floor_double(this.posZ))
					&& this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
				this.entityToAttack = null;
				this.teleportRandomly();
			}
		}
		if (this.isWet() || this.isBurning()) {
			this.entityToAttack = null;
			this.teleportRandomly();
		}

		if (!this.worldObj.isRemote) {
			if (this.getAggressive()) {
				if (this.witchAttackTimer-- <= 0) {
					this.setAggressive(false);
					ItemStack itemstack = this.getHeldItem();
					this.setCurrentItemOrArmor(0, (ItemStack) null);

					if (itemstack != null
							&& itemstack.getItem() == Items.potionitem) {
						List list = Items.potionitem.getEffects(itemstack);

						if (list != null) {
							Iterator iterator = list.iterator();

							while (iterator.hasNext()) {
								PotionEffect potioneffect = (PotionEffect) iterator
										.next();
								this.addPotionEffect(new PotionEffect(
										potioneffect));
							}
						}
					}

					this.getEntityAttribute(
							SharedMonsterAttributes.movementSpeed)
							.removeModifier(field_110185_bq);
				}
			} else {
				short short1 = -1;

				if (this.rand.nextFloat() < 0.15F
						&& this.isInsideOfMaterial(Material.water)
						&& !this.isPotionActive(Potion.waterBreathing)) {
					short1 = 8237;
				} else if (this.rand.nextFloat() < 0.15F && this.isBurning()
						&& !this.isPotionActive(Potion.fireResistance)) {
					short1 = 16307;
				} else if (this.rand.nextFloat() < 0.05F
						&& this.getHealth() < this.getMaxHealth()) {
					short1 = 16341;
				} else if (this.rand.nextFloat() < 0.25F
						&& this.getAttackTarget() != null
						&& !this.isPotionActive(Potion.moveSpeed)
						&& this.getAttackTarget().getDistanceSqToEntity(this) > 121.0D) {
					short1 = 16274;
				} else if (this.rand.nextFloat() < 0.25F
						&& this.getAttackTarget() != null
						&& !this.isPotionActive(Potion.moveSpeed)
						&& this.getAttackTarget().getDistanceSqToEntity(this) > 121.0D) {
					short1 = 16274;
				}

				if (short1 > -1) {
					this.setCurrentItemOrArmor(0, new ItemStack(
							Items.potionitem, 1, short1));
					this.witchAttackTimer = this.getHeldItem()
							.getMaxItemUseDuration();
					this.setAggressive(true);
					IAttributeInstance iattributeinstance = this
							.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
					iattributeinstance.removeModifier(field_110185_bq);
					iattributeinstance.applyModifier(field_110185_bq);
				}
			}

			if (this.rand.nextFloat() < 7.5E-4F) {
				this.worldObj.setEntityState(this, (byte) 15);
			}
		}

		super.onLivingUpdate();
	}

	/**
	 * Teleport the enderman to a random nearby position
	 */
	protected boolean teleportRandomly() {
		double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
		double d1 = this.posY + (double) (this.rand.nextInt(64) - 32);
		double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
		return this.teleportTo(d0, d1, d2);
	}

	/**
	 * Teleport the enderman to another entity
	 */
	protected boolean teleportToEntity(Entity p_70816_1_) {
		Vec3 vec3 = Vec3.createVectorHelper(this.posX - p_70816_1_.posX,
				this.boundingBox.minY + (double) (this.height / 2.0F)
						- p_70816_1_.posY + (double) p_70816_1_.getEyeHeight(),
				this.posZ - p_70816_1_.posZ);
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D
				- vec3.xCoord * d0;
		double d2 = this.posY + (double) (this.rand.nextInt(16) - 8)
				- vec3.yCoord * d0;
		double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D
				- vec3.zCoord * d0;
		return this.teleportTo(d1, d2, d3);
	}

	/**
	 * Teleport the enderman
	 */
	protected boolean teleportTo(double p_70825_1_, double p_70825_3_,
			double p_70825_5_) {
		EnderTeleportEvent event = new EnderTeleportEvent(this, p_70825_1_,
				p_70825_3_, p_70825_5_, 0);
		if (MinecraftForge.EVENT_BUS.post(event)) {
			return false;
		}
		double d3 = this.posX;
		double d4 = this.posY;
		double d5 = this.posZ;
		this.posX = event.targetX;
		this.posY = event.targetY;
		this.posZ = event.targetZ;
		boolean flag = false;
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posY);
		int k = MathHelper.floor_double(this.posZ);

		if (this.worldObj.blockExists(i, j, k)) {
			boolean flag1 = false;

			while (!flag1 && j > 0) {
				Block block = this.worldObj.getBlock(i, j - 1, k);

				if (block.getMaterial().blocksMovement()) {
					flag1 = true;
				} else {
					--this.posY;
					--j;
				}
			}

			if (flag1) {
				this.setPosition(this.posX, this.posY, this.posZ);

				if (this.worldObj.getCollidingBoundingBoxes(this,
						this.boundingBox).isEmpty()
						&& !this.worldObj.isAnyLiquid(this.boundingBox)) {
					flag = true;
				}
			}
		}

		if (!flag) {
			this.setPosition(d3, d4, d5);
			return false;
		} else {
			short short1 = 128;

			for (int l = 0; l < short1; ++l) {
				double d6 = (double) l / ((double) short1 - 1.0D);
				float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				double d7 = d3 + (this.posX - d3) * d6
						+ (this.rand.nextDouble() - 0.5D) * (double) this.width
						* 2.0D;
				double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble()
						* (double) this.height;
				double d9 = d5 + (this.posZ - d5) * d6
						+ (this.rand.nextDouble() - 0.5D) * (double) this.width
						* 2.0D;
				this.worldObj.spawnParticle("portal", d7, d8, d9, (double) f,
						(double) f1, (double) f2);
			}

			this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal",
					1.0F, 1.0F);
			this.playSound("mob.endermen.portal", 1.0F, 1.0F);
			return true;
		}
	}

	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte p_70103_1_) {
		if (p_70103_1_ == 15) {
			for (int i = 0; i < this.rand.nextInt(35) + 10; ++i) {
				this.worldObj.spawnParticle("witchMagic",
						this.posX + this.rand.nextGaussian()
								* 0.12999999523162842D, this.boundingBox.maxY
								+ 0.5D + this.rand.nextGaussian()
								* 0.12999999523162842D,
						this.posZ + this.rand.nextGaussian()
								* 0.12999999523162842D, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.handleHealthUpdate(p_70103_1_);
		}
	}

	/**
	 * Reduces damage, depending on potions
	 */
	protected float applyPotionDamageCalculations(DamageSource p_70672_1_,
			float p_70672_2_) {
		p_70672_2_ = super
				.applyPotionDamageCalculations(p_70672_1_, p_70672_2_);

		if (p_70672_1_.getEntity() == this) {
			p_70672_2_ = 0.0F;
		}

		if (p_70672_1_.isMagicDamage()) {
			p_70672_2_ = (float) ((double) p_70672_2_ * 0.15D);
		}

		return p_70672_2_;
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(3) + 1;

		for (int k = 0; k < j; ++k) {
			int l = this.rand.nextInt(3);
			Item item = witchDrops[this.rand.nextInt(witchDrops.length)];

			if (p_70628_2_ > 0) {
				l += this.rand.nextInt(p_70628_2_ + 1);
			}

			for (int i1 = 0; i1 < l; ++i1) {
				this.dropItem(item, 1);
			}
		}
	}

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_,
			float p_82196_2_) {
		if (!this.getAggressive()) {
			EntityPotion entitypotion = new EntityPotion(this.worldObj, this,
					32732);
			entitypotion.rotationPitch -= -20.0F;
			double d0 = p_82196_1_.posX + p_82196_1_.motionX - this.posX;
			double d1 = p_82196_1_.posY + (double) p_82196_1_.getEyeHeight()
					- 1.100000023841858D - this.posY;
			double d2 = p_82196_1_.posZ + p_82196_1_.motionZ - this.posZ;
			float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);

			if (f1 >= 8.0F && !p_82196_1_.isPotionActive(Potion.poison)) {
				entitypotion.setPotionDamage(32698);
			} else if (p_82196_1_.getHealth() >= 8.0F
					&& !p_82196_1_.isPotionActive(Potion.moveSlowdown)) {
				entitypotion.setPotionDamage(32660);
			} else if (f1 <= 3.0F
					&& !p_82196_1_.isPotionActive(Potion.weakness)
					&& this.rand.nextFloat() < 0.25F) {
				entitypotion.setPotionDamage(32696);
			}

			entitypotion.setThrowableHeading(d0, d1 + (double) (f1 * 0.2F), d2,
					0.75F, 8.0F);
			this.worldObj.spawnEntityInWorld(entitypotion);
		}
	}

	protected void dropRareDrop(int p_70600_1_) {

		this.entityDropItem(new ItemStack(Items.skull, 1, 1), 0.0F);
	}

	public boolean interact(EntityPlayer p_70085_1_) {
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

		if (itemstack != null
				&& itemstack.getItem() == MinecraftPlus.TransformationWand) {
			if (!this.worldObj.isRemote) {
				itemstack.damageItem(1, this);
				FireMage entitypigzombie = new FireMage(this.worldObj);
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