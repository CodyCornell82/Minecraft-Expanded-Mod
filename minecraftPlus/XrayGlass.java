package com.codycornell82.minecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class XrayGlass extends Block {

	protected XrayGlass(Material material) {
		super(material);
		this.setResistance(3.0f);
		this.setHardness(1.0f);
		this.setHarvestLevel("pickaxe", 0);
	}

}
