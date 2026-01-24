package net.legacy.legacies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies.util.NetherHelper;
import net.legacy.legacies.worldgen.LegaciesBiomePlacement;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.Optional;

public class Legacies implements ModInitializer {

	@Override
	public void onInitialize() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(Legacies.MOD_ID);

        LegaciesBiomePlacement.init();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(Legacies.MOD_ID, path);
	}
	public static final String MOD_ID = "legacies";

    public static ResourceKey<Biome> getBiome(String id) {
        return ResourceKey.create(Registries.BIOME, Identifier.parse(id));
    }
}