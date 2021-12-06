package com.allah.tajmod.mixin;

import com.allah.tajmod.TajMod;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class HmaMixin {
	@Inject(at = @At("HEAD"), method = "addMonsters(Lnet/minecraft/world/biome/SpawnSettings$Builder;IIIZ)V")
	private static void addMonsters(net.minecraft.world.biome.SpawnSettings.Builder builder, int zombieWeight, int zombieVillagerWeight, int skeletonWeight, boolean drowned, CallbackInfo info) {
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(TajMod.HMA, 2, 4, 4));
	}
}
