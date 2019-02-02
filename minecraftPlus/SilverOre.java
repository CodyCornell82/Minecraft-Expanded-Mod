package com.codycornell82.minecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SilverOre extends Block {
	protected SilverOre(Material material) {
		super(material);
		this.setResistance(15.0f);
		this.setHardness(2.0f);
		this.setHarvestLevel("pickaxe", 2);
	}

}
