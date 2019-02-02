package com.codycornell82.minecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ToxicBlock extends Block {

	protected ToxicBlock(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setResistance(15.0f);
		this.setHardness(2.0f);

	}

	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(
				MinecraftPlus.Toxic.id, 300, 1, false));
		super.onEntityWalking(world, x, y, z, entity);
	}
}
