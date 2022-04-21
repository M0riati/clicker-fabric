package io.github.m0riati.clicker.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.m0riati.clicker.Clicker.Cooldown;

@Mixin(MinecraftClient.class)
interface ClientAccessor {
    @Accessor("attackCooldown")
    int getAttackCooldown();

    @Accessor("attackCooldown")
    void setAttackCooldown(int attackCooldown);

    @Invoker("doAttack")
    void invokeAttack();
}

@Mixin(MinecraftClient.class)
public class ClientMixin {

    @Inject(at = @At("HEAD"), method = "handleInputEvents()V")
    private void handleInputEvents(CallbackInfo ci) {
        if (((MinecraftClient) (Object) this).options.keyAttack.isPressed() && ((ClientAccessor) this).getAttackCooldown() == 0 && !(((MinecraftClient) (Object) this).player.isUsingItem())) {
            ((ClientAccessor) this).invokeAttack();
        }
    }

    @Inject(at = @At("TAIL"), method = "doAttack()V")
    private void doAttack(CallbackInfo ci) {
        ((ClientAccessor) this).setAttackCooldown(Cooldown());
    }
}
