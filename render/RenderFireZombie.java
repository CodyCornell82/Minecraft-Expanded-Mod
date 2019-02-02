package com.codycornell82.minecraftPlus.render;

import model.ModelRobot;
import model.ZombieModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.codycornell82.minecraftPlus.MobHandler.FireZombie;
import com.codycornell82.minecraftPlus.MobHandler.Robot;

public class RenderFireZombie extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("mp:"
			+ "textures/model/FireZombie.png");

	protected ZombieModel modelEntity;

	public RenderFireZombie(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);

		modelEntity = ((ZombieModel) mainModel);
	}

	public void renderFireZombie(FireZombie entity, double x, double y,
			double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving liveMob, double x, double y,
			double z, float u, float v) {
		renderFireZombie((FireZombie) liveMob, x, y, z, u, v);
	}

	public void doRender(Entity entity, double x, double y, double z, float u,
			float v) {
		renderFireZombie((FireZombie) entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {

		return texture;
	}
}
