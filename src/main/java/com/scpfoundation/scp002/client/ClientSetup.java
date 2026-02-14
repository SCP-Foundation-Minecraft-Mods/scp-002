package com.scpfoundation.scp002.client;

import com.scpfoundation.scp002.SCP002;
import com.scpfoundation.scp002.entities.SCP002Entity;
import com.scpfoundation.scp002.registry.ModEntities;
import com.scpfoundation.scp002.client.render.SCP002EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SCP002.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Register entity renderers
        event.enqueueWork(() -> {
            EntityRenderers.register(ModEntities.SCP002_ENTITY.get(), SCP002EntityRenderer::new);
        });
    }
    
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Alternative registration method
        event.registerEntityRenderer(ModEntities.SCP002_ENTITY.get(), SCP002EntityRenderer::new);
    }
}