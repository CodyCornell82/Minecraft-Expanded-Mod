package com.codycornell82.minecraftPlus;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MPCrop extends BlockCrops {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public IIcon getIcon(int side, int metadata) {
		if (metadata < 7) {
			if (metadata == 6) {
				metadata = 5;
			}
			return this.iconArray[metadata >> 1];
		}
		return this.iconArray[3];
	}

	public int quantityDropped(Random rand) {
		return 0 + rand.nextInt(4);
	}

	protected Item func_149866_i() {
		return MinecraftPlus.woodrootSeed;
	}

	protected Item func_149865_P() {
		return MinecraftPlus.woodroot;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iconArray = new IIcon[4];

		for (int i = 0; i < this.iconArray.length; i++) {
			this.iconArray[i] = iconRegister.registerIcon("mp:woodrootPlant"
					+ i);
		}
	}
}
