package com.codycornell82.minecraftPlus.Event;

import ibxm.Player;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.block.Block.SoundType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PotionEvent {
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) {
		if (event.entityLiving.isPotionActive(MinecraftPlus.Toxic)) {
			if (event.entityLiving.getActivePotionEffect(MinecraftPlus.Toxic)
					.getDuration() == 0) {
				event.entityLiving.removePotionEffect(MinecraftPlus.Toxic.id);
				return;
			} else if (event.entityLiving.worldObj.rand.nextInt(30) == 0) {
				event.entityLiving.attackEntityFrom(DamageSource.generic, 2);
				event.entityLiving.playSound("mob.blaze.breathe", 1.0f, 1.0f);
			}
		}
	}
}
