package net.legacy.legacies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies.registry.LegaciesCreativeInventorySorting;
import net.legacy.legacies.registry.LegaciesItems;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class Legacies implements ModInitializer {

	@Override
	public void onInitialize() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(Legacies.MOD_ID);

		LegaciesItems.init();
		LegaciesCreativeInventorySorting.init();
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(Legacies.MOD_ID, path);
	}

	public static final String MOD_ID = "legacies";
}