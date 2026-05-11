package net.rebel459.legacies.mixin.integration.ww;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.datafixers.util.Pair;
import net.frozenblock.wilderwild.worldgen.biome.Tundra;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;

@Mixin(value = Tundra.class)
public class WWTundraMixin {

	@Inject(method = "injectToOverworld", at = @At(value = "HEAD"), cancellable = true)
	private void removeTundra(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> parameters, CallbackInfo ci) {
		ci.cancel();
	}
}