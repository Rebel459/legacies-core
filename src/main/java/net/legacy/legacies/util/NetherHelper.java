package net.legacy.legacies.util;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;

import java.util.ArrayList;
import java.util.List;

public class NetherHelper {
    public static List<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> NETHER_BIOMES = new ArrayList<>();

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