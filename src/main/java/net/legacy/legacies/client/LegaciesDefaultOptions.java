package net.legacy.legacies.client;

import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class LegaciesDefaultOptions {

    public static Path ROOT = Minecraft.getInstance().gameDirectory.toPath();
    public static Path DEFAULTS = ROOT.resolve("config/legacies/defaults");

    public static void init() throws IOException {
        if (!Files.isDirectory(DEFAULTS)) {
            return;
        }

        List<Path> defaultFiles;
        try (var stream = Files.walk(DEFAULTS)) {
            defaultFiles = stream
                    .filter(Files::isRegularFile)
                    .toList();
        }

        for (Path sourceFile : defaultFiles) {
            Path relative = DEFAULTS.relativize(sourceFile);
            Path targetFile = ROOT.resolve(relative);

            if (!Files.exists(targetFile)) {
                Path parent = targetFile.getParent();
                if (parent != null) {
                    Files.createDirectories(parent);
                }
                Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
