package com.codycornell82.minecraftPlus.Magic;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class HopMagic extends Enchantment {

	public HopMagic(int id, int Notcommon) {
		super(id, Notcommon, EnumEnchantmentType.armor_feet);
		this.setName("HopMagic");
	}

	public int getMinEnchantability(int e) {
		return 1 + (e - 1) * 10;
	}

	public int getMaxEnchantability(int e) {
		return this.getMinEnchantability(e) + 30;
	}

	public int getMaxLevel() {
		return 10;
	}

}
