package com.allah.tajmod.entity;

import com.allah.tajmod.TajMod;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SpiderNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class HmaEntity extends HostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private static final TrackedData<Byte> HMA_FLAGS;
    public static final TrackedData<Float> ATTACK_TICK_VISUAL = DataTracker.registerData(HmaEntity.class, TrackedDataHandlerRegistry.FLOAT);

    private float attackTick;

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(HMA_FLAGS, (byte)0);
        dataTracker.startTracking(ATTACK_TICK_VISUAL, 0F);
    }
    static {
        HMA_FLAGS = DataTracker.registerData(HmaEntity.class, TrackedDataHandlerRegistry.BYTE);
    }

    public boolean isOnFire() {
        return false;
    }


    public HmaEntity(EntityType<? extends HostileEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.ignoreCameraFrustum = true;
    }



    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.add(2, new AttackGoal());
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[]{ZombifiedPiglinEntity.class}));
        this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, MerchantEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal(this, IronGolemEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal(this, SkeletonEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal(this, ZombieEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal(this, CreeperEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal(this, SpiderEntity.class, true));
    }

    protected EntityNavigation createNavigation(World world) {
        return new SpiderNavigation(this, world);
    }


    public static DefaultAttributeContainer.Builder createHmaAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.0).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 150.0).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,1D);
    }


    public boolean isClimbing() {
        return this.isClimbingWall();
    }

    public boolean isClimbingWall() {
        return ((Byte)this.dataTracker.get(HMA_FLAGS) & 1) != 0;
    }

    public void setClimbingWall(boolean climbing) {
        byte b = (Byte)this.dataTracker.get(HMA_FLAGS);
        if (climbing) {
            b = (byte)(b | 1);
        } else {
            b &= -2;
        }

        this.dataTracker.set(HMA_FLAGS, b);
    }
    public void tick() {
        if (attackTick > 0F) {
            attackTick = attackTick - 0.08F;
            dataTracker.set(ATTACK_TICK_VISUAL, attackTick);
        }
        super.tick();
        if (!this.world.isClient) {
            this.setClimbingWall(this.horizontalCollision);
        }
        if (world.getTimeOfDay() > 0 && world.getTimeOfDay() < 12000) {
            this.kill();
        }
        LivingEntity livingEntity = this.getTarget();
        double d = 999.0D;
        if (livingEntity != null) {
            d = this.squaredDistanceTo(livingEntity);
        } else {
            d = 999.0D;
        }

        if (d < 70D && this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) < 0.4f) {
            this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).addPersistentModifier(new EntityAttributeModifier("Charge bonus", 0.15f, EntityAttributeModifier.Operation.ADDITION));

        } else if (d > 70D && this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) > 0.3f) {
            this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).addPersistentModifier(new EntityAttributeModifier("Charge bonus", -0.15f, EntityAttributeModifier.Operation.ADDITION));
        }
    }

    private <E extends IAnimatable> PlayState walk(AnimationEvent<E> event)
    {
        if (this.prevX == this.getX() && this.prevY == this.getY())  {
            return PlayState.STOP;
        }
        else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("hma walk", true));
            return PlayState.CONTINUE;
        }
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        float attackTick = this.getDataTracker().get(HmaEntity.ATTACK_TICK_VISUAL);
        if (attackTick > 0F) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("hma attack", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putFloat("AttackTick", this.attackTick);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        this.attackTick = tag.getFloat("AttackTick");
    }

    private class AttackGoal extends MeleeAttackGoal {
        public AttackGoal() {
            super(HmaEntity.this, 1.0D, true);
        }

        @Override
        public double getSquaredMaxAttackDistance(LivingEntity entity) {
            float f = HmaEntity.this.getWidth();
            return (double) (f * f * 1.3D + entity.getWidth());
        }

        @Override
        protected void attack(LivingEntity target, double squaredDistance) {
            double number = this.getSquaredMaxAttackDistance(target);
            System.out.println(attackTick);
            if (squaredDistance <= number && attackTick <= 0F) {
                //world.playSoundFromEntity(null, HmaEntity.this, SoundInit.PIGLINBEAST_CLUBSWING_EVENT, SoundCategory.HOSTILE, 1.0F, 1.0F);
                this.resetCooldown();
                this.mob.tryAttack(target);
                attackTick = 1F;
            }
        }
    }

    @Override
    public void registerControllers(AnimationData data)
    {
        data.addAnimationController(new AnimationController(this, "walkcontroller", 0, this::walk));
        data.addAnimationController(new AnimationController(this, "attackcontroller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory()
    {
        return this.factory;
    }


    @Override
    public boolean canSpawn(WorldAccess worldaccess, SpawnReason spawnReason) {
        if (world.getDimension().isPiglinSafe()) {
            return false;
        }
        if (world.getDimension().hasEnderDragonFight()) {
            if (this.getPathfindingFavor(this.getBlockPos(), world) >= 0.0F) {
                return true;
            }
            return false;
        }
        if (spawnReason == spawnReason.NATURAL) {
            if(world.getGameRules().getBoolean(TajMod.HMA_SPAWNING)) {
                if (this.getPathfindingFavor(this.getBlockPos(), world) >= 0.0F) {
                    return (world.getTimeOfDay() > 12000);
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean tryAttack(Entity target){
        this.setAttacking(true);
        target.damage(DamageSource.GENERIC, 2);
        return target.damage(DamageSource.mob(this), 4);

    }

    @Override
    public EntityGroup getGroup() {
        return TajMod.HMAS;
    }
}