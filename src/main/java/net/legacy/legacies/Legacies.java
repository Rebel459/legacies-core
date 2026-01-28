package net.legacy.legacies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies.worldgen.LegaciesBiomeModifications;
import net.legacy.legacies.worldgen.LegaciesBiomePlacement;
import net.minecraft.resources.Identifier;

import java.util.Optional;

public class Legacies implements ModInitializer {

	@Override
	public void onInitialize() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(Legacies.MOD_ID);

        LegaciesBiomePlacement.init();
        LegaciesBiomeModifications.init();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(Legacies.MOD_ID, path);
	}
	public static final String MOD_ID = "legacies";
}