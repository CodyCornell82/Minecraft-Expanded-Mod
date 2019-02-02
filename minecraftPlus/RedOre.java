package com.codycornell82.minecraftPlus;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class RedOre extends Block {
	protected RedOre(Material material) {
		super(material);
		this.setResistance(15.0f);
		this.setHardness(2.0f);
		this.setHarvestLevel("pickaxe", 2);
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return MinecraftPlus.RedQuartz;
	}

	@Override
	public int quantityDropped(Random rand) {
		return 2 + rand.nextInt(5);
	}
}
