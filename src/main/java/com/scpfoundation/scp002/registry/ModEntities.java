package com.scpfoundation.scp002.registry;

import com.scpfoundation.scp002.SCP002;
import com.scpfoundation.scp002.entities.SCP002Entity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = 
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SCP002.MODID);
    
    // SCP-002 Entity - The Living Room
    public static final RegistryObject<EntityType<SCP002Entity>> SCP002_ENTITY = 
        ENTITIES.register("scp002_entity", () -> EntityType.Builder.of(SCP002Entity::new, MobCategory.MONSTER)
            .sized(16.0F, 8.0F) // Very large entity to represent the room
            .clientTrackingRange(10) // Track at longer range
            .updateInterval(1) // Update frequently
            .build("scp002_entity"));
    
    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}