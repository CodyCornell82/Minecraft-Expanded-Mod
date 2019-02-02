package com.codycornell82.minecraftPlus.Event;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class Achievements2 {

	@SubscribeEvent
	public void onToxiGemFound(PlayerEvent.ItemPickupEvent ItemPickup) {
		if (ItemPickup.pickedUp.getEntityItem().isItemEqual(
				new ItemStack(MinecraftPlus.ToxicGem))) {
			ItemPickup.player.addStat(MinecraftPlus.ToxicFumes, 1);
		}
	}

	@SubscribeEvent
	public void onToxicSwordCraft(PlayerEvent.ItemCraftedEvent ItemCraft) {
		if (ItemCraft.crafting.getItem().equals(MinecraftPlus.ToxicSword)) {
			ItemCraft.player.addStat(MinecraftPlus.ToxicAttack, 1);
		}
	}

	@SubscribeEvent
	public void onFuelCraft(PlayerEvent.ItemCraftedEvent ItemCraft) {
		if (ItemCraft.crafting.getItem().equals(MinecraftPlus.fuelCan)) {
			ItemCraft.player.addStat(MinecraftPlus.FuelTheFire, 1);
		}
	}

	@SubscribeEvent
	public void onSilverCook(PlayerEvent.ItemSmeltedEvent ItemCook) {
		if (ItemCook.smelting.getItem().equals(MinecraftPlus.SilverIngot)) {
			ItemCook.player.addStat(MinecraftPlus.Shiny, 1);
		}
	}

	@SubscribeEvent
	public void onDestroyerDropped(PlayerEvent.ItemPickupEvent ItemPickup) {
		if (ItemPickup.pickedUp.getEntityItem().isItemEqual(
				new ItemStack(MinecraftPlus.SwordNew))) {
			ItemPickup.player.addStat(MinecraftPlus.OP, 1);
		}
	}

	@SubscribeEvent
	public void onSeedFound(PlayerEvent.ItemPickupEvent ItemPickup) {
		if (ItemPickup.pickedUp.getEntityItem().isItemEqual(
				new ItemStack(MinecraftPlus.berrySeed))) {
			ItemPickup.player.addStat(MinecraftPlus.MotherNaturesSon, 1);
		}
	}

	@SubscribeEvent
	public void onCakeMade(PlayerEvent.ItemCraftedEvent ItemCraft) {
		if (ItemCraft.crafting.getItem().equals(MinecraftPlus.FruitCake)) {
			ItemCraft.player.addStat(MinecraftPlus.Lie2, 1);
		}
	}

	@SubscribeEvent
	public void onInfernoDropped(PlayerEvent.ItemPickupEvent ItemPickup) {
		if (ItemPickup.pickedUp.getEntityItem().isItemEqual(
				new ItemStack(MinecraftPlus.FireSword))) {
			ItemPickup.player.addStat(MinecraftPlus.Inferno, 1);
		}
	}

	@SubscribeEvent
	public void onCureMade(PlayerEvent.ItemCraftedEvent ItemCraft) {
		if (ItemCraft.crafting.getItem().equals(MinecraftPlus.CureStone)) {
			ItemCraft.player.addStat(MinecraftPlus.Cure, 1);
		}
	}

	@SubscribeEvent
	public void onSteelDropped(PlayerEvent.ItemPickupEvent ItemPickup) {
		if (ItemPickup.pickedUp.getEntityItem().isItemEqual(
				new ItemStack(MinecraftPlus.steel))) {
			ItemPickup.player.addStat(MinecraftPlus.HeavyMetal, 1);
		}

	}

	@SubscribeEvent
	public void onPowderMade(PlayerEvent.ItemCraftedEvent ItemCraft) {
		if (ItemCraft.crafting.getItem().equals(MinecraftPlus.Powder)) {
			ItemCraft.player.addStat(MinecraftPlus.WhatKindOfBlackMagicIsThis,
					1);
		}
	}
}
