package com.techibuzz.blonk.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.techibuzz.blonk.Blonk;
import com.techibuzz.blonk.entity.client.renderstate.TonkRenderState;
import com.techibuzz.blonk.entity.custom.Tonk;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;

public class TonkRenderer extends EntityRenderer<Tonk, TonkRenderState> {
    private final EntityModel<TonkRenderState> model;
    private final Identifier texture = Identifier.fromNamespaceAndPath(Blonk.MOD_ID, "textures/entity/tonk/tonk.png");
    public TonkRenderer(EntityRendererProvider.Context context, EntityModel<TonkRenderState> model) {
        super(context);
        this.model = model;
    }

    @Override
    public void submit(TonkRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
        nodeCollector.submitModel(this.model, renderState, poseStack, RenderTypes.entityCutoutNoCull(this.texture), renderState.lightCoords, OverlayTexture.NO_OVERLAY, renderState.outlineColor, null);
        super.submit(renderState, poseStack, nodeCollector, cameraRenderState);
    }

    @Override
    public TonkRenderState createRenderState() {
        return new TonkRenderState();
    }
}
