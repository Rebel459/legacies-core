package net.rebel459.legacies.client.enderscape;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipFile;

public final class EnderscapeJar {
    public static final String FILE_NAME = "enderscape-fabric-2.1.0+mc1.21.11.jar";
    public static final String NAMESPACE = "enderscape";

    private EnderscapeJar() {}

    public static Path path() {
        return FabricLoader.getInstance()
            .getGameDir()
            .resolve("mods")
            .resolve(FILE_NAME);
    }

    public static boolean isUsable() {
        Path jar = path();

        if (!Files.isRegularFile(jar)) {
            return false;
        }

        String prefix = "assets/" + NAMESPACE + "/";

        try (ZipFile zip = new ZipFile(jar.toFile())) {
            return zip.stream().anyMatch(entry ->
                !entry.isDirectory() && entry.getName().startsWith(prefix)
            );
        } catch (IOException e) {
            return false;
        }
    }
}