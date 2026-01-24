package net.legacy.legacies.mixin.worldgen;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.datafixers.util.Pair;
import net.legacy.legacies.util.NetherHelper;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Mixin(MultiNoiseBiomeSourceParameterList.Preset.class)
public class MultiNoiseBiomeSourceParameterListMixin {

    @WrapOperation(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "(Lnet/minecraft/resources/Identifier;Lnet/minecraft/world/level/biome/MultiNoiseBiomeSourceParameterList$Preset$SourceProvider;)Lnet/minecraft/world/level/biome/MultiNoiseBiomeSourceParameterList$Preset;"
            )
    )
    private static MultiNoiseBiomeSourceParameterList.Preset netherierNether$netherBiomePlacement(
            Identifier id, MultiNoiseBiomeSourceParameterList.Preset.SourceProvider sourceProvider, Operation<MultiNoiseBiomeSourceParameterList.Preset> original
    ) {
        final Identifier netherId = Identifier.withDefaultNamespace("nether");
        if (!Objects.equals(id, netherId)) return original.call(id, sourceProvider);
        return original.call(
                netherId,
                new MultiNoiseBiomeSourceParameterList.Preset.SourceProvider() {
                    @Override
                    public <T> Climate.ParameterList<T> apply(Function<ResourceKey<Biome>, T> function) {
                        final List<Pair<Climate.ParameterPoint, T>> biomes = new ArrayList<>();
                        for (int i = 0; i < NetherHelper.NETHER_BIOMES.size(); i++) {
                            final Pair<Climate.ParameterPoint, ResourceKey<Biome>> pair = NetherHelper.NETHER_BIOMES.get(i);
                            biomes.add(Pair.of(pair.getFirst(), function.apply(pair.getSecond())));
                        }
                        return new Climate.ParameterList<>(biomes);
                    }
                }
        );
    }
}