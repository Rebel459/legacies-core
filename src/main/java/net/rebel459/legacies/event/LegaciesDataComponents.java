package net.rebel459.legacies.event;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.enchantment.Enchantable;
import net.rebel459.legacies.util.RegistryHelper;
import net.rebel459.unified.platform.UnifiedEvents;

public class LegaciesDataComponents {

    public static void init() {
        UnifiedEvents.DefaultDataComponents.modify(((item, builder, provider) -> {
            ItemStack stack = item.getDefaultInstance();
            HolderLookup.RegistryLookup<Item> itemLookup = provider.lookupOrThrow(Registries.ITEM);
            if (stack.has(DataComponents.RARITY)) {
                Rarity rarity = stack.get(DataComponents.RARITY);
                if (rarity == Rarity.UNCOMMON) {
                    builder.set(DataComponents.TOOLTIP_STYLE, Identifier.withDefaultNamespace("custom/uncommon"));
                }
                if (rarity == Rarity.RARE) {
                    builder.set(DataComponents.TOOLTIP_STYLE, Identifier.withDefaultNamespace("custom/rare"));
                }
                if (rarity == Rarity.EPIC) {
                    builder.set(DataComponents.TOOLTIP_STYLE, Identifier.withDefaultNamespace("custom/epic"));
                }
            }
            if (RegistryHelper.matchesItem("enderscape:dagger", item, itemLookup) || RegistryHelper.matchesItem("enderscape:magnia_attractor", item, itemLookup)) {
                builder.set(DataComponents.ENCHANTABLE, new Enchantable(10));
            }
        }));
    }
}
