package net.legacy.legacies.mixin;

import com.starshooterstudios.fletcher.fletcher.ArrowItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;
import java.util.Map;

import static com.starshooterstudios.fletcher.fletcher.ArrowItems.registeredArrows;

@Mixin(value = ArrowItems.class)
public class ArrowItemsMixin {

    @Inject (
            method = "getTip",
            at = @At
                    (
                            value = "HEAD"
                    ),
                    cancellable = true
            )
    private static void modifyInputs(Item item, CallbackInfoReturnable<ArrowItems.Tip> cir) {
        if (item.equals(Items.IRON_INGOT)) {
            cir.setReturnValue(ArrowItems.Tip.IRON_NUGGET);
        } else if (item.equals(Items.GOLD_INGOT)) {
            cir.setReturnValue(ArrowItems.Tip.GOLD_NUGGET);
        } else if (item.equals(Items.GLOWSTONE_DUST)) {
            cir.setReturnValue(ArrowItems.Tip.GLOWSTONE_DUST);
        } else if (item.equals(Items.ECHO_SHARD)) {
            cir.setReturnValue(ArrowItems.Tip.ECHO_SHARD);
        } else if (item.equals(Items.ENDER_PEARL)) {
            cir.setReturnValue(ArrowItems.Tip.ENDER_PEARL);
        } else if (item.equals(Items.SLIME_BALL)) {
            cir.setReturnValue(ArrowItems.Tip.SLIMEBALL);
        } else {
            Iterator var1 = registeredArrows.values().iterator();
            while(var1.hasNext()) {
                Map<ArrowItems.Tip, Item> m = (Map)var1.next();
                Iterator var3 = m.keySet().iterator();
                while(var3.hasNext()) {
                    ArrowItems.Tip tip = (ArrowItems.Tip)var3.next();
                    if (((Item)m.get(tip)).equals(item)) {
                        cir.setReturnValue(tip);
                    }
                }
            }
            cir.setReturnValue(ArrowItems.Tip.FLINT);
        }
    }
}