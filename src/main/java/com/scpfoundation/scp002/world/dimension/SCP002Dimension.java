package com.scpfoundation.scp002.world.dimension;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SCP002Dimension {
    public static final ResourceLocation DIMENSION_ID = ResourceLocation.fromNamespaceAndPath("scp002", "scp002_dimension");
    public static final ResourceKey<DimensionType> DIMENSION_TYPE_KEY = ResourceKey.create(Registries.DIMENSION_TYPE, DIMENSION_ID);
    public static final ResourceKey<Level> LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, DIMENSION_ID);
    
    private final ServerLevel level;
    private final ChunkGenerator chunkGenerator;
    
    public SCP002Dimension(ServerLevel level, ChunkGenerator chunkGenerator) {
        this.level = level;
        this.chunkGenerator = chunkGenerator;
    }
    
    public ChunkGenerator getChunkSource() {
        return chunkGenerator;
    }
    
    public boolean isSurfaceWorld() {
        return false; // This is a custom dimension
    }
    
    public BlockPos findSpawn(Holder<?> biome, BlockPos pos, int p_49223_, boolean p_49224_) {
        return null; // No traditional spawn in SCP-002
    }
    
    public int getSeaLevel() {
        return 64;
    }
    
    public boolean hasFixedTime() {
        return false; // Time flows differently in SCP-002
    }
    
    public boolean hasSkyLight() {
        return false; // No sky in SCP-002 dimension
    }
    
    public boolean hasCeiling() {
        return true; // The "ceiling" is part of the room
    }
    
    public boolean doesWaterVaporize() {
        return false;
    }
    
    public boolean doesBedWorks() {
        return false; // Beds don't work in SCP-002
    }
    
    public boolean doesRespawnAnchorWorks() {
        return false; // Respawn anchors don't work
    }
    
    public boolean isValidSpawn(BlockPos pos) {
        return false; // No natural spawning
    }
    
    public float getCloudHeight() {
        return 128.0F; // Ceiling height
    }
    
    public boolean canRespawnInDimension() {
        return false; // Players can't respawn in SCP-002
    }
    
    public float ambientDarkness() {
        return 0.1F; // Very dark environment
    }
    
    public double getHorizon() {
        return 64.0D; // Limited visibility
    }
    
    public double getLevelHeight() {
        return 256.0D; // Dimension height
    }
    
    public boolean isPiglinSafe() {
        return false; // Piglins don't exist here
    }
    
    public boolean hasRaiderSpawn() {
        return false; // No raids in SCP-002
    }
    
    public boolean bedWorks() {
        return false;
    }
    
    public boolean respawnAnchorWorks() {
        return false;
    }
    
    public boolean hasSkylight() {
        return false;
    }
    
    public boolean ultrawarm() {
        return false;
    }
    
    public boolean natural() {
        return false; // This is an artificial dimension
    }
    
    public double coordinateScale() {
        return 1.0D; // Normal coordinate scale
    }
    
    public boolean createDragonFight() {
        return false; // No Ender Dragon
    }
    
    public boolean hasFog(int x, int z) {
        return true; // Always foggy in SCP-002
    }
    
    public DimensionType effects() {
        return level.dimensionType();
    }
    
    public boolean piglinSafe() {
        return false;
    }
    
    public boolean raidersSpawn() {
        return false;
    }
    
    public boolean constantAmbientLight() {
        return false;
    }
    
    public boolean mobSpawn() {
        return true; // SCP-002 entity can spawn
    }
}