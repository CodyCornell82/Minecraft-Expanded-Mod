package com.codycornell82.minecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemSaplingBlock extends ItemBlockWithMetadata {

	public static final String[] saplings = new String[] { "SilverWood" };

	public ItemSaplingBlock(Block block) {
		super(block, block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack stack) {
		int i = stack.getItemDamage();
		if (i < 0 || i >= saplings.length) {
			i = 0;
		}
		return this.getUnlocalizedName() + "." + saplings[i];
	}

	public int getMetadata(int meta) {
		return meta;
	}
}