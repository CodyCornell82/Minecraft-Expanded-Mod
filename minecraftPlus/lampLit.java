package com.codycornell82.minecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class lampLit extends Block {

	protected lampLit(Material material) {
		super(material);
		this.setStepSound(soundTypeCloth);
		this.setHardness(1.0f);
		this.setLightLevel(0.9375F);
	}

}
