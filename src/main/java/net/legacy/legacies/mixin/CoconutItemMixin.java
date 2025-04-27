package net.legacy.legacies.mixin;

import net.frozenblock.wilderwild.item.CoconutItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CoconutItem.class)
public abstract class CoconutItemMixin {

    @Inject(method = "use", at = @At(value = "HEAD"), cancellable = true)
    private void cancelCoconutThrow(Level level, Player player, InteractionHand usedHand, CallbackInfoReturnable<InteractionResult> cir) {
        cir.setReturnValue(InteractionResult.FAIL);
    }
}
