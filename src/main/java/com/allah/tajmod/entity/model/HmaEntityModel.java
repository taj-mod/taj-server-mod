// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.17
// Paste this class into your mod and generate all required imports

package com.allah.tajmod.entity.model;

import com.allah.tajmod.entity.HmaEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HmaEntityModel extends AnimatedGeoModel<HmaEntity> {
	@Override
	public Identifier getModelLocation(HmaEntity object)
	{
		return new Identifier("tajmod", "geo/hma.geo.json");
	}

	@Override
	public Identifier getTextureLocation(HmaEntity object)
	{
		return new Identifier("tajmod", "textures/entity/hma/texture.png");
	}
	@Override

	public Identifier getAnimationFileLocation(HmaEntity object)
	{
		return new Identifier("tajmod", "animations/hma.animation.json");
	}
}