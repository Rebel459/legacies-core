package net.legacy.legacies.mixin.server;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.resources.Identifier;
import net.minecraft.server.ServerAdvancementManager;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ServerAdvancementManager.class)
public class ServerAdvancementManagerMixin {

    @Shadow
    private Map<Identifier, AdvancementHolder> advancements;

    @Inject(
		method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V",
		at = @At("HEAD")
	)
	void disableAdvancements(Map<Identifier, Advancement> map, ResourceManager resourceManager, ProfilerFiller profilerFiller, CallbackInfo ci) {
		map.entrySet().removeIf((entry) -> !entry.getKey().getNamespace().equals("legacies") && (entry.getValue().display.isPresent() || entry.getValue().rewards.experience >= 1) && entry.getValue().rewards.function.isEmpty());
	}
}