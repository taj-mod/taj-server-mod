// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.17
// Paste this class into your mod and generate all required imports

package com.allah.tajmod.entity.model;

import com.allah.tajmod.entity.HmaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class HmaEntityModel extends EntityModel<HmaEntity> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart headwear;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public HmaEntityModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.headwear = root.getChild("headwear");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}

	public static ModelData getModelData(){
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, 0.0F, -2.0F, 6.0F, 23.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -15.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(20, 25).cuboid(-3.0F, -10.0F, -4.0F, 6.0F, 1.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 0).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
		.uv(40, 17).cuboid(-5.0F, -8.0F, -4.0F, 1.0F, 6.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
		.uv(32, 0).cuboid(4.0F, -8.0F, -4.0F, 1.0F, 6.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
		.uv(20, 16).cuboid(-3.0F, -1.0F, -4.0F, 6.0F, 1.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -15.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData headwear = modelPartData.addChild("headwear", ModelPartBuilder.create().uv(0, 16).cuboid(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, new Dilation(-0.5F)).mirrored(false)
		.uv(0, 16).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(-0.5F)).mirrored(false), ModelTransform.of(0.0F, -15.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(30, 34).cuboid(7.0F, 0.0F, -1.0F, 3.0F, 22.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.0F, -13.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(20, 34).cuboid(-2.0F, 0.0F, -1.0F, 3.0F, 22.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.0F, -14.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(0, 43).cuboid(-6.0F, 14.0F, -1.0F, 3.0F, 16.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(40, 34).cuboid(3.0F, 14.0F, -1.0F, 3.0F, 16.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
		return modelData;
	}


	public static TexturedModelData getTexturedModelData() {
		return TexturedModelData.of(getModelData(), 64, 64);
	}

	@Override
	public void setAngles(HmaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}
	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		headwear.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}
	
}