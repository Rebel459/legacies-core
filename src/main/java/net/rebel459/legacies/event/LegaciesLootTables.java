package net.rebel459.legacies.event;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.rebel459.legacies.util.RegistryHelper;
import net.rebel459.unified.platform.UnifiedEvents;
import net.rebel459.unified.util.LootEntry;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LegaciesLootTables {

    public static final ResourceKey<LootTable> DUNGEON_CHEST = registerLaL("chests/dungeon/chest");
    public static final ResourceKey<LootTable> DUNGEON_CHEST_SIMPLE = registerLaL("chests/dungeon/simple/chest");
    public static final ResourceKey<LootTable> DUNGEON_CHEST_DEEP = registerLaL("chests/dungeon/deep/chest");
    public static final ResourceKey<LootTable> DUNGEON_CHEST_ARID = registerLaL("chests/dungeon/arid/chest");
    public static final ResourceKey<LootTable> DUNGEON_CHEST_FROZEN = registerLaL("chests/dungeon/frozen/chest");
    public static final ResourceKey<LootTable> DUNGEON_CHEST_VERDANT = registerLaL("chests/dungeon/verdant/chest");
    public static final ResourceKey<LootTable> DUNGEON_CHEST_INFERNAL = registerLaL("chests/dungeon/infernal/chest");

    public static final List<ResourceKey<LootTable>> DUNGEON_CHESTS = List.of(
            DUNGEON_CHEST_SIMPLE,
            DUNGEON_CHEST_DEEP,
            DUNGEON_CHEST_ARID,
            DUNGEON_CHEST_FROZEN,
            DUNGEON_CHEST_VERDANT,
            DUNGEON_CHEST_INFERNAL
    );

    public static void init() {
        UnifiedEvents.LootTables.modify((table, key, provider) -> {
            if (DUNGEON_CHESTS.contains(key)) {
                table.editPool(item -> item == Items.MUSIC_DISC_CAT, LootEntry.insert(LootItem.lootTableItem(RegistryHelper.item("bitsandbalance:music_disc_dog")).setWeight(10)));
            }
        });
    }

    private static @NotNull ResourceKey<LootTable> registerLaL(String path) {
        return registerLaL("legacies_and_legends", path);
    }

    private static @NotNull ResourceKey<LootTable> registerLaL(String namespace, String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath(namespace, path));
    }
}
