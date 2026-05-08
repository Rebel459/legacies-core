package net.legacy.legacies.client.enderscape;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackCompatibility;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;

import java.util.List;
import java.util.Optional;

public final class EnderscapePack {
    public static final String PACK_ID = "old_assets_bridge/old_mod_assets";

    private EnderscapePack() {
    }

    public static Pack createPack() {
        PackLocationInfo location = new PackLocationInfo(
            PACK_ID,
            Component.literal("Old Mod Assets"),
            PackSource.BUILT_IN,
            Optional.empty()
        );

        Pack.ResourcesSupplier resources = new Pack.ResourcesSupplier() {
            @Override
            public EnderscapeResources openPrimary(PackLocationInfo location) {
                return new EnderscapeResources(location, EnderscapeJar.path(), EnderscapeJar.NAMESPACE);
            }

            @Override
            public EnderscapeResources openFull(PackLocationInfo location, Pack.Metadata metadata) {
                return new EnderscapeResources(location, EnderscapeJar.path(), EnderscapeJar.NAMESPACE);
            }
        };

        Pack.Metadata metadata = new Pack.Metadata(
            Component.literal("Enderscape Assets"),
            PackCompatibility.COMPATIBLE,
            FeatureFlagSet.of(),
            List.of()
        );

        PackSelectionConfig selection = new PackSelectionConfig(
            true,
            Pack.Position.BOTTOM,
            true
        );

        return new Pack(location, resources, metadata, selection);
    }
}