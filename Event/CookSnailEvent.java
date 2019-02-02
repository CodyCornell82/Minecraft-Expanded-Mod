package com.codycornell82.minecraftPlus.Event;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CookSnailEvent {

	@SubscribeEvent
	public void onSnailCook(PlayerEvent.ItemSmeltedEvent ItemCook) {
		if (ItemCook.smelting.getItem().equals(MinecraftPlus.snailCooked)) {
			ItemCook.player.addStat(MinecraftPlus.Escargot, 1);
		}
	}
}
