package net.legacy.legacies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies.integration.MoreFoodLootTables;
import net.legacy.legacies.registry.LegaciesCreativeInventorySorting;
import net.legacy.legacies.registry.LegaciesItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class Legacies implements ModInitializer {

	@Override
	public void onInitialize() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer("legacies");

		LegaciesItems.init();
		LegaciesCreativeInventorySorting.init();

		MoreFoodLootTables.modifyLootTables();

		if (FabricLoader.getInstance().isModLoaded("hxp")) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(Legacies.MOD_ID,"legacies_hxp_integration"), modContainer.get(),
					Component.translatable("pack.legacies.hxp_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath("legacies", path);
	}

	public static final String MOD_ID = "legacies";
}