package com.techibuzz.blonk.entity.client.model;// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.techibuzz.blonk.Blonk;
import com.techibuzz.blonk.entity.client.renderstate.TonkRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class TonkModel extends EntityModel<TonkRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation TONK = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Blonk.MOD_ID, "tonk"), "main");

	private final ModelPart tonk;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart wheels;

	public TonkModel(ModelPart root) {
		super(root, RenderTypes::entityCutout);
		this.tonk = root.getChild("tonk");
		this.body = this.tonk.getChild("body");
		this.head = this.tonk.getChild("head");
		this.wheels = this.tonk.getChild("wheels");
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tonk = partdefinition.addOrReplaceChild("tonk", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, (float) Math.PI, 3.1416F));

		PartDefinition body = tonk.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -2.5F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(56, 32).addBox(-2.3F, -3.5F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 36).addBox(-2.5F, -3.2F, 2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(60, 42).addBox(-2.0F, -4.0F, 0.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(-0.7F, -0.7F, -3.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -2.0F, 1.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 17).addBox(-1.3F, -0.7F, -3.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 1.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition head = tonk.addOrReplaceChild("head", CubeListBuilder.create().texOffs(56, 25).addBox(-1.0F, -0.8F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-0.5F, -0.3F, -6.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -3.0F));

		PartDefinition wheels = tonk.addOrReplaceChild("wheels", CubeListBuilder.create().texOffs(42, 0).addBox(3.0F, -2.0F, -3.5F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(42, 0).mirror().addBox(-3.0F, -2.0F, -3.5F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 12).addBox(-3.0F, -1.0F, -3.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(44, 12).mirror().addBox(3.0F, -1.0F, -3.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 36).addBox(5.1F, 0.2F, -2.5F, 0.0F, -2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).mirror().addBox(-3.1F, 0.2F, -2.5F, 0.0F, -2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, -1.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}