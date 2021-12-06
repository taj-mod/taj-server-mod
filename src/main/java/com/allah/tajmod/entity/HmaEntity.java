package com.allah.tajmod.entity;

import com.allah.tajmod.TajMod;
import net.fabricmc.fabric.mixin.gamerule.GameRulesAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Random;

public class HmaEntity extends HostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public HmaEntity(EntityType<? extends HostileEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.ignoreCameraFrustum = true;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bat.fly", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data)
    {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory()
    {
        return this.factory;
    }
    public static DefaultAttributeContainer.Builder createHmaAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 60.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0);
    }

    @Override
    public boolean canSpawn(WorldAccess worldaccess, SpawnReason spawnReason) {
        if(world.getGameRules().getBoolean(TajMod.HMA_SPAWNING)) {
            System.out.println("here");
            if (this.getPathfindingFavor(this.getBlockPos(), world) >= 0.0F) {
                System.out.println(world.getTimeOfDay());
                return (world.getTimeOfDay() > 18000);
            }

        }
        return false;
    }
}
