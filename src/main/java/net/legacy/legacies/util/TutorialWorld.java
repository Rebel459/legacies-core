package net.legacy.legacies.util;

import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class TutorialWorld {
    public static int tutorialCopy;

    public static void replaceWorld(Path backupDir, Path targetDir) throws IOException {
        if (!Files.exists(backupDir)) {
            throw new IOException("Backup directory does not exist: " + backupDir);
        }
        if (Files.notExists(targetDir)) {
            Files.createDirectories(targetDir);
            tutorialCopy = 1;
        }
        else {
            while (Files.exists(Path.of(targetDir + "-" + tutorialCopy)) || tutorialCopy < 2) {
                tutorialCopy += 1;
            }
            targetDir = Path.of(targetDir + "-" + tutorialCopy);
            Files.createDirectory(targetDir);
        }

        try (Stream<Path> entries = Files.walk(backupDir)) {
            Path finalTargetDir = targetDir;
            entries.forEach(sourcePath -> {
                try {
                    Path targetPath = finalTargetDir.resolve(backupDir.relativize(sourcePath));
                        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public static void process(String world) throws IOException {
        Path savesDir = Minecraft.getInstance().gameDirectory.toPath().resolve("saves");
        Path templatesDir = Minecraft.getInstance().gameDirectory.toPath().resolve("config/legacies/tutorial_worlds");
        Path backupDir = templatesDir.resolve(world);
        Path tutorialDir = savesDir.resolve(world);

        TutorialWorld.replaceWorld(backupDir, tutorialDir);
    }
}