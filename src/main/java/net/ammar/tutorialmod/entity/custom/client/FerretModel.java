package net.ammar.tutorialmod.entity.custom.client;

import net.ammar.tutorialmod.TutorialMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class FerretModel extends EntityModel<LivingEntityRenderState> {

    private static final float DEG_TO_RAD = (float) (Math.PI / 180.0);

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "ferret_entity"),
            "main"
    );

    private final ModelPart head;
    private final ModelPart frontLeftLeg;
    private final ModelPart frontRightLeg;
    private final ModelPart backLeftLeg;
    private final ModelPart backRightLeg;

    public FerretModel(ModelPart root) {
        super(root);
        ModelPart all = root.getChild("all");
        this.head = all.getChild("head");
        this.frontLeftLeg = all.getChild("front_left_leg");
        this.frontRightLeg = all.getChild("front_right_leg");
        this.backLeftLeg = all.getChild("back_left_leg");
        this.backRightLeg = all.getChild("back_right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        all.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(-2, 38).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 14.5F, 1.5708F, 0.0F, 0.0F));

        all.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(36, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.1F, -3.0F, 7.0F));

        all.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(36, 21).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.1F, -3.0F, 7.0F));

        all.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(34, 9).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.1F, -4.9F, -4.0F));

        all.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(18, 34).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.1F, -4.9F, -4.0F));

        all.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -10.5F, -0.75F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.11F))
                .texOffs(26, 34).addBox(-2.0F, -0.5F, -1.75F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.75F, 3.5F, 1.5708F, 0.0F, 0.0F));

        all.addOrReplaceChild("head", CubeListBuilder.create().texOffs(16, 0).addBox(-2.5F, -0.995F, -1.875F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(36, 29).addBox(-1.5F, 0.985F, -2.875F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(40, 40).addBox(-2.0F, -1.995F, -0.875F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(40, 40).addBox(1.0F, -1.995F, -0.875F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.005F, -10.125F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(LivingEntityRenderState state) {
        super.setupAnim(state);

        this.head.yRot = state.yRot * DEG_TO_RAD;
        this.head.xRot = state.xRot * DEG_TO_RAD;

        float swing = Mth.cos(state.walkAnimationPos * 0.6662F) * 1.2F * state.walkAnimationSpeed;
        this.frontLeftLeg.xRot = swing;
        this.backRightLeg.xRot = swing;
        this.frontRightLeg.xRot = -swing;
        this.backLeftLeg.xRot = -swing;
    }
}