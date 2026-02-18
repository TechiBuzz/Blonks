package com.techibuzz.blonk.entity.client.renderer;

import com.techibuzz.blonk.Blonk;
import com.techibuzz.blonk.entity.client.model.TonkModel;
import com.techibuzz.blonk.entity.client.renderstate.TonkRenderState;
import com.techibuzz.blonk.entity.custom.Tonk;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.CamelRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.camel.Camel;
import org.jspecify.annotations.NonNull;

public class TonkRenderer extends MobRenderer<Tonk, TonkRenderState, TonkModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Blonk.MOD_ID, "textures/entity/tonk/tonk.png");

    public TonkRenderer(EntityRendererProvider.Context context, TonkModel entityModel) {
        super(context, entityModel, 0.25f);
    }

    public void extractRenderState(Tonk tonk, TonkRenderState tonkRenderState, float f) {
        super.extractRenderState(tonk, tonkRenderState, f);
        tonkRenderState.idleAnimationState.copyFrom(tonk.idleAnimationState);
    }

    @Override
    public @NonNull Identifier getTextureLocation(TonkRenderState livingEntityRenderState) {
        return TEXTURE;
    }

    @Override
    public TonkRenderState createRenderState() {
        return new TonkRenderState();
    }
}
