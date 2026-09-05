package net.ammar.tutorialmod.entity.custom.client;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;

public class AxeProjectileRenderState extends EntityRenderState {
    public final ItemStackRenderState item = new ItemStackRenderState();
    public int lightCoords;
    public float spinRotation;
}