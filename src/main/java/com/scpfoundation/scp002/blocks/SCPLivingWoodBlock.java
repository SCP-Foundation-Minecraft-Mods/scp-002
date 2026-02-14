package com.scpfoundation.scp002.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SCPLivingWoodBlock extends Block {
    public SCPLivingWoodBlock() {
        super(BlockBehaviour.Properties.of().strength(2.0f));
    }
}