package net.rebel459.legacies.worldgen;

import com.mojang.datafixers.util.Pair;
import dev.worldgen.lithostitched.api.event.AddBiomeInjectorsEvent;
import dev.worldgen.lithostitched.api.worldgen.biomeinjector.BiomeInjector;
import dev.worldgen.lithostitched.api.worldgen.biomeinjector.ParameterBuilder;
import net.frozenblock.wilderwild.registry.WWBiomes;
import net.frozenblock.wilderwild.worldgen.biome.FrozenCaves;
import net.frozenblock.wilderwild.worldgen.biome.MagmaticCaves;
import net.frozenblock.wilderwild.worldgen.biome.MapleForest;
import net.frozenblock.wilderwild.worldgen.biome.MesogleaCaves;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.rebel459.legacies.Legacies;
import net.rebel459.legacies.util.NetherHelper;

import java.util.List;
import java.util.function.BiConsumer;

public class LegaciesBiomePlacement {

    public static void init() {
        overworld();
        nether();
        end();
    }

    private static void overworld() {
        AddBiomeInjectorsEvent.EVENT.register((registry, consumer) -> {
            Pair<RegistryAccess, BiConsumer<Identifier, BiomeInjector>> event = Pair.of(registry, consumer);

            consumer.accept(
                    Legacies.id("cypress_wetlands"),
                    BiomeInjector.builder(Level.OVERWORLD).replacePartially(
                            registry.getOrThrow(Biomes.SWAMP),
                            registry.getOrThrow(WWBiomes.CYPRESS_WETLANDS),
                            ParameterBuilder.create()
                                    .climateRange(BiomeInjector.ClimateParameter.TEMPERATURE, 0.2F, 0.55F)
                                    .climateRange(BiomeInjector.ClimateParameter.HUMIDITY, -0.1F, 0.3F)
                    )
            );

            consumer.accept(
                    Legacies.id("flower_field_1"),
                    BiomeInjector.builder(Level.OVERWORLD).replacePartially(
                            HolderSet.direct(
                                    registry.getOrThrow(Biomes.PLAINS),
                                    registry.getOrThrow(Biomes.MEADOW)
                            ),
                            registry.getOrThrow(WWBiomes.FLOWER_FIELD),
                            ParameterBuilder.create()
                                    .climateRange(BiomeInjector.ClimateParameter.TEMPERATURE, -0.2F, -0.075F)
                                    .climateRange(BiomeInjector.ClimateParameter.HUMIDITY, -1.0F, -0.35F)
                    )
            );
            consumer.accept(
                    Legacies.id("flower_field_2"),
                    BiomeInjector.builder(Level.OVERWORLD).replacePartially(
                            HolderSet.direct(
                                    registry.getOrThrow(Biomes.PLAINS),
                                    registry.getOrThrow(Biomes.MEADOW)
                            ),
                            registry.getOrThrow(WWBiomes.FLOWER_FIELD),
                            ParameterBuilder.create()
                                    .climateRange(BiomeInjector.ClimateParameter.TEMPERATURE, -0.15F, 0.2F)
                                    .climateRange(BiomeInjector.ClimateParameter.HUMIDITY, -0.4F, -0.3F)
                    )
            );
            consumer.accept(
                    Legacies.id("flower_field_3"),
                    BiomeInjector.builder(Level.OVERWORLD).replacePartially(
                            HolderSet.direct(
                                    registry.getOrThrow(Biomes.PLAINS),
                                    registry.getOrThrow(Biomes.MEADOW)
                            ),
                            registry.getOrThrow(WWBiomes.FLOWER_FIELD),
                            ParameterBuilder.create()
                                    .climateRange(BiomeInjector.ClimateParameter.TEMPERATURE, -0.2F, -0.075F)
                                    .climateRange(BiomeInjector.ClimateParameter.HUMIDITY, -0.3675F, -0.3125F)
                    )
            );

            int frozenCavesId = 1;
            for (float depth : FrozenCaves.DEPTHS) {
                Pair<Climate.ParameterPoint, Climate.ParameterPoint> biomeParameters = FrozenCaves.INSTANCE.makeParametersAt(depth);
                consumer.accept(
                        Legacies.id("frozen_caves_" + frozenCavesId),
                        BiomeInjector.builder(Level.OVERWORLD).addPoints(
                                new Climate.ParameterList<>(List.of(
                                        Pair.of(
                                                biomeParameters.getFirst(),
                                                registry.getOrThrow(WWBiomes.FROZEN_CAVES)
                                        ),
                                        Pair.of(
                                                biomeParameters.getSecond(),
                                                registry.getOrThrow(WWBiomes.FROZEN_CAVES)
                                        )
                                ))
                        )
                );
                frozenCavesId++;
            }

            caveBiome(
                    "magmatic_caves",
                    WWBiomes.MAGMATIC_CAVES,
                    MagmaticCaves.TEMPERATURE,
                    MagmaticCaves.HUMIDITY,
                    MagmaticCaves.CONTINENTALNESS,
                    MagmaticCaves.EROSION,
                    Climate.Parameter.point(1.1F),
                    MagmaticCaves.WEIRDNESS,
                    0L,
                    event
            );

            surfaceBiome(
                    "maple_forest_1",
                    WWBiomes.MAPLE_FOREST,
                    MapleForest.TEMPERATURE,
                    MapleForest.HUMIDITY,
                    MapleForest.CONTINENTALNESS,
                    MapleForest.EROSION,
                    MapleForest.WEIRDNESS_A,
                    0L,
                    event
            );
            surfaceBiome(
                    "maple_forest_2",
                    WWBiomes.MAPLE_FOREST,
                    MapleForest.TEMPERATURE,
                    MapleForest.HUMIDITY,
                    MapleForest.CONTINENTALNESS,
                    MapleForest.EROSION,
                    MapleForest.WEIRDNESS_B,
                    0L,
                    event
            );

            caveBiome(
                    "mesoglea_caves_1",
                    WWBiomes.MESOGLEA_CAVES,
                    MesogleaCaves.TEMPERATURE,
                    MesogleaCaves.HUMIDITY,
                    MesogleaCaves.CONTINENTALNESS,
                    MesogleaCaves.EROSION,
                    Climate.Parameter.span(0.4F, 1.0F),
                    MesogleaCaves.WEIRDNESS, 0L,
                    event
            );
            caveBiome(
                    "mesoglea_caves_2",
                    WWBiomes.MESOGLEA_CAVES,
                    MesogleaCaves.TEMPERATURE,
                    MesogleaCaves.HUMIDITY,
                    MesogleaCaves.CONTINENTALNESS,
                    MesogleaCaves.EROSION,
                    Climate.Parameter.span(0.2F, 0.9F),
                    MesogleaCaves.WEIRDNESS, 0L,
                    event
            );

            consumer.accept(
                    Legacies.id("oasis"),
                    BiomeInjector.builder(Level.OVERWORLD).replacePartially(
                            registry.getOrThrow(Biomes.DESERT),
                            registry.getOrThrow(WWBiomes.OASIS),
                            ParameterBuilder.create()
                                    .climateRange(BiomeInjector.ClimateParameter.HUMIDITY, 0.1F, 0.3F)
                                    .climateRange(BiomeInjector.ClimateParameter.WEIRDNESS, -1.0F, 0.2F)
                    )
            );

            consumer.accept(
                    Legacies.id("rainforest"),
                    BiomeInjector.builder(Level.OVERWORLD).replacePartially(
                            registry.getOrThrow(Biomes.FOREST),
                            registry.getOrThrow(WWBiomes.RAINFOREST),
                            ParameterBuilder.create()
                                    .climateRange(BiomeInjector.ClimateParameter.TEMPERATURE, 0.3F, 1F)
                                    .climateRange(BiomeInjector.ClimateParameter.HUMIDITY, 0F, 1F)
                    )
            );

            consumer.accept(
                    Legacies.id("tundra"),
                    BiomeInjector.builder(Level.OVERWORLD).replacePartially(
                            HolderSet.direct(
                                    registry.getOrThrow(Biomes.PLAINS),
                                    registry.getOrThrow(Biomes.SUNFLOWER_PLAINS)
                            ),
                            registry.getOrThrow(WWBiomes.TUNDRA),
                            ParameterBuilder.create()
                                    .climateRange(BiomeInjector.ClimateParameter.TEMPERATURE, -0.495F, -0.255F)
                                    .climateRange(BiomeInjector.ClimateParameter.HUMIDITY, -1.0F, -0.2F)
                                    .climateRange(BiomeInjector.ClimateParameter.EROSION, -0.2225F, 1F)
                                    .climateRange(BiomeInjector.ClimateParameter.WEIRDNESS, 0.05F, 1F)
                    )
            );
        });
    }

    private static void nether() {
        NetherHelper.addBiome(
                Biomes.NETHER_WASTES,
                Climate.Parameter.point(0F),
                Climate.Parameter.point(0F),
                Climate.Parameter.span(-1F, 0F),
                Climate.Parameter.span(-1F, -0.7F)
        );
        NetherHelper.addBiome(
                Biomes.NETHER_WASTES,
                Climate.Parameter.point(0F),
                Climate.Parameter.point(0F),
                Climate.Parameter.span(-1F, 0F),
                Climate.Parameter.span(0.7F, 1F)
        );
        NetherHelper.addBiome(
                Biomes.NETHER_WASTES,
                Climate.Parameter.span(-0.1F, 0.1F),
                Climate.Parameter.span(-0.1F, 0.1F),
                Climate.Parameter.span(-1F, 0.1F),
                Climate.Parameter.point(0F)
        );
        NetherHelper.addBiome(
                Biomes.SOUL_SAND_VALLEY,
                Climate.Parameter.point(0F),
                Climate.Parameter.span(-0.6F, -0.4F),
                Climate.Parameter.span(-0.5F, 0F),
                Climate.Parameter.span(-1F, 0F)
        );
        NetherHelper.addBiome(
                Biomes.CRIMSON_FOREST,
                Climate.Parameter.span(0.3F, 0.5F),
                Climate.Parameter.point(0F),
                Climate.Parameter.span(-1F, 0F),
                Climate.Parameter.span(-1F, -0.7F)
        );
        NetherHelper.addBiome(
                Biomes.CRIMSON_FOREST,
                Climate.Parameter.span(0.3F, 0.5F),
                Climate.Parameter.point(0F),
                Climate.Parameter.span(-1F, 0F),
                Climate.Parameter.point(0F)
        );
        NetherHelper.addBiome(
                Biomes.CRIMSON_FOREST,
                Climate.Parameter.span(0.3F, 0.5F),
                Climate.Parameter.point(0F),
                Climate.Parameter.span(-1F, 0F),
                Climate.Parameter.point(1F)
        );
        NetherHelper.addBiome(
                Biomes.WARPED_FOREST,
                Climate.Parameter.point(0F),
                Climate.Parameter.span(0.4F, 0.6F),
                Climate.Parameter.span(-1F, 0F),
                Climate.Parameter.point(-1F),
                0.375F
        );
        NetherHelper.addBiome(
                Biomes.WARPED_FOREST,
                Climate.Parameter.point(0F),
                Climate.Parameter.span(0.4F, 0.6F),
                Climate.Parameter.span(-1F, 0F),
                Climate.Parameter.point(0F),
                0.375F
        );
        NetherHelper.addBiome(
                Biomes.WARPED_FOREST,
                Climate.Parameter.point(0F),
                Climate.Parameter.span(0.4F, 0.6F),
                Climate.Parameter.span(-1F, 0F),
                Climate.Parameter.span(0.7F, 1F),
                0.375F
        );
        NetherHelper.addBiome(
                Biomes.BASALT_DELTAS,
                Climate.Parameter.span(-0.6F, -0.4F),
                Climate.Parameter.point(0F),
                Climate.Parameter.span(-0.6F, 0F),
                Climate.Parameter.span(-1F, 0F),
                0.175F
        );
        NetherHelper.addBiome(
                Biomes.BASALT_DELTAS,
                Climate.Parameter.span(-0.6F, -0.4F),
                Climate.Parameter.point(0F),
                Climate.Parameter.span(-1F, -0.6F),
                Climate.Parameter.span(-1F, 1F),
                0.175F
        );
    }

    private static void end() {}

    private static void surfaceBiome(
            String path,
            ResourceKey<Biome> biome,
            Climate.Parameter temperature,
            Climate.Parameter humidity,
            Climate.Parameter continentalness,
            Climate.Parameter erosion,
            Climate.Parameter weirdness,
            long offset,
            Pair<RegistryAccess, BiConsumer<Identifier, BiomeInjector>> event
    ) {
        event.getSecond().accept(
                Legacies.id(path),
                BiomeInjector.builder(Level.OVERWORLD).addPoints(
                        new Climate.ParameterList<>(List.of(
                                Pair.of(
                                        new Climate.ParameterPoint(
                                                temperature,
                                                humidity,
                                                continentalness,
                                                erosion,
                                                Climate.Parameter.point(0F),
                                                weirdness,
                                                offset
                                        ),
                                        event.getFirst().getOrThrow(biome)
                                ),
                                Pair.of(
                                        new Climate.ParameterPoint(
                                                temperature,
                                                humidity,
                                                continentalness,
                                                erosion,
                                                Climate.Parameter.point(1F),
                                                weirdness,
                                                offset
                                        ),
                                        event.getFirst().getOrThrow(biome)
                                )
                        ))
                )
        );
    }

    private static void caveBiome(
            String path,
            ResourceKey<Biome> biome,
            Climate.Parameter temperature,
            Climate.Parameter humidity,
            Climate.Parameter continentalness,
            Climate.Parameter erosion,
            Climate.Parameter depth,
            Climate.Parameter weirdness,
            long offset,
            Pair<RegistryAccess, BiConsumer<Identifier, BiomeInjector>> event
    ) {
        event.getSecond().accept(
                Legacies.id(path),
                BiomeInjector.builder(Level.OVERWORLD).addPoints(
                        new Climate.ParameterList<>(List.of(
                                Pair.of(
                                        new Climate.ParameterPoint(
                                                temperature,
                                                humidity,
                                                continentalness,
                                                erosion,
                                                depth,
                                                weirdness,
                                                offset
                                        ),
                                        event.getFirst().getOrThrow(biome)
                                )
                        ))
                )
        );
    }
}
