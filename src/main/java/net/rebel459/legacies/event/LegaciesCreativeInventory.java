package net.rebel459.legacies.event;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.rebel459.legacies.util.RegistryHelper;

public class LegaciesCreativeInventory {

    public static void init() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.insertAfter(Items.MAP, RegistryHelper.item("map_atlases:atlas"));
        });
    }
}
