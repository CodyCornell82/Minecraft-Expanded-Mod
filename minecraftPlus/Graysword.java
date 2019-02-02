package com.codycornell82.minecraftPlus;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Graysword extends ItemSword {

	public Graysword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);

	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4,
			boolean par5) {
		super.onUpdate(stack, world, entity, par4, par5);

		{
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack equipped = player.getCurrentEquippedItem();
			if (equipped == stack) {
				player.addPotionEffect(new PotionEffect(Potion.jump.getId(),
						25, 1, true));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed
						.getId(), 25, 4, true));
			}
		}
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
