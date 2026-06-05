package net.rebel459.legacies;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import net.rebel459.legacies.event.LegaciesDataComponents;
import net.rebel459.legacies.event.LegaciesLootTables;
import net.rebel459.legacies.worldgen.LegaciesBiomeModifications;
import net.rebel459.legacies.worldgen.LegaciesBiomePlacement;

public class Legacies implements ModInitializer {

	@Override
	public void onInitialize() {
        LegaciesBiomePlacement.init();
        LegaciesBiomeModifications.init();
		LegaciesDataComponents.init();
		LegaciesLootTables.init();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(Legacies.MOD_ID, path);
	}
	public static final String MOD_ID = "legacies";
}