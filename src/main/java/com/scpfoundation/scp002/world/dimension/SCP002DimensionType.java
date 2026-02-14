package com.scpfoundation.scp002.world.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.dimension.DimensionType;

public class SCP002DimensionType {
    public static final ResourceKey<DimensionType> SCP002_DIMENSION_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, 
        ResourceLocation.fromNamespaceAndPath("scp002", "scp002_dimension_type"));
    
    // Dimension type properties
    public static final long MIN_Y = 0;
    public static final int HEIGHT = 256;
    public static final int LOGICAL_HEIGHT = 256;
    public static final boolean INFINITE = false;
    public static final boolean ULTRA_WARM = false;
    public static final boolean NATURAL = false;
    public static final double COORDINATE_SCALE = 1.0;
    public static final boolean BED_WORKS = false;
    public static final boolean RESPAWN_ANCHOR_WORKS = false;
    public static final boolean HAS_SKYLIGHT = false;
    public static final boolean HAS_RAIDS = false;
    public static final int MONSTER_SPAWN_LIGHT_LEVEL = 0;
    public static final int MONSTER_SPAWN_BLOCK_LIGHT_LIMIT = 0;
}