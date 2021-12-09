package com.allah.tajmod.entity.goals;

import com.allah.tajmod.entity.HmaEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class HmaAttackGoal extends MeleeAttackGoal {
    private final HmaEntity Hma;
    private int ticks;

    public HmaAttackGoal(HmaEntity hma, double speed, boolean pauseWhenMobIdle) {
        super(hma, speed, pauseWhenMobIdle);
        this.Hma = hma;
    }

    public void start() {
        this.Hma.setAttacking(true);
        super.start();
        this.ticks = 0;
    }

    public void stop() {
        super.stop();
        this.Hma.setAttacking(false);
    }

    public void tick() {
        super.tick();
        ++this.ticks;
        if (this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2) {
            this.Hma.setAttacking(true);
        } else {
            this.Hma.setAttacking(false);
        }

    }
}
