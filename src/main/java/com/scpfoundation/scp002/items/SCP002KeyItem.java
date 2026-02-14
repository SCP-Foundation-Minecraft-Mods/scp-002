package com.scpfoundation.scp002.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

import javax.annotation.Nullable;
import java.util.List;

public class SCP002KeyItem extends Item {
    
    public SCP002KeyItem(Properties properties) {
        super(properties);
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        
        if (!world.isClientSide()) {
            // Play activation sound
            world.playSound(null, player.getX(), player.getY(), player.getZ(), 
                SoundEvents.END_PORTAL_FRAME_FILL, SoundSource.PLAYERS, 1.0F, 1.0F);
            
            // Give player a message
            player.sendSystemMessage(Component.literal("The key hums with strange energy..."));
            
            // Could be used to activate the portal or reveal hidden information
            // For now, just play the sound and message
        }
        
        return InteractionResultHolder.success(stack);
    }
    
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("§7A strange key found in an abandoned house"));
        tooltip.add(Component.literal("§7It seems to resonate with dimensional energy"));
        tooltip.add(Component.literal("§8SCP Foundation Property - Classified"));
    }
}