package net.legacy.legacies.client.enderscape;

import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.server.packs.resources.IoSupplier;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class EnderscapeResources implements PackResources {
    private final PackLocationInfo location;
    private final String namespace;
    private final ZipFile zip;

    public EnderscapeResources(PackLocationInfo location, Path jarPath, String namespace) {
        this.location = location;
        this.namespace = namespace;

        try {
            this.zip = new ZipFile(jarPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Failed to open legacy asset jar: " + jarPath, e);
        }
    }

    @Override
    public PackLocationInfo location() {
        return this.location;
    }

    @Override
    public @Nullable IoSupplier<InputStream> getRootResource(String... paths) {
        return null;
    }

    @Override
    public @Nullable IoSupplier<InputStream> getResource(PackType type, Identifier id) {
        if (type != PackType.CLIENT_RESOURCES) {
            return null;
        }

        if (!id.getNamespace().equals(this.namespace)) {
            return null;
        }

        String entryName = "assets/" + id.getNamespace() + "/" + id.getPath();
        ZipEntry entry = this.zip.getEntry(entryName);

        if (entry == null || entry.isDirectory()) {
            return null;
        }

        return () -> this.zip.getInputStream(entry);
    }

    @Override
    public void listResources(
        PackType type,
        String namespace,
        String path,
        ResourceOutput output
    ) {
        if (type != PackType.CLIENT_RESOURCES) {
            return;
        }

        if (!namespace.equals(this.namespace)) {
            return;
        }

        String root = "assets/" + namespace + "/";
        String prefix = root + normalizeDirectory(path);

        this.zip.stream().forEach(entry -> {
            if (entry.isDirectory()) {
                return;
            }

            String name = entry.getName();

            if (!name.startsWith(prefix)) {
                return;
            }

            String relative = name.substring(root.length());

            Identifier id = Identifier.tryBuild(namespace, relative);
            if (id == null) {
                return;
            }

            output.accept(id, () -> this.zip.getInputStream(entry));
        });
    }

    @Override
    public Set<String> getNamespaces(PackType type) {
        if (type == PackType.CLIENT_RESOURCES) {
            return Set.of(this.namespace);
        }

        return Set.of();
    }

    @Override
    public @org.jspecify.annotations.Nullable <T> T getMetadataSection(MetadataSectionType<T> metadataSerializer) throws IOException {
        return null;
    }

    @Override
    public void close() {
        try {
            this.zip.close();
        } catch (IOException ignored) {
        }
    }

    private static String normalizeDirectory(String path) {
        if (path.isEmpty()) {
            return "";
        }

        return path.endsWith("/") ? path : path + "/";
    }
}