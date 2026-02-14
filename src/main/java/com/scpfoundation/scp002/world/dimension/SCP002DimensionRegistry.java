package com.scpfoundation.scp002.world.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class SCP002DimensionRegistry {
    public static final ResourceKey<Level> SCP002_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath("scp002", "scp002"));
    public static final ResourceKey<DimensionType> SCP002_TYPE_KEY = ResourceKey.create(Registries.DIMENSION_TYPE, ResourceLocation.fromNamespaceAndPath("scp002", "scp002"));
}