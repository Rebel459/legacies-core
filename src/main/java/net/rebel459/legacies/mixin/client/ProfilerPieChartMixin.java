package net.rebel459.legacies.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.debugchart.ProfilerPieChart;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.profiling.ProfileResults;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ProfilerPieChart.class)
public class ProfilerPieChartMixin {

	@Shadow
	private @Nullable ProfileResults profilerPieChartResults;

	@Inject(method = "setPieChartResults", at = @At(value = "HEAD"), cancellable = true)
	private void hidePieChart(ProfileResults results, CallbackInfo ci) {
		LocalPlayer player = Minecraft.getInstance().player;
		if (player != null && player.isReducedDebugInfo()) {
			this.profilerPieChartResults = null;
			ci.cancel();
		}
	}
}