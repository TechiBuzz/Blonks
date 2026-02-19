package com.techibuzz.blonk.entity.client.model;

import com.techibuzz.blonk.Blonk;
import com.techibuzz.blonk.entity.animations.ModAnimations;
import com.techibuzz.blonk.entity.client.renderstate.TonkRenderState;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

import java.util.Objects;

public class TonkModel extends EntityModel<TonkRenderState> {
    public static final ModelLayerLocation TONK = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Blonk.MOD_ID, "tonk"), "main");

    private final ModelPart tonk;
    private final ModelPart body;
    private final ModelPart center;
    private final ModelPart head;
    private final ModelPart wheels;
    private final ModelPart left;
    private final ModelPart right;

    private final KeyframeAnimation idleAnimation;
    private final KeyframeAnimation walkAnimation;

    public TonkModel(ModelPart root) {
        super(root, RenderTypes::entityCutoutNoCull);

        this.tonk = root.getChild("tonk");

        this.body = this.tonk.getChild("body");
        this.center = this.body.getChild("center");
        this.head = this.body.getChild("head");
        this.wheels = this.body.getChild("wheels");
        this.left = this.wheels.getChild("left");
        this.right = this.wheels.getChild("right");

        this.idleAnimation = ModAnimations.TONK_IDLE.bake(root);
        this.walkAnimation = ModAnimations.TONK_MOVE.bake(root);
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition model = new MeshDefinition();
        PartDefinition partdefinition = model.getRoot();

        PartDefinition tonk = partdefinition.addOrReplaceChild("tonk", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = tonk.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition center = body.addOrReplaceChild("center", CubeListBuilder.create().texOffs(0, 0).addBox(-1.8667F, 0.2577F, -3.8833F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(56, 32).addBox(-1.1667F, -0.2423F, -1.3833F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(54, 36).addBox(-1.3667F, 0.0577F, 0.6167F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(60, 42).addBox(-0.8667F, -0.7423F, -0.5833F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1333F, -4.2577F, 1.3833F));

        PartDefinition cube_r1 = center.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(-0.7F, -0.7F, -3.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1333F, 1.2577F, -0.3833F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cube_r2 = center.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 17).addBox(-1.3F, -0.7F, -3.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8667F, 1.2577F, -0.3833F, 0.0F, 0.0F, -0.5236F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(56, 25).addBox(-1.0F, -0.8F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 26).addBox(-0.5F, -0.3F, -6.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -3.0F));

        PartDefinition wheels = body.addOrReplaceChild("wheels", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.0F, -1.0F));

        PartDefinition left = wheels.addOrReplaceChild("left", CubeListBuilder.create().texOffs(42, 0).addBox(3.0F, -2.0F, -3.5F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(44, 12).mirror().addBox(3.0F, -1.0F, -3.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 36).addBox(5.1F, 0.2F, -2.5F, 0.0F, -2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right = wheels.addOrReplaceChild("right", CubeListBuilder.create().texOffs(44, 12).addBox(-3.0F, -1.0F, -3.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 36).mirror().addBox(-3.1F, 0.2F, -2.5F, 0.0F, -2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(42, 0).mirror().addBox(-3.0F, -2.0F, -3.5F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(model, 64, 64);
    }

    public void setupAnim(TonkRenderState tonkRenderState) {
        super.setupAnim(tonkRenderState);

        this.applyHeadRotation(tonkRenderState.yRot, tonkRenderState.xRot);

        this.idleAnimation.apply(tonkRenderState.idleAnimationState, tonkRenderState.ageInTicks);
        this.walkAnimation.applyWalk(tonkRenderState.walkAnimationPos, tonkRenderState.walkAnimationSpeed, 2.3F, 2.5F);
    }

    private void applyHeadRotation(float f, float g) {
        f = Mth.clamp(f, -30.0F, 30.0F);
        g = Mth.clamp(g, -25.0F, 45.0F);

        this.head.yRot = f * (float) (Math.PI / 180.0);
        this.head.xRot = g * (float) (Math.PI / 180.0);
    }
}