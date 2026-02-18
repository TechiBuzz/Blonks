package com.techibuzz.blonk.entity.client.renderstate;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class TonkRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
}
