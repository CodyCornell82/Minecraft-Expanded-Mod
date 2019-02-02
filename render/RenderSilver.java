package com.codycornell82.minecraftPlus.render;

import model.ModelRobot;
import model.ModelSnail;
import model.TheSilverModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.codycornell82.minecraftPlus.MobHandler.Robot;
import com.codycornell82.minecraftPlus.MobHandler.Silver;

public class RenderSilver extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("mp:"
			+ "textures/model/TheSilverTexture.png");

	protected TheSilverModel modelEntity;

	public RenderSilver(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);

		modelEntity = ((TheSilverModel) mainModel);
	}

	public void renderRobot(Silver entity, double x, double y, double z,
			float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving liveMob, double x, double y,
			double z, float u, float v) {
		renderRobot((Silver) liveMob, x, y, z, u, v);
	}

	public void doRender(Entity entity, double x, double y, double z, float u,
			float v) {
		renderRobot((Silver) entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {

		return texture;
	}
}
