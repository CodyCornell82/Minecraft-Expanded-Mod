package com.codycornell82.minecraftPlus;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class DestroyerArmor extends ItemArmor {

	public DestroyerArmor(ArmorMaterial armorMat, int rederIndex, int i) {
		super(armorMat, rederIndex, i);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		if (this.armorType == 2) {
			return "mp:textures/models/armor/New_layer_2.png";
		}
		return "mp:textures/models/armor/New_layer_1.png";
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		int j = EnchantmentHelper.getEnchantmentLevel(
				MinecraftPlus.nullFire.effectId, stack);
		int k = EnchantmentHelper.getEnchantmentLevel(
				MinecraftPlus.hopMagic.effectId, stack);
		int i = EnchantmentHelper.getEnchantmentLevel(
				MinecraftPlus.speedMagic.effectId, stack);

		if (j > 0) {
			player.addPotionEffect(new PotionEffect(Potion.fireResistance
					.getId(), 25, j - 1, true));
			player.extinguish();
		}
		if (k > 0) {
			player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 25,
					k - 1, true));

		}
		if (i > 0) {
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),
					25, i - 1, true));

		}
	}

}
