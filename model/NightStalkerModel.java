// Date: 1/16/2017 3:56:44 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class NightStalkerModel extends ModelBase {
	// fields
	ModelRenderer Head;
	ModelRenderer Body;
	ModelRenderer Arm1;
	ModelRenderer Arm2;
	ModelRenderer Claw1;
	ModelRenderer Claw2;
	ModelRenderer Leg1;
	ModelRenderer Leg2;

	public NightStalkerModel() {
		textureWidth = 64;
		textureHeight = 32;

		Head = new ModelRenderer(this, 0, 0);
		Head.addBox(0F, 0F, 0F, 8, 8, 8);
		Head.setRotationPoint(-4F, 0F, -6F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 0, 19);
		Body.addBox(0F, 0F, 0F, 4, 9, 3);
		Body.setRotationPoint(-2F, 8F, -1F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Arm1 = new ModelRenderer(this, 48, 0);
		Arm1.addBox(0F, 0F, 0F, 1, 1, 7);
		Arm1.setRotationPoint(-3F, 10F, -7F);
		Arm1.setTextureSize(64, 32);
		Arm1.mirror = true;
		setRotation(Arm1, 0F, 0F, 0F);
		Arm2 = new ModelRenderer(this, 48, 0);
		Arm2.addBox(0F, 0F, 0F, 1, 1, 7);
		Arm2.setRotationPoint(2F, 10F, -7F);
		Arm2.setTextureSize(64, 32);
		Arm2.mirror = true;
		setRotation(Arm2, 0F, 0F, 0F);
		Claw1 = new ModelRenderer(this, 39, 0);
		Claw1.addBox(0F, 0F, 0F, 1, 2, 0);
		Claw1.setRotationPoint(-3F, 10F, -7.01F);
		Claw1.setTextureSize(64, 32);
		Claw1.mirror = true;
		setRotation(Claw1, 0F, 0F, 0F);
		Claw2 = new ModelRenderer(this, 39, 0);
		Claw2.addBox(0F, 0F, 0F, 1, 2, 0);
		Claw2.setRotationPoint(2F, 10F, -7.01F);
		Claw2.setTextureSize(64, 32);
		Claw2.mirror = true;
		setRotation(Claw2, 0F, 0F, 0F);
		Leg1 = new ModelRenderer(this, 34, 0);
		Leg1.addBox(0F, 0F, 0F, 1, 8, 1);
		Leg1.setRotationPoint(2F, 16F, 0F);
		Leg1.setTextureSize(64, 32);
		Leg1.mirror = true;
		setRotation(Leg1, 0F, 0F, 0F);
		Leg2 = new ModelRenderer(this, 34, 0);
		Leg2.addBox(0F, 0F, 0F, 1, 8, 1);
		Leg2.setRotationPoint(-3F, 16F, 0F);
		Leg2.setTextureSize(64, 32);
		Leg2.mirror = true;
		setRotation(Leg2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Head.render(f5);
		Body.render(f5);
		Arm1.render(f5);
		Arm2.render(f5);
		Claw1.render(f5);
		Claw2.render(f5);
		Leg1.render(f5);
		Leg2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* 1.4F * f1;
		this.Leg1.rotateAngleY = 0.0F;
		this.Leg2.rotateAngleY = 0.0F;

	}

}
