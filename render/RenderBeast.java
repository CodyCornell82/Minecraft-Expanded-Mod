package com.codycornell82.minecraftPlus.render;

import model.BeastModel;
import model.ModelCaller;
import model.ModelRobot;
import model.ModelSnail;
import model.ToxicMobModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.codycornell82.minecraftPlus.MobHandler.BeastAI;
import com.codycornell82.minecraftPlus.MobHandler.CallerBoss;
import com.codycornell82.minecraftPlus.MobHandler.Robot;
import com.codycornell82.minecraftPlus.MobHandler.ToxicMob;

public class RenderBeast extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("mp:"
			+ "textures/model/BeastTexture.png");

	protected BeastModel modelEntity;

	public RenderBeast(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);

		modelEntity = ((BeastModel) mainModel);
	}

	public void renderRobot(BeastAI entity, double x, double y, double z,
			float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving liveMob, double x, double y,
			double z, float u, float v) {
		renderRobot((BeastAI) liveMob, x, y, z, u, v);
	}

	public void doRender(Entity entity, double x, double y, double z, float u,
			float v) {
		renderRobot((BeastAI) entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {

		return texture;
	}
}
