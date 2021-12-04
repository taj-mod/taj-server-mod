package com.allah.tajmod;

import com.allah.tajmod.entity.renderer.HmaEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ClientInitializer implements ClientModInitializer {
    public static final EntityModelLayer MODEL_HMA_LAYER = new EntityModelLayer(new Identifier("tajmod", "hma"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(TajMod.HMA, (context) -> {
            return new HmaEntityRenderer(context);
        });
    }
}
