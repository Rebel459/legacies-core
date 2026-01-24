package net.legacy.legacies;

import net.fabricmc.api.ClientModInitializer;
import net.legacy.legacies.client.LegaciesResources;

public class LegaciesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        LegaciesResources.init();
    }
}