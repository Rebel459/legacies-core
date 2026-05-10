package net.rebel459.legacies.worldgen;

import net.rebel459.legacies.util.NetherHelper;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;

public class LegaciesBiomePlacement {

    public static void init() {
        overworld();
        nether();
        end();
    }

    private static void overworld() {}

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

}
