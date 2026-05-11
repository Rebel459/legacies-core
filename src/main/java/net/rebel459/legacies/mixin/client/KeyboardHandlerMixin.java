package net.rebel459.legacies.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = KeyboardHandler.class)
public class KeyboardHandlerMixin {

	@Shadow
	@Final
	private Minecraft minecraft;

	@WrapOperation(
			method = "handleDebugKeys",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/KeyMapping;matches(Lnet/minecraft/client/input/KeyEvent;)Z",
					ordinal = 0
			)
	)
	private boolean stopChunkReload(KeyMapping instance, KeyEvent event, Operation<Boolean> original) {
		LocalPlayer player = this.minecraft.player;
		return original.call(instance, event) && player != null && !player.isReducedDebugInfo();
	}

	@WrapOperation(
			method = "handleDebugKeys",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/player/LocalPlayer;isReducedDebugInfo()Z",
					ordinal = 0
			)
	)
	private boolean allowHitboxes(LocalPlayer instance, Operation<Boolean> original) {
		return false;
	}

	@WrapOperation(
			method = "handleDebugKeys",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/player/LocalPlayer;isReducedDebugInfo()Z",
					ordinal = 1
			)
	)
	private boolean allowChunkBorders(LocalPlayer instance, Operation<Boolean> original) {
		return false;
	}
}