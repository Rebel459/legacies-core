package net.legacy.legacies.worldgen;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.biome.sub.BiomeParameterTargets;
import com.terraformersmc.biolith.api.biome.sub.Criterion;
import com.terraformersmc.biolith.api.biome.sub.CriterionBuilder;
import net.legacy.legacies.Legacies;
import net.legacy.legacies.util.NetherHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;

import java.util.ArrayList;
import java.util.List;

public class LegaciesBiomePlacement {

    public static void init() {
        overworld();
        nether();
        end();
    }

    private static void overworld() {
        BiomePlacement.addSubOverworld(
                Biomes.FOREST,
                Legacies.getBiome("wilderwild:dying_forest"),
                CriterionBuilder.allOf(
                        neighboringAny(Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.FROZEN_RIVER),
                        CriterionBuilder.value(BiomeParameterTargets.TEMPERATURE, -0.45F, 0.15F)
                )
        );
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

    @SafeVarargs
    private static Criterion neighboringAny(ResourceKey<Biome>... biomes) {
        final List<Criterion> criterions = new ArrayList<>();
        for (ResourceKey<Biome> biome : biomes) criterions.add(CriterionBuilder.neighbor(biome));
        return CriterionBuilder.anyOf(criterions);
    }
}
