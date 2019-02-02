package com.codycornell82.minecraftPlus.render;

import com.codycornell82.minecraftPlus.MobHandler.TameMonsterClass;

import model.TameMonster;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderTameMonster extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("mp:"
			+ "textures/model/TameMonster.png");

	protected TameMonster modelEntity;

	public RenderTameMonster(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);

		modelEntity = ((TameMonster) mainModel);
	}

	public void renderTameMonster(TameMonsterClass entity, double x, double y,
			double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving liveMob, double x, double y,
			double z, float u, float v) {
		renderTameMonster((TameMonsterClass) liveMob, x, y, z, u, v);
	}

	public void doRender(Entity entity, double x, double y, double z, float u,
			float v) {
		renderTameMonster((TameMonsterClass) entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {

		return texture;
	}
}
