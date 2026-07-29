package net.rebel459.legacies.mixin.integration.bitsandbalance;

import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;
import org.onenonly.bitsandbalance.common.recipe.BaseBlockRecoveryRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BaseBlockRecoveryRecipe.class)
public class BaseBlockRecoveryRecipeMixin {

	@Inject(method = "matches(Lnet/minecraft/world/item/crafting/CraftingInput;Lnet/minecraft/world/level/Level;)Z", at = @At("HEAD"), cancellable = true)
	private void disable(CraftingInput input, Level level, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(false);
	}

	@Inject(method = "matches(Lnet/minecraft/world/item/crafting/RecipeInput;Lnet/minecraft/world/level/Level;)Z", at = @At("HEAD"), cancellable = true)
	private void disable(RecipeInput par1, Level par2, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(false);
	}
}