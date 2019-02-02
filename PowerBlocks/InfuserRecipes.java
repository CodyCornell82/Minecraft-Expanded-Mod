package com.codycornell82.minecraftPlus.PowerBlocks;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfuserRecipes {

	public InfuserRecipes() {

	}

	public static ItemStack getInfuserRusult(Item item, Item item2) {
		return getOutput(item, item2);
	}

	public static ItemStack getOutput(Item item, Item item2) {
		if (item == Items.coal && item2 == Items.iron_ingot
				|| item == Items.iron_ingot && item2 == Items.coal) {
			return new ItemStack(MinecraftPlus.steel, 2);
		}
		if (item == MinecraftPlus.CobaltBar && item2 == MinecraftPlus.FarBar
				|| item == MinecraftPlus.FarBar
				&& item2 == MinecraftPlus.CobaltBar) {
			return new ItemStack(MinecraftPlus.Visber, 2);
		}
		return null;

	}

}
