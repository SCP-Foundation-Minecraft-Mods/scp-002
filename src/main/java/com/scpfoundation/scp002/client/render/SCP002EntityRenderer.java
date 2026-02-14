package com.scpfoundation.scp002.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.scpfoundation.scp002.SCP002;
import com.scpfoundation.scp002.entities.SCP002Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

public class SCP002EntityRenderer extends EntityRenderer<SCP002Entity> {
    
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("scp002", "textures/entity/scp002_entity.png");
    
    public SCP002EntityRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.0F; // No shadow for a room entity
    }
    
    @Override
    public void render(SCP002Entity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        
        // Make the entity pulse slightly
        float pulse = (float)Math.sin(entity.tickCount * 0.1F) * 0.05F + 1.0F;
        poseStack.scale(pulse, pulse, pulse);
        
        // Rotate slightly to show it's "alive"
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.sin(entity.tickCount * 0.05F) * 1.0F));
        
        // Render a simple box to represent the entity
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entitySolid(TEXTURE));
        
        // Draw a simple wireframe box
        drawWireframeBox(poseStack, vertexConsumer, packedLight);
        
        poseStack.popPose();
        
        super.render(entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);
    }
    
    private void drawWireframeBox(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight) {
        PoseStack.Pose pose = poseStack.last();
        
        // Draw edges of a box
        float size = 8.0F; // Half size of the box
        
        // Bottom face
        drawLine(pose, vertexConsumer, -size, -size, -size, size, -size, -size, packedLight);
        drawLine(pose, vertexConsumer, size, -size, -size, size, -size, size, packedLight);
        drawLine(pose, vertexConsumer, size, -size, size, -size, -size, size, packedLight);
        drawLine(pose, vertexConsumer, -size, -size, size, -size, -size, -size, packedLight);
        
        // Top face
        drawLine(pose, vertexConsumer, -size, size, -size, size, size, -size, packedLight);
        drawLine(pose, vertexConsumer, size, size, -size, size, size, size, packedLight);
        drawLine(pose, vertexConsumer, size, size, size, -size, size, size, packedLight);
        drawLine(pose, vertexConsumer, -size, size, size, -size, size, -size, packedLight);
        
        // Vertical edges
        drawLine(pose, vertexConsumer, -size, -size, -size, -size, size, -size, packedLight);
        drawLine(pose, vertexConsumer, size, -size, -size, size, size, -size, packedLight);
        drawLine(pose, vertexConsumer, size, -size, size, size, size, size, packedLight);
        drawLine(pose, vertexConsumer, -size, -size, size, -size, size, size, packedLight);
    }
    
    private void drawLine(PoseStack.Pose pose, VertexConsumer vertexConsumer, 
                         float x1, float y1, float z1, 
                         float x2, float y2, float z2, 
                         int packedLight) {
        vertexConsumer.vertex(pose.pose(), x1, y1, z1)
            .color(0.8F, 0.4F, 0.2F, 1.0F) // Wood/brown color
            .uv(0, 0)
            .overlayCoords(OverlayTexture.NO_OVERLAY)
            .uv2(packedLight)
            .normal(pose.normal(), 0, 1, 0)
            .endVertex();
            
        vertexConsumer.vertex(pose.pose(), x2, y2, z2)
            .color(0.8F, 0.4F, 0.2F, 1.0F)
            .uv(0, 0)
            .overlayCoords(OverlayTexture.NO_OVERLAY)
            .uv2(packedLight)
            .normal(pose.normal(), 0, 1, 0)
            .endVertex();
    }
    
    @Override
    public ResourceLocation getTextureLocation(SCP002Entity entity) {
        return TEXTURE;
    }
}