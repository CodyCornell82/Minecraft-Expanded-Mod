package com.codycornell82.minecraftPlus.MobHandler;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FireMage extends EntityMob {

	private int field_70846_g;
	private static final String __OBFID = "CL_00001682";

	public FireMage(World p_i1731_1_) {
		super(p_i1731_1_);
		this.isImmuneToFire = true;
		this.experienceValue = 10;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(3.0D);
		this.isImmuneToFire = true;
		this.experienceValue = 10;
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 0));
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

	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender(float p_70070_1_) {
		return 15728880;
	}

	/**
	 * Gets how bright this entity is.
	 */
	public float getBrightness(float p_70013_1_) {
		return 1.0F;
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
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
			this.worldObj.spawnParticle("largesmoke",
					this.posX + (this.rand.nextDouble() - 0.5D)
							* (double) this.width,
					this.posY + this.rand.nextDouble() * (double) this.height,
					this.posZ + (this.rand.nextDouble() - 0.5D)
							* (double) this.width, 0.0D, 0.0D, 0.0D);
		}

		super.onLivingUpdate();
	}

	public void onDeath(DamageSource p_70645_1_) {
		super.onDeath(p_70645_1_);

		if (p_70645_1_.getSourceOfDamage() instanceof EntityArrow
				&& p_70645_1_.getEntity() instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) p_70645_1_.getEntity();
			double d0 = entityplayer.posX - this.posX;
			double d1 = entityplayer.posZ - this.posZ;

			if (d0 * d0 + d1 * d1 >= 2500.0D) {
				entityplayer.triggerAchievement(AchievementList.snipeSkeleton);
			}
		}
	}

	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden
	 * by each mob to define their attack.
	 */
	protected void attackEntity(Entity p_70785_1_, float p_70785_2_) {
		if (this.attackTime <= 0 && p_70785_2_ < 2.0F
				&& p_70785_1_.boundingBox.maxY > this.boundingBox.minY
				&& p_70785_1_.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 20;
			this.attackEntityAsMob(p_70785_1_);
		} else if (p_70785_2_ < 30.0F) {
			double d0 = p_70785_1_.posX - this.posX;
			double d1 = p_70785_1_.boundingBox.minY
					+ (double) (p_70785_1_.height / 2.0F)
					- (this.posY + (double) (this.height / 2.0F));
			double d2 = p_70785_1_.posZ - this.posZ;

			if (this.attackTime == 0) {
				++this.field_70846_g;

				if (this.field_70846_g == 1) {
					this.attackTime = 60;
					this.func_70844_e(true);
				} else if (this.field_70846_g <= 4) {
					this.attackTime = 6;
				} else {
					this.attackTime = 100;
					this.field_70846_g = 0;
					this.func_70844_e(false);
				}

				if (this.field_70846_g > 1) {
					float f1 = MathHelper.sqrt_float(p_70785_2_) * 0.5F;
					this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1009,
							(int) this.posX, (int) this.posY, (int) this.posZ,
							0);

					for (int i = 0; i < 1; ++i) {
						EntitySmallFireball entitysmallfireball = new EntitySmallFireball(
								this.worldObj, this, d0
										+ this.rand.nextGaussian()
										* (double) f1, d1, d2
										+ this.rand.nextGaussian()
										* (double) f1);
						entitysmallfireball.posY = this.posY
								+ (double) (this.height / 2.0F) + 0.5D;
						this.worldObj.spawnEntityInWorld(entitysmallfireball);
					}
				}
			}

			this.rotationYaw = (float) (Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
			this.hasAttacked = true;
		}
	}

	protected Item getDropItem() {
		return Items.bone;
	}

	/**
	 * Returns true if the entity is on fire. Used by render to add the fire
	 * effect on rendering.
	 */
	public boolean isBurning() {
		return this.func_70845_n();
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j;
		int k;

		j = this.rand.nextInt(3 + p_70628_2_) - 1;

		for (k = 0; k < j; ++k) {
			this.dropItem(Items.coal, 1);
		}

		{
			j = this.rand.nextInt(3 + p_70628_2_);

			for (k = 0; k < j; ++k) {
				this.dropItem(Items.blaze_powder, 1);
			}
		}

		j = this.rand.nextInt(3 + p_70628_2_);

		for (k = 0; k < j; ++k) {
			this.dropItem(Items.bone, 1);
		}
	}

	protected void dropRareDrop(int p_70600_1_) {

		this.entityDropItem(new ItemStack(Items.skull, 1, 1), 0.0F);
	}

	public boolean func_70845_n() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	public void func_70844_e(boolean p_70844_1_) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (p_70844_1_) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 &= -2;
		}

		this.dataWatcher.updateObject(16, Byte.valueOf(b0));
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	public boolean interact(EntityPlayer p_70085_1_) {
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

		if (itemstack != null
				&& itemstack.getItem() == MinecraftPlus.TransformationWand) {
			if (!this.worldObj.isRemote) {
				itemstack.damageItem(1, this);
				EntitySkeleton entitypigzombie = new EntitySkeleton(
						this.worldObj);
				entitypigzombie.setLocationAndAngles(this.posX, this.posY,
						this.posZ, this.rotationYaw, this.rotationPitch);
				this.worldObj.spawnEntityInWorld(entitypigzombie);
				this.playSound("random.fizz", 1.0f, 1.0f);
				p_70085_1_.triggerAchievement(MinecraftPlus.ItJustChanged);
				p_70085_1_.triggerAchievement(MinecraftPlus.Firewatch);
				this.setDead();
			}
		} else {
			return super.interact(p_70085_1_);
		}
		return true;
	}
}