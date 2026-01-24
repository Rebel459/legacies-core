package net.legacy.legacies.mixin.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = FireworkRocketItem.class)
public class FireworkRocketItemMixin {
	
	@Inject(method = "use", at = @At("HEAD"), cancellable = true)
	private void init(Level level, Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
		if(player.isFallFlying()) {
            cir.setReturnValue(InteractionResult.FAIL);
		}
	}
}