package net.legacy.legacies.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class RegistryHelper {

    public static ResourceKey<Biome> biome(String id) {
        return ResourceKey.create(Registries.BIOME, Identifier.parse(id));
    }
    public static TagKey<Biome> biomeTag(String id) {
        return TagKey.create(Registries.BIOME, Identifier.parse(id));
    }

    public static ResourceKey<PlacedFeature> placedFeature(String id) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.parse(id));
    }
}