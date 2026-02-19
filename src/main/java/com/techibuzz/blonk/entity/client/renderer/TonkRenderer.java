package com.techibuzz.blonk.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.techibuzz.blonk.Blonk;
import com.techibuzz.blonk.entity.client.model.TonkModel;
import com.techibuzz.blonk.entity.client.renderstate.TonkRenderState;
import com.techibuzz.blonk.entity.custom.Tonk;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class TonkRenderer extends MobRenderer<Tonk, TonkRenderState, TonkModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Blonk.MOD_ID, "textures/entity/tonk/tonk.png");

    public TonkRenderer(EntityRendererProvider.Context context, TonkModel entityModel) {
        super(context, entityModel, 0.25f);
    }

    @Override
    public void submit(TonkRenderState tonkRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        float scale = 1.7F;
        poseStack.scale(scale, scale, scale);
        super.submit(tonkRenderState, poseStack, submitNodeCollector, cameraRenderState);
    }

    @Override
    public @NonNull Identifier getTextureLocation(TonkRenderState livingEntityRenderState) {
        return TEXTURE;
    }

    @Override
    public TonkRenderState createRenderState() {
        return new TonkRenderState();
    }

    public void extractRenderState(Tonk tonk, TonkRenderState tonkRenderState, float f) {
        super.extractRenderState(tonk, tonkRenderState, f);
        tonkRenderState.idleAnimationState.copyFrom(tonk.idleAnimationState);
    }
}
