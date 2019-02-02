package com.codycornell82.minecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class lampUnlit extends Block {

	protected lampUnlit(Material material) {
		super(material);
		this.setStepSound(soundTypeCloth);
		this.setHardness(1.0f);
	}

}
