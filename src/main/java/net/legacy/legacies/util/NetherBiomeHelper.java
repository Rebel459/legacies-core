package net.legacy.legacies.util;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;

import java.util.ArrayList;
import java.util.List;

public class NetherBiomeHelper {
    public static List<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> NETHER_BIOMES = new ArrayList<>();

	public static void init() {
		addBiome(
			Biomes.NETHER_WASTES,
			Climate.Parameter.point(0F),
			Climate.Parameter.point(0F),
			Climate.Parameter.span(-1F, 0F),
			Climate.Parameter.span(-1F, -0.7F)
		);
		addBiome(
			Biomes.NETHER_WASTES,
			Climate.Parameter.point(0F),
			Climate.Parameter.point(0F),
			Climate.Parameter.span(-1F, 0F),
			Climate.Parameter.span(0.7F, 1F)
		);
		addBiome(
			Biomes.NETHER_WASTES,
			Climate.Parameter.span(-0.1F, 0.1F),
			Climate.Parameter.span(-0.1F, 0.1F),
			Climate.Parameter.span(-1F, 0.1F),
			Climate.Parameter.point(0F)
		);
		addBiome(
			Biomes.SOUL_SAND_VALLEY,
			Climate.Parameter.point(0F),
			Climate.Parameter.span(-0.6F, -0.4F),
			Climate.Parameter.span(-0.5F, 0F),
			Climate.Parameter.span(-1F, 0F)
		);
		addBiome(
			Biomes.CRIMSON_FOREST,
			Climate.Parameter.span(0.3F, 0.5F),
			Climate.Parameter.point(0F),
			Climate.Parameter.span(-1F, 0F),
			Climate.Parameter.span(-1F, -0.7F)
		);
		addBiome(
			Biomes.CRIMSON_FOREST,
			Climate.Parameter.span(0.3F, 0.5F),
			Climate.Parameter.point(0F),
			Climate.Parameter.span(-1F, 0F),
			Climate.Parameter.point(0F)
		);
		addBiome(
			Biomes.CRIMSON_FOREST,
			Climate.Parameter.span(0.3F, 0.5F),
			Climate.Parameter.point(0F),
			Climate.Parameter.span(-1F, 0F),
			Climate.Parameter.point(1F)
		);
		addBiome(
			Biomes.WARPED_FOREST,
			Climate.Parameter.point(0F),
			Climate.Parameter.span(0.4F, 0.6F),
			Climate.Parameter.span(-1F, 0F),
			Climate.Parameter.point(-1F),
			0.375F
		);
		addBiome(
			Biomes.WARPED_FOREST,
			Climate.Parameter.point(0F),
			Climate.Parameter.span(0.4F, 0.6F),
			Climate.Parameter.span(-1F, 0F),
			Climate.Parameter.point(0F),
			0.375F
		);
		addBiome(
			Biomes.WARPED_FOREST,
			Climate.Parameter.point(0F),
			Climate.Parameter.span(0.4F, 0.6F),
			Climate.Parameter.span(-1F, 0F),
			Climate.Parameter.span(0.7F, 1F),
			0.375F
		);
		addBiome(
			Biomes.BASALT_DELTAS,
			Climate.Parameter.span(-0.6F, -0.4F),
			Climate.Parameter.point(0F),
			Climate.Parameter.span(-0.6F, 0F),
			Climate.Parameter.span(-1F, 0F),
			0.175F
		);
		addBiome(
			Biomes.BASALT_DELTAS,
			Climate.Parameter.span(-0.6F, -0.4F),
			Climate.Parameter.point(0F),
			Climate.Parameter.span(-1F, -0.6F),
			Climate.Parameter.span(-1F, 1F),
			0.175F
		);
	}

	public static void addBiome(ResourceKey<Biome> biome, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter region, Climate.Parameter depth) {
		addBiome(biome, temperature, humidity, region, depth, 0F);
	}
	public static void addBiome(ResourceKey<Biome> biome, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter region, Climate.Parameter depth, float offset) {
		NETHER_BIOMES.add(
			Pair.of(
				Climate.parameters(
					temperature,
					humidity,
					region,
					Climate.Parameter.point(0F),
					depth,
					Climate.Parameter.point(0F),
					offset
				),
				biome
			)
		);
	}
}