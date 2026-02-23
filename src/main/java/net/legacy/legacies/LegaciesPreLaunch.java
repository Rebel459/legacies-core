package net.legacy.legacies;

import com.mojang.logging.LogUtils;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.legacy.legacies.client.LegaciesDefaultOptions;

import java.io.IOException;

public final class LegaciesPreLaunch implements PreLaunchEntrypoint {

    @Override
    public void onPreLaunch() {
        try {
            LegaciesDefaultOptions.init();
        } catch (IOException e) {
            LogUtils.getLogger().warn("Failed to register Legacies default options");
        }
    }
}