package com.scpfoundation.scp002.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SCPContainmentBlock extends Block {
    public SCPContainmentBlock() {
        super(BlockBehaviour.Properties.of().strength(5.0f));
    }
}