package net.legacy.legacies.mixin.integration.tca;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = Item.class, priority = 1500)
public abstract class TCAItemMixin {

    @TargetHandler(
            mixin = "net.frozenblock.thecopperierage.mixin.item.ItemMixin",
            name = "theCopperierAge$getNonWeatheringNonWaxedName"
    )
    @ModifyExpressionValue(
            method = "@MixinSquared:Handler",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/lang/Boolean;booleanValue()Z"
            )
    )
    private boolean disableTCACopperTooltips(boolean original) {
        return false;
    }
}
