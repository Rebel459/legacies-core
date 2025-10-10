package net.legacy.legacies;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies.client.LegaciesResources;
import net.legacy.legacies.registry.LegaciesCreativeInventorySorting;
import net.legacy.legacies.registry.LegaciesItems;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class LegaciesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        LegaciesResources.init();
    }
}