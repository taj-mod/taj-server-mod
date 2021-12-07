package com.allah.tajmod.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class HeldItemTooltipMixin {
    @Inject(method = "    renderHeldItemTooltip(Lnet/minecraft/client/util/math/MatrixStack;)V\n", at = @At("HEAD"), cancellable = true)
    private void injected(MatrixStack matrices, CallbackInfo ci) {
        if (((InGameHud)(Object)this).currentStack.getName().toString().contains("hma_sword") || ((InGameHud)(Object)this).currentStack.getName().toString().contains("hm_sword")) {
            ci.cancel();
        }
    }
}
