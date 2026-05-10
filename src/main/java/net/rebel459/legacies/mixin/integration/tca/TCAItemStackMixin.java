package net.rebel459.legacies.mixin.integration.tca;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.WeatheringCopper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(value = ItemStack.class, priority = 1500)
public abstract class TCAItemStackMixin {

    @TargetHandler(
            mixin = "net.frozenblock.thecopperierage.mixin.item.ItemStackMixin",
            name = "theCopperierAge$addWeatheringAndWaxedTooltips"
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

    @TargetHandler(
            mixin = "net.frozenblock.thecopperierage.mixin.item.ItemStackMixin",
            name = "theCopperierAge$addWeatherStateTooltip"
    )
    @Inject(method = "@MixinSquared:Handler", at = @At(value = "HEAD"), cancellable = true)
    private static void cancelTCACopperTooltips(Consumer<Component> consumer, WeatheringCopper.WeatherState weatherState, CallbackInfo ci) {
        ci.cancel();
    }
}
