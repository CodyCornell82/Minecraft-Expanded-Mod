package com.codycornell82.minecraftPlus.Event;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class FindSeedsEvent {

	@SubscribeEvent
	public void onSeedFound(PlayerEvent.ItemPickupEvent ItemPickup) {
		if (ItemPickup.pickedUp.getEntityItem().isItemEqual(
				new ItemStack(MinecraftPlus.woodrootSeed))) {
			ItemPickup.player.addStat(MinecraftPlus.ThatsAStart, 1);
		} else if (ItemPickup.pickedUp.getEntityItem().isItemEqual(
				new ItemStack(MinecraftPlus.woodroot))) {
			ItemPickup.player.addStat(MinecraftPlus.Harvest, 1);
		}
	}

	@SubscribeEvent
	public void onStewCraft(PlayerEvent.ItemCraftedEvent ItemCraft) {
		if (ItemCraft.crafting.getItem().equals(MinecraftPlus.woodrootSoup)) {
			ItemCraft.player.addStat(MinecraftPlus.Dinner, 1);
		}
	}
}
