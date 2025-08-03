package net.legacy.legacies.registry;

import net.legacy.legacies.Legacies;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class LegaciesItems {

    // Items
    public static final Item FLINT_SHARD = register("flint_shard",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function, @NotNull Properties properties) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, Legacies.id(name)), function, properties);
    }
}
