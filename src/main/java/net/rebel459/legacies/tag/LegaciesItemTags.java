package net.rebel459.legacies.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.rebel459.legacies.Legacies;
import org.jetbrains.annotations.NotNull;

public class LegaciesItemTags {
    public static final TagKey<Item> PROVIDES_BIOME = create("provides_biome");
    public static final TagKey<Item> PROVIDES_COORDINATES = create("provides_coordinates");

    @NotNull
    private static TagKey<Item> create(@NotNull String path) {
        return TagKey.create(Registries.ITEM, Legacies.id(path));
    }
}