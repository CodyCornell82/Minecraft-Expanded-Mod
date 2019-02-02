package com.codycornell82.minecraftPlus;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class ToxicEffect extends Potion {
	public static final ResourceLocation icon = new ResourceLocation(
			"mp:textures/gui/effect.png");

	public ToxicEffect(int id, boolean bad, int amp) {
		super(id, bad, amp);
	}

	public Potion setIconIndex(int x, int y) {
		super.setIconIndex(x, y);
		return (Potion) this;
	}

	public int getStatusIconIndex() {
		ITextureObject texture = Minecraft.getMinecraft().renderEngine
				.getTexture(icon);
		Minecraft.getMinecraft().renderEngine.bindTexture(icon);
		return super.getStatusIconIndex();
	}

	public boolean isBadEffect() {
		return true;
	}
}
