package net.rebel459.legacies.mixin.client;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {

	@Shadow
	public abstract Window getWindow();

	@ModifyArgs(
			method = "setScreen",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/gui/screens/Screen;init(II)V"
			)
	)
	private void fixFancyMenu(Args args) {
		Minecraft client = Minecraft.class.cast(this);

		if (client.level != null) {
			return;
		}

		Window window = this.getWindow();

		int width = window.getGuiScaledWidth();
		int height = window.getGuiScaledHeight();

		args.set(0, width);
		args.set(1, height);
	}
}