package com.codycornell82.minecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLeafBlocks extends ItemBlock {

	public static final String[] leaves = new String[] { "SilverWood" };

	public ItemLeafBlocks(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack stack) {
		int i = stack.getItemDamage();
		if (i < 0 || i >= leaves.length) {
			i = 0;
		}
		return this.getUnlocalizedName() + "." + leaves[i];
	}

	public int getMetadata(int meta) {
		return meta;
	}
}
