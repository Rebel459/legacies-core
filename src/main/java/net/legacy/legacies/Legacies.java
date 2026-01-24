package net.legacy.legacies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies.util.NetherBiomeHelper;
import net.minecraft.resources.Identifier;

import java.util.Optional;

public class Legacies implements ModInitializer {

	@Override
	public void onInitialize() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(Legacies.MOD_ID);

        NetherBiomeHelper.init();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(Legacies.MOD_ID, path);
	}

	public static final String MOD_ID = "legacies";
}