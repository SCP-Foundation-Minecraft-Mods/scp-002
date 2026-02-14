package com.scpfoundation.scp002.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SCPResearchStationBlock extends Block {
    public SCPResearchStationBlock() {
        super(BlockBehaviour.Properties.of().strength(3.0f));
    }
}