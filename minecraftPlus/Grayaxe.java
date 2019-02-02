package com.codycornell82.minecraftPlus;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Grayaxe extends ItemAxe {

	protected Grayaxe(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);

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
}
