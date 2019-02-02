package com.codycornell82.minecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Dust extends Block {

	protected Dust(Material material) {
		super(material);
		this.setStepSound(soundTypeSand);
		this.setHardness(1.0f);
	}

}
