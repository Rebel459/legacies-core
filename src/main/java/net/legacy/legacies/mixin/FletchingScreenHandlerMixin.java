package net.legacy.legacies.mixin;

import com.starshooterstudios.fletcher.fletcher.screen.FletchingScreenHandler;
import net.legacy.legacies.registry.LegaciesItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.ItemCombinerMenuSlotDefinition;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(value = FletchingScreenHandler.class)
public class FletchingScreenHandlerMixin {

    @Unique
    private static final Set<Item> hilts;

    @Unique
    private static final Set<Item> tips;

    @Unique
    private static ItemCombinerMenuSlotDefinition forgingSlotsManager;

    static {
        hilts = Set.of(Items.STICK, Items.BLAZE_ROD, Items.BREEZE_ROD);
        tips = Set.of(LegaciesItems.FLINT_SHARD, Items.IRON_NUGGET, Items.GOLD_NUGGET, Items.GLOWSTONE_DUST, Items.ECHO_SHARD, Items.ENDER_PEARL, Items.SLIME_BALL);
        forgingSlotsManager = null;
    }

    @Inject (
            method = "prepareSlots",
            at = @At
                    (
                            value = "HEAD"
                    ),
            cancellable = true
    )
    private static void modifyInputs(CallbackInfoReturnable<ItemCombinerMenuSlotDefinition> cir) {
        if (forgingSlotsManager != null) {
            cir.setReturnValue(forgingSlotsManager);
        } else {
            ItemCombinerMenuSlotDefinition.Builder builder = ItemCombinerMenuSlotDefinition.create();
            builder = (new FletchingScreenHandler.FletchingSlot(0, 26, 17, (itemStack) -> {
                return tips.contains(itemStack.getItem());
            }, (ResourceLocation) null)).addToBuilder(builder);
            builder = (new FletchingScreenHandler.FletchingSlot(1, 26, 35, (itemStack) -> {
                return hilts.contains(itemStack.getItem());
            }, ResourceLocation.fromNamespaceAndPath("fletcher", "container/fletching/hilt"))).addToBuilder(builder);
            for (int i = 2; i < 5; ++i) {
                builder = (new FletchingScreenHandler.FletchingSlot(i, 26 + (i - 2) * 18, 53, (itemStack) -> {
                    return itemStack.getItem().equals(Items.FEATHER);
                }, ResourceLocation.fromNamespaceAndPath("fletcher", "container/fletching/feather"))).addToBuilder(builder);
            }
            builder = (new FletchingScreenHandler.FletchingSlot(5, 62, 17, (itemStack) -> {
                return itemStack.getItem().equals(Items.SPLASH_POTION);
            }, ResourceLocation.fromNamespaceAndPath("fletcher", "container/fletching/potion"))).addToBuilder(builder);
            builder = builder.withResultSlot(6, 134, 35);
            forgingSlotsManager = builder.build();
            cir.setReturnValue(forgingSlotsManager);
        }
    }
}