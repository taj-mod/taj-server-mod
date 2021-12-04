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
	private final ModelPart leftfinger;
	private final ModelPart left_arm;
	private final ModelPart right_arm4;
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	private final ModelPart rightfinger;

	public HmaEntityModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.leftfinger = root.getChild("leftfinger");
		this.left_arm = root.getChild("left_arm");
		this.right_arm4 = root.getChild("right_arm4");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
		this.rightfinger = root.getChild("rightfinger");

	}

	public static ModelData getModelData(){
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, -10.0F, -2.0F, 6.0F, 28.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -15.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(20, 25).cuboid(-4.0F, -16.0F, -4.0F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 0).cuboid(-5.0F, -15.0F, -4.0F, 10.0F, 10.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
				.uv(40, 17).cuboid(-6.0F, -14.0F, -4.0F, 1.0F, 8.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
				.uv(32, 0).cuboid(5.0F, -14.0F, -4.0F, 1.0F, 8.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
				.uv(20, 16).cuboid(-4.0F, -5.0F, -4.0F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -21.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData leftfinger = modelPartData.addChild("leftfinger", ModelPartBuilder.create(), ModelTransform.of(0.0F, 25.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData fingers = leftfinger.addChild("fingers", ModelPartBuilder.create().uv(0, 0).cuboid(-1.1364F, 12.0022F, -0.0545F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 0).cuboid(0.8636F, 12.0022F, -0.0545F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(6.0F, -39.0F, -1.0F, -0.0121F, -0.0434F, 0.0273F));

		ModelPartData fingers2 = leftfinger.addChild("fingers2", ModelPartBuilder.create().uv(0, 0).cuboid(8.2181F, -21.9952F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.0F, -5.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.of(-6.0F, -10.0F, -1.0F, 0.0F, 0.0F, -0.1309F));

		ModelPartData left_arm1 = left_arm.addChild("left_arm1", ModelPartBuilder.create().uv(30, 34).cuboid(10.231F, -9.6529F, 0.0F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		ModelPartData left_arm2 = left_arm.addChild("left_arm2", ModelPartBuilder.create().uv(30, 34).cuboid(11.1736F, -4.9116F, 0.0F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData left_arm3 = left_arm.addChild("left_arm3", ModelPartBuilder.create().uv(30, 34).cuboid(10.5209F, 3.0456F, 0.0F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		ModelPartData right_arm4 = modelPartData.addChild("right_arm4", ModelPartBuilder.create(), ModelTransform.of(6.0F, -10.0F, -1.0F, 0.0F, 0.0F, 0.1309F));

		ModelPartData right_arm5 = right_arm4.addChild("right_arm5", ModelPartBuilder.create().uv(30, 34).cuboid(-13.231F, -9.6529F, 0.0F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)).mirrored(true), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		ModelPartData right_arm6 = right_arm4.addChild("right_arm6", ModelPartBuilder.create().uv(30, 34).cuboid(-14.1736F, -4.9116F, 0.0F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)).mirrored(true), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData right_arm7 = right_arm4.addChild("right_arm7", ModelPartBuilder.create().uv(30, 34).cuboid(-13.5209F, 3.0456F, 0.0F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)).mirrored(true), ModelTransform.of(-1.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(0, 43).cuboid(-6.0F, 9.0F, -1.0F, 3.0F, 21.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(40, 34).cuboid(3.0F, 9.0F, -1.0F, 3.0F, 21.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData rightfinger = modelPartData.addChild("rightfinger", ModelPartBuilder.create(), ModelTransform.of(11.0F, 25.0F, 4.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData fingers3 = rightfinger.addChild("fingers3", ModelPartBuilder.create().uv(0, 0).cuboid(0.1364F, 12.0022F, -0.0545F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 0).cuboid(-1.8636F, 12.0022F, -0.0545F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-17.0F, -39.0F, -5.0F, -0.0121F, 0.0434F, -0.0273F));

		ModelPartData fingers4 = rightfinger.addChild("fingers4", ModelPartBuilder.create().uv(0, 0).cuboid(-9.2181F, -21.9952F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-12.0F, -5.0F, -4.0F, 0.0F, 0.0F, 0.0436F));
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
		leftfinger.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		right_arm4.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightfinger.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}
	
}