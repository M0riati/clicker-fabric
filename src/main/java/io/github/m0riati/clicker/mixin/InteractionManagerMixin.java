package io.github.m0riati.clicker.mixin;


import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ClientPlayerInteractionManager.class)
public class InteractionManagerMixin {
    /**
     * @author Moriati
     * @reason Overwrite this function so CPS options also apply to creative mode.
     */
    @Overwrite
    public boolean hasLimitedAttackSpeed() {
        return true;
    }
}