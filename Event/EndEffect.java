package com.codycornell82.minecraftPlus.Event;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.block.Block.SoundType;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EndEffect {
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) {
		if (event.entityLiving.isPotionActive(MinecraftPlus.End)) {
			if (event.entityLiving.getActivePotionEffect(MinecraftPlus.End)
					.getDuration() == 0) {
				event.entityLiving.removePotionEffect(MinecraftPlus.End.id);
				return;
			} else if (event.entityLiving.worldObj.rand.nextInt(30) == 0) {
				event.entityLiving.playSound("mob.endermen.hit", 1.0f, 1.0f);
				event.entityLiving.attackEntityFrom(DamageSource.magic, 4);
				event.entityLiving.isSneaking();
				event.entityLiving.motionY = -1;
			}
		}
	}
}
