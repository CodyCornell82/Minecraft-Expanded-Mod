package com.codycornell82.minecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockLogs extends ItemBlock {
	public static final String[] logs = new String[] { "SilverWood" };

	public ItemBlockLogs(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack stack) {
		int i = stack.getItemDamage();
		if (i < 0 || i >= logs.length) {
			i = 0;
		}
		return this.getUnlocalizedName() + "." + logs[i];
	}

	public int getMetadata(int meta) {
		return meta;
	}
}
