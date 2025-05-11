package org.trotu.despawnconfig.mixin;

import net.minecraft.entity.SpawnGroup;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.trotu.despawnconfig.DespawnConfig;


@Mixin(SpawnGroup.class)
public abstract class MobEntityMixin {
    
    /**
     * Modifies the soft despawn range for mob entities.
     * This mixin injects at the return point of the getDespawnStartRange method
     * and replaces the return value with the configurable value from DespawnConfig.
     *
     * @param cir Callback info containing the original return value
     */
    @Inject(method = "getDespawnStartRange", at = @At(value = "RETURN"), cancellable = true)
    private void modifyDespawnStartRange(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(DespawnConfig.softDespawnRange);
    }

    /**
     * Modifies the immediate(hard) despawn range of a mob entity.
     * This mixin injects at the return point of the getImmediateDespawnRange method
     * and replaces the return value with the configurable value from DespawnConfig.
     * 
     * @param cir Callback info returnable containing the original return value
     */
    @Inject(method = "getImmediateDespawnRange", at = @At(value = "RETURN"), cancellable = true)
    private void modifyImmediateDespawnRange(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(DespawnConfig.hardDespawnRange);
    }

}