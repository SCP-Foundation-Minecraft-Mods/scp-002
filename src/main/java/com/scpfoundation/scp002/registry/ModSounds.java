package com.scpfoundation.scp002.registry;

import com.scpfoundation.scp002.SCP002;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = 
        DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SCP002.MODID);
    
    // SCP-002 Ambient Sounds
    public static final RegistryObject<SoundEvent> SCP002_AMBIENT = 
        registerSoundEvent("scp002_ambient");
    
    public static final RegistryObject<SoundEvent> SCP002_CREAKING = 
        registerSoundEvent("scp002_creaking");
    
    public static final RegistryObject<SoundEvent> SCP002_HEARTBEAT = 
        registerSoundEvent("scp002_heartbeat");
    
    public static final RegistryObject<SoundEvent> SCP002_WHISPER = 
        registerSoundEvent("scp002_whisper");
    
    // Portal Sounds
    public static final RegistryObject<SoundEvent> PORTAL_ACTIVATE = 
        registerSoundEvent("portal_activate");
    
    public static final RegistryObject<SoundEvent> PORTAL_DEACTIVATE = 
        registerSoundEvent("portal_deactivate");
    
    // Entity Sounds
    public static final RegistryObject<SoundEvent> ENTITY_ABSORB = 
        registerSoundEvent("entity_absorb");
    
    public static final RegistryObject<SoundEvent> ENTITY_HURT = 
        registerSoundEvent("entity_hurt");
    
    public static final RegistryObject<SoundEvent> ENTITY_DEATH = 
        registerSoundEvent("entity_death");
    
    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SCP002.MODID, name)));
    }
    
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}