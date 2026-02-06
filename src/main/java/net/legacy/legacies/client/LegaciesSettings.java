package net.legacy.legacies.client;

import net.minecraft.client.Minecraft;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LegaciesSettings {

    public static Path SETTINGS = Minecraft.getInstance().gameDirectory.toPath().resolve("config/fancymenu/assets/settings");

    public static void init() throws IOException {
        if (!Files.exists(SETTINGS)) Files.createDirectories(SETTINGS);
        registerBoolean("downloads", true);
    }

    private static void registerBoolean(String name, boolean enabled) throws IOException {
        if (!SETTINGS.resolve(name + "_disabled.txt").toFile().exists() && !SETTINGS.resolve(name + "_enabled.txt").toFile().exists()) {
            String suffix = "enabled";
            if (!enabled) suffix = "disabled";
            File file = new File(SETTINGS.toFile(), name + "_" + suffix + ".txt");
            file.createNewFile();
        }
    }
    public static boolean getBoolean(String name) {
        return !SETTINGS.resolve(name + "_disabled.txt").toFile().exists();
    }
}
