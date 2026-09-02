package net.ammar.tutorialmod.entity.custom.client;

import net.ammar.tutorialmod.TutorialMod;
import net.ammar.tutorialmod.entity.custom.FerretEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class FerretRenderer extends MobRenderer<FerretEntity, LivingEntityRenderState , FerretModel> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/ferret.png");

    public FerretRenderer(EntityRendererProvider.Context context) {
        super(context, new FerretModel(context.bakeLayer(FerretModel.LAYER_LOCATION)), 0.4F);
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
