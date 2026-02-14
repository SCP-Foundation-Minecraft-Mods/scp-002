package com.scpfoundation.scp002.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class SCP002Entity extends Monster {
    
    public SCP002Entity(EntityType<? extends SCP002Entity> type, Level level) {
        super(type, level);
        this.xpReward = 50;
        this.setPersistenceRequired(); // Don't despawn
    }
    
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
            .add(Attributes.MAX_HEALTH, 200.0D) // Very high health - it's a room!
            .add(Attributes.MOVEMENT_SPEED, 0.0D) // Doesn't move like normal entities
            .add(Attributes.ATTACK_DAMAGE, 5.0D)
            .add(Attributes.FOLLOW_RANGE, 32.0D);
    }
}