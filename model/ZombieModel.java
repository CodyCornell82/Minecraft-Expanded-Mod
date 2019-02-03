package model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ZombieModel extends ModelZombie {

	public ZombieModel() {
		this(0.0F);
	}

	public ZombieModel(float p_i1156_1_) {
		super(p_i1156_1_, 0.0F, 64, 32);

		textureWidth = 64;
		textureHeight = 32;

		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8);
		this.bipedHead.setRotationPoint(0F, 0F, 0F);
		this.bipedHead.setTextureSize(64, 32);
		this.bipedHead.mirror = true;

		this.bipedBody = new ModelRenderer(this, 16, 16);
		this.bipedBody.addBox(-4F, 0F, -2F, 8, 12, 4);
		this.bipedBody.setRotationPoint(0F, 0F, 0F);
		this.bipedBody.setTextureSize(64, 32);
		this.bipedBody.mirror = true;

		this.bipedRightArm = new ModelRenderer(this, 40, 16);
		this.bipedRightArm.addBox(-3F, -2F, -2F, 4, 12, 4);
		this.bipedRightArm.setRotationPoint(-5F, 2F, 0F);
		this.bipedRightArm.setTextureSize(64, 32);
		this.bipedRightArm.mirror = true;

		this.bipedLeftArm = new ModelRenderer(this, 40, 16);
		this.bipedLeftArm.addBox(-1F, -2F, -2F, 4, 12, 4);
		this.bipedLeftArm.setRotationPoint(5F, 2F, 0F);
		this.bipedLeftArm.setTextureSize(64, 32);
		this.bipedLeftArm.mirror = true;
		this.bipedRightLeg = new ModelRenderer(this, 0, 16);
		this.bipedRightLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
		this.bipedRightLeg.setRotationPoint(-2F, 12F, 0F);
		this.bipedRightLeg.setTextureSize(64, 32);
		this.bipedRightLeg.mirror = true;

		this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
		this.bipedLeftLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
		this.bipedLeftLeg.setRotationPoint(2F, 12F, 0F);
		this.bipedLeftLeg.setTextureSize(64, 32);
		this.bipedLeftLeg.mirror = true;

	}

	public void setLivingAnimations(EntityLivingBase p_78086_1_,
			float p_78086_2_, float p_78086_3_, float p_78086_4_) {
		super.setLivingAnimations(p_78086_1_, p_78086_2_, p_78086_3_,
				p_78086_4_);
	}

	public void setRotationAngles(float p_78087_1_, float p_78087_2_,
			float p_78087_3_, float p_78087_4_, float p_78087_5_,
			float p_78087_6_, Entity p_78087_7_) {
		super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_,
				p_78087_5_, p_78087_6_, p_78087_7_);
	}

}
