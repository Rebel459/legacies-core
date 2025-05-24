package net.legacy.legacies.registry;

import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class LegaciesCreativeInventorySorting {

    public static void init() {
        addBeforeInIngredients(Items.FLINT, LegaciesItems.FLINT_SHARD);
    }

    private static void addBeforeInIngredients(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.INGREDIENTS);
    }

}