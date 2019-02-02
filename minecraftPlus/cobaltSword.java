package com.codycornell82.minecraftPlus;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class cobaltSword extends ItemSword {

	public cobaltSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);

	}
	public boolean hitEntity(ItemStack stack, EntityLivingBase target,
			EntityLivingBase attacker) {
		
		int j = EnchantmentHelper.getEnchantmentLevel(
				MinecraftPlus.withering.effectId, stack);
		int k = EnchantmentHelper.getEnchantmentLevel(
				MinecraftPlus.calling.effectId, stack);
		int i = EnchantmentHelper.getEnchantmentLevel(
				MinecraftPlus.eldersvoid.effectId, stack);
		int l = EnchantmentHelper.getEnchantmentLevel(
				MinecraftPlus.toxicMagic.effectId, stack);


		if (j > 0) {
			target.addPotionEffect(new PotionEffect(Potion.wither
					.getId(), 60 + j*4, j - 1, false));
		}
		if (k > 0) {
			target.addPotionEffect(new PotionEffect(MinecraftPlus.End
					.getId(), 60 + j*4, j - 1, false));
		}
		if (i > 0) {
			target.addPotionEffect(new PotionEffect(MinecraftPlus.Jump
					.getId(), 60 + j*4, j - 1, false));
		}
		if (l > 0) {
			target.addPotionEffect(new PotionEffect(MinecraftPlus.Toxic
					.getId(), 60 + j*4, j - 1, false));
		}
		return true;
	}

}
