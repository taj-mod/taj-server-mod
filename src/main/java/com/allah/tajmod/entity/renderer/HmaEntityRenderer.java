package com.allah.tajmod.entity.renderer;

import com.allah.tajmod.ClientInitializer;
import com.allah.tajmod.entity.HmaEntity;
import com.allah.tajmod.entity.model.HmaEntityModel;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class HmaEntityRenderer extends MobEntityRenderer<HmaEntity, HmaEntityModel> {
    public HmaEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new HmaEntityModel(context.getPart(ClientInitializer.MODEL_HMA_LAYER)), 0.5f);    }

    @Override
    public Identifier getTexture(HmaEntity entity) {
        return new Identifier("tajmod", "textures/entity/hma/texture.png");
    }
}
