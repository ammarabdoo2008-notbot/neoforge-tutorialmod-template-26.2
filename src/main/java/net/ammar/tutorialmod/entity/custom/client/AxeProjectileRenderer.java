package net.ammar.tutorialmod.entity.custom.client;

import net.ammar.tutorialmod.entity.custom.AxeProjectile;
import net.ammar.tutorialmod.item.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class AxeProjectileRenderer extends EntityRenderer<AxeProjectile, AxeProjectileRenderState> {

    private final ItemModelResolver itemModelResolver;

    public AxeProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemModelResolver = context.getItemModelResolver();
        this.shadowRadius = 0.15f;
    }

    @Override
    public AxeProjectileRenderState createRenderState() {
        return new AxeProjectileRenderState();
    }

    @Override
    public void extractRenderState(AxeProjectile entity, AxeProjectileRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        ItemStack stack = new ItemStack(ModItems.AMMARITO_AXE.get());
        this.itemModelResolver.updateForNonLiving(state.item, stack, ItemDisplayContext.GROUND, entity);
        state.lightCoords = OverlayTexture.NO_OVERLAY;
        float age = entity.tickCount + partialTicks;
        state.spinRotation = age * 40.0f; // degrees per tick, tune to taste
    }

    @Override
    public void submit(AxeProjectileRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        poseStack.pushPose();

        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(state.spinRotation - 90.0f));
        poseStack.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(state.spinRotation));
        poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(state.spinRotation));

        state.item.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);

        poseStack.popPose();

        super.submit(state, poseStack, submitNodeCollector, camera);
    }
}