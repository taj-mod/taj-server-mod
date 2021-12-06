package com.allah.tajmod.entity.renderer;

import com.allah.tajmod.entity.HmaEntity;
import com.allah.tajmod.entity.model.HmaEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HmaEntityRenderer extends GeoEntityRenderer<HmaEntity> {
    public HmaEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new HmaEntityModel());
        this.shadowRadius = 0.8F; //change 0.7 to the desired shadow size.
    }
}