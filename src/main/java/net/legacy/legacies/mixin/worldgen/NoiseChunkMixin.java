package net.legacy.legacies.mixin.worldgen;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.legacy.legacies.worldgen.LegaciesOreVeinifier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.RandomState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(NoiseChunk.class)
public class NoiseChunkMixin {

	@WrapOperation(
		method = "<init>",
		at = @At(
			value = "INVOKE",
			target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
			ordinal = 0
		)
	)
	private boolean netherierNether$addCustomNetherVeins(
            List list, Object object, Operation<Boolean> original,
            @Local(argsOnly = true) RandomState randomState,
            @Local(argsOnly = true) NoiseGeneratorSettings noiseGeneratorSettings,
            @Local(ordinal = 1) NoiseRouter noiseRouter
	) {
		if (noiseGeneratorSettings.defaultBlock().is(Blocks.NETHERRACK) || noiseGeneratorSettings.defaultBlock().is(Blocks.BLACKSTONE)) {
			list.add(
				LegaciesOreVeinifier.create(
					noiseRouter.veinToggle(),
					noiseRouter.veinRidged(),
					noiseRouter.veinGap(),
					randomState.oreRandom(),
					noiseRouter.finalDensity()
				)
			);
		}
		return original.call(list, object);
	}
}