package net.legacy.legacies;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ClientModInitializer;
import net.legacy.legacies.client.LegaciesResources;
import net.legacy.legacies.client.LegaciesSettings;

import java.io.IOException;

public class LegaciesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        try {
            LegaciesSettings.init();
        } catch (IOException e) {
            LogUtils.getLogger().warn("Failed to register Legacies settings");
        }

        LegaciesResources.init();
    }
}