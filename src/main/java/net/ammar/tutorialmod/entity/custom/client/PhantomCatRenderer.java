package net.ammar.tutorialmod.entity.custom.client;

import net.ammar.tutorialmod.TutorialMod;
import net.ammar.tutorialmod.entity.custom.PhantomCatEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class PhantomCatRenderer extends MobRenderer<PhantomCatEntity, LivingEntityRenderState, PhantomCatModel> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/phantomcat.png");

    public PhantomCatRenderer(EntityRendererProvider.Context context) {
        super(context, new PhantomCatModel(context.bakeLayer(PhantomCatModel.LAYER_LOCATION)), 0.4F);
    }

    @Override
    public Identifier getTextureLocation(LivingEntityRenderState state) {
        return TEXTURE;
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }
}
