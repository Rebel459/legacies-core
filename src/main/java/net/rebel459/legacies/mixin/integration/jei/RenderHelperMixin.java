package net.rebel459.legacies.mixin.integration.jei;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import mezz.jei.fabric.platform.RenderHelper;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = RenderHelper.class, remap = false)
public abstract class RenderHelperMixin {

    @ModifyExpressionValue(
            method = "renderTooltip(Lnet/minecraft/client/gui/GuiGraphicsExtractor;Ljava/util/List;IILnet/minecraft/client/gui/Font;Lnet/minecraft/world/item/ItemStack;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;get(Lnet/minecraft/core/component/DataComponentType;)Ljava/lang/Object;",
                    remap = true
            )
    )
    private Object renderTooltipStyle(Object original, @Local(argsOnly = true, name = "stack") ItemStack stack) {
        return useTooltipStyle(original, stack);
    }

    @ModifyExpressionValue(
            method = "renderTooltip(Lnet/minecraft/client/gui/GuiGraphicsExtractor;Ljava/util/List;IILnet/minecraft/client/gui/Font;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/client/gui/screens/inventory/tooltip/ClientTooltipPositioner;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;get(Lnet/minecraft/core/component/DataComponentType;)Ljava/lang/Object;",
                    remap = true
            )
    )
    private Object renderTooltipStylePositioned(Object original, @Local(argsOnly = true, name = "stack") ItemStack stack) {
        return useTooltipStyle(original, stack);
    }

    @Unique
    private Object useTooltipStyle(Object original, ItemStack stack) {
        if (original != null) return original;
        return stack.getItem().components().get(DataComponents.TOOLTIP_STYLE);
    }
}