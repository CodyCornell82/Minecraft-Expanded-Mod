package com.codycornell82.minecraftPlus;

import com.codycornell82.minecraftPlus.MobHandler.CallerBoss;
import com.codycornell82.minecraftPlus.MobHandler.FireZombie;
import com.codycornell82.minecraftPlus.MobHandler.SpawnBoss;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class MakeSpawn extends Block {

	protected MakeSpawn(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setStepSound(soundTypeStone);
	}

	public void onBlockDestroyedByPlayer(World p_149664_1_, int p_149664_2_,
			int p_149664_3_, int p_149664_4_, int p_149664_5_) {
		if (!p_149664_1_.isRemote) {
			SpawnBoss entitysilverfish = new SpawnBoss(p_149664_1_);
			entitysilverfish.setLocationAndAngles((double) p_149664_2_ + 0.5D,
					(double) p_149664_3_, (double) p_149664_4_ + 0.5D, 0.0F,
					0.0F);
			p_149664_1_.spawnEntityInWorld(entitysilverfish);
			entitysilverfish.spawnExplosionParticle();
			entitysilverfish.playSound("mob.blaze.breathe", 1.0f, 1.0f);
		}

		super.onBlockDestroyedByPlayer(p_149664_1_, p_149664_2_, p_149664_3_,
				p_149664_4_, p_149664_5_);
	}

}
