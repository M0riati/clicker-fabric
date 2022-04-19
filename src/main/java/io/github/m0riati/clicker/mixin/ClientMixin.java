package io.github.m0riati.clicker.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
interface ClientAccessor {
    @Accessor("attackCooldown")
    int getAttackCooldown();

    @Invoker("doAttack")
    void invokeAttack();
}

@Mixin(MinecraftClient.class)
public class ClientMixin {
    @Inject(at = @At("HEAD"), method = "handleInputEvents()V")
    private void handleInputEvents(CallbackInfo ci) {
        if (((MinecraftClient)(Object)this).options.keyAttack.isPressed()) { // && ((ClientAccessor) MinecraftClient.getInstance()).getAttackCooldown() > 4
            ((ClientAccessor) this).invokeAttack();
        }
    }
}
