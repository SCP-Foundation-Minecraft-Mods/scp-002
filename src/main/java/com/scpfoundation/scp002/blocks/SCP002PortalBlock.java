package com.scpfoundation.scp002.blocks;

import com.scpfoundation.scp002.world.dimension.SCP002DimensionRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;
import java.util.function.Function;

@Mod.EventBusSubscriber
public class SCP002PortalBlock extends Block {
    
    public static final IntegerProperty POWER = BlockStateProperties.POWER;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);
    
    public SCP002PortalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(POWER, 0)
            .setValue(WATERLOGGED, false));
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide()) {
            if (player instanceof ServerPlayer serverPlayer) {
                // Check if the portal is activated (has power)
                if (state.getValue(POWER) > 0) {
                    // Teleport player to SCP-002 dimension
                    teleportToSCP002(serverPlayer);
                    return InteractionResult.SUCCESS;
                } else {
                    // Try to activate the portal with an item
                    ItemStack heldItem = player.getItemInHand(hand);
                    if (activatePortal(world, pos, state, heldItem)) {
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }
    
    private boolean activatePortal(Level world, BlockPos pos, BlockState state, ItemStack item) {
        if (item.is(Items.REDSTONE)) {
            // Activate portal with redstone
            world.setBlock(pos, state.setValue(POWER, 15), 3);
            world.playSound(null, pos, SoundEvents.REDSTONE_TORCH_BURNOUT, SoundSource.BLOCKS, 1.0F, 1.0F);
            item.shrink(1);
            return true;
        }
        return false;
    }
    
    private void teleportToSCP002(ServerPlayer player) {
        // Play teleportation sound and particles
        player.level().playSound(null, player.blockPosition(), SoundEvents.PORTAL_TRIGGER, SoundSource.PLAYERS, 1.0F, 1.0F);
        
        // Create portal particles
        for (int i = 0; i < 10; i++) {
            double x = player.getX() + (player.getRandom().nextDouble() - 0.5) * 2;
            double y = player.getY() + player.getRandom().nextDouble() * 2;
            double z = player.getZ() + (player.getRandom().nextDouble() - 0.5) * 2;
            ((ServerLevel) player.level()).sendParticles(ParticleTypes.PORTAL, x, y, z, 5, 0, 0, 0, 0);
        }
        
        // Get the SCP-002 dimension
        ServerLevel scp002Dimension = player.getServer().getLevel(SCP002DimensionRegistry.SCP002_LEVEL_KEY);
        
        if (scp002Dimension != null) {
            // Teleport to SCP-002 dimension
            BlockPos targetPos = new BlockPos(0, 64, 0); // Center of the SCP-002 room
            
            // Simple teleportation to the dimension
            player.teleportTo(scp002Dimension, targetPos.getX() + 0.5, targetPos.getY(), targetPos.getZ() + 0.5, player.getYRot(), player.getXRot());
            
            // Give the player a warning message
            player.sendSystemMessage(net.minecraft.network.chat.Component.literal(
                "You feel a strange sensation as reality shifts around you..."
            ));
            player.sendSystemMessage(net.minecraft.network.chat.Component.literal(
                "You have entered the SCP-002 dimension!"
            ));
        } else {
            // Fallback to same dimension teleportation if dimension doesn't exist
            BlockPos targetPos = new BlockPos(100, 64, 100);
            player.teleportTo(targetPos.getX() + 0.5, targetPos.getY(), targetPos.getZ() + 0.5);
            player.sendSystemMessage(net.minecraft.network.chat.Component.literal(
                "SCP-002 dimension not found. Teleporting to coordinates."
            ));
        }
    }
    
    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if (state.getValue(POWER) > 0) {
            // Portal is active - show particles
            if (random.nextInt(10) == 0) {
                world.playLocalSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D,
                    SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
            }
            
            for (int i = 0; i < 4; i++) {
                double x = (double)pos.getX() + random.nextDouble();
                double y = (double)pos.getY() + random.nextDouble();
                double z = (double)pos.getZ() + random.nextDouble();
                double vx = ((double)random.nextFloat() - 0.5D) * 0.5D;
                double vy = ((double)random.nextFloat() - 0.5D) * 0.5D;
                double vz = ((double)random.nextFloat() - 0.5D) * 0.5D;
                world.addParticle(ParticleTypes.PORTAL, x, y, z, vx, vy, vz);
            }
        }
    }
    
    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }
    
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWER, WATERLOGGED);
    }
    
    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        // Portal can be placed on any solid block
        BlockState belowState = world.getBlockState(pos.below());
        return belowState.isSolidRender(world, pos.below());
    }
    
    @SubscribeEvent
    public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
        // Handle dimension travel if needed
        // This is where you'd add special logic for entering/exiting SCP-002
    }
}
