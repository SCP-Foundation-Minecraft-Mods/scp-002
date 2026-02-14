package com.scpfoundation.scp002;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.scpfoundation.scp002.registry.ModBlocks;
import com.scpfoundation.scp002.registry.ModItems;
import com.scpfoundation.scp002.registry.ModCreativeTabs;
import com.scpfoundation.scp002.registry.ModEntities;
import com.scpfoundation.scp002.registry.ModSounds;

@Mod(SCP002.MODID)
public class SCP002 {
    public static final String MODID = "scp002";

    public SCP002(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModEntities.register(modEventBus);
    }
}
