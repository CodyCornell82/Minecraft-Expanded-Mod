package com.codycornell82.minecraftPlus.Event;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class FindBerryEvent {

	@SubscribeEvent
	public void onBerryFound(PlayerEvent.ItemPickupEvent ItemPickup) {
		if (ItemPickup.pickedUp.getEntityItem().isItemEqual(
				new ItemStack(MinecraftPlus.berry))) {
			ItemPickup.player.addStat(MinecraftPlus.BarryAllen, 1);
		}
	}
}
