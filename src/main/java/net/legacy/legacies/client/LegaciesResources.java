package net.legacy.legacies.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.frozenblock.lib.resource_pack.api.client.FrozenLibModResourcePackApi;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

import java.io.File;

@Environment(EnvType.CLIENT)
public class LegaciesResources {
    private static final String VERSION_SUFFIX = "_v3";

    public static void init() {

        File disabledFile = Minecraft.getInstance().gameDirectory.toPath().resolve("config/fancymenu/assets/settings").resolve("downloads_disabled.txt").toFile();
        if (!disabledFile.exists()) {
            FrozenLibModResourcePackApi.downloadResourcePacks(createResources(), false, false);
        }
    }

    private static FrozenLibModResourcePackApi.PackDownloadGroup createResources() {
        FrozenLibModResourcePackApi.PackDownloadGroup resourceGroup = FrozenLibModResourcePackApi.PackDownloadGroup.create("legacies_resources");

        addResourcePack(resourceGroup, "day");
        addResourcePack(resourceGroup, "night");
        addResourcePack(resourceGroup, "rain");

        return resourceGroup;
    }

    private static void addResourcePack(@NotNull FrozenLibModResourcePackApi.PackDownloadGroup downloadGroup, String packName) {
        downloadGroup.add(
                "https://raw.githubusercontent.com/Rebel459/Legacies/refs/heads/main/resources/" + packName + VERSION_SUFFIX + ".json",
                "legacies_" + packName
        );
    }
}
