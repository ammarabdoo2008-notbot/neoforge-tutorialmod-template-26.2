package net.ammar.tutorialmod.entity.custom.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.ammar.tutorialmod.TutorialMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static net.minecraft.util.Mth.DEG_TO_RAD;

public class PhantomCatModel extends EntityModel<LivingEntityRenderState> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "phantomcat_entity"),
            "main"
    );
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart front_left_leg;
    private final ModelPart front_right_leg;
    private final ModelPart back_left_leg;
    private final ModelPart back_right_leg;
    private final ModelPart tail;
    private final ModelPart tail2;
    private final ModelPart wings;

    public PhantomCatModel(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.front_left_leg = root.getChild("front_left_leg");
        this.front_right_leg = root.getChild("front_right_leg");
        this.back_left_leg = root.getChild("back_left_leg");
        this.back_right_leg = root.getChild("back_right_leg");
        this.tail = root.getChild("tail");
        this.tail2 = root.getChild("tail2");
        this.wings = root.getChild("wings");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-1.5F, -0.02F, -4.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-2.0F, -3.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 10).addBox(1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -9.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(20, 0).addBox(-2.0F, 3.0F, -8.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, -10.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition front_left_leg = partdefinition.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.1F, 14.1F, -5.0F));

        PartDefinition front_right_leg = partdefinition.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.1F, 14.1F, -5.0F));

        PartDefinition back_left_leg = partdefinition.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(8, 13).addBox(-1.0F, 0.0F, 1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.1F, 18.0F, 5.0F));

        PartDefinition back_right_leg = partdefinition.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(8, 13).addBox(-1.0F, 0.0F, 1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.1F, 18.0F, 5.0F));

        PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.5F, 8.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition tail2 = partdefinition.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(4, 15).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.5F, 16.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition wings = partdefinition.addOrReplaceChild("wings", CubeListBuilder.create().texOffs(42, 13).addBox(2.0F, -10.0F, -6.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 13).addBox(-12.0F, -10.0F, -6.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 24).mirror().addBox(2.0F, -10.0F, -5.0F, 9.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(15, 24).addBox(-11.0F, -10.0F, -5.0F, 9.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = wings.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(45, 16).addBox(-4.5F, -0.5F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -9.5F, -0.5F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r2 = wings.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(45, 16).addBox(-4.5F, -0.5F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -9.5F, -0.5F, 0.0F, -1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(LivingEntityRenderState state) {
        super.setupAnim(state);

        this.head.yRot = state.yRot * DEG_TO_RAD;
        this.head.xRot = state.xRot * DEG_TO_RAD;

        float swing = Mth.cos(state.walkAnimationPos * 0.6662F) * 1.2F * state.walkAnimationSpeed;
        this.back_right_leg.xRot = swing;
        this.back_left_leg.xRot = swing;
        this.front_right_leg.xRot = -swing;
        this.front_left_leg.xRot = -swing;
    }
}