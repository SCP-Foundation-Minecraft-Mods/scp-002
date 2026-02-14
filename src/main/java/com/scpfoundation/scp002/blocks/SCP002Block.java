package com.scpfoundation.scp002.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SCP002Block extends Block {
    public SCP002Block(Properties properties) {
        super(properties);
    }

    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (!world.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            // Target coordinates
            BlockPos teleportPos = new BlockPos(100, 64, 100);

            // Teleport the player to the center of the block
            serverPlayer.teleportTo(teleportPos.getX() + 0.5, teleportPos.getY(), teleportPos.getZ() + 0.5);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.sidedSuccess(world.isClientSide());
    }
}
