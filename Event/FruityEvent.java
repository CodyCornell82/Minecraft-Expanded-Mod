package com.codycornell82.minecraftPlus.Event;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class FruityEvent {

	@SubscribeEvent
	public void onBerryCraft(PlayerEvent.ItemCraftedEvent ItemCraft) {
		if (ItemCraft.crafting.getItem().equals(MinecraftPlus.FruitJuice)) {
			ItemCraft.player.addStat(MinecraftPlus.Fruity, 1);
		}
	}
}
