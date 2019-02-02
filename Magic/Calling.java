package com.codycornell82.minecraftPlus.Magic;

import java.util.Random;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Calling extends Enchantment {

	public Calling(int id, int Notcommon) {
		super(id, Notcommon, EnumEnchantmentType.weapon);
		this.setName("calling");
	}

	public int getMinEnchantability(int e) {
		return 20 + (e - 1) * 10;
	}

	public int getMaxEnchantability(int e) {
		return this.getMinEnchantability(e) + 30;
	}

	public int getMaxLevel() {
		return 1;
	}

}
