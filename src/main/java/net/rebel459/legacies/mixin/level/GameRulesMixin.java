package net.rebel459.legacies.mixin.level;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.gui.screens.debug.DebugOptionsScreen;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = GameRules.class)
public class GameRulesMixin {

	@WrapOperation(
			method = "<clinit>",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/gamerules/GameRules;registerBoolean(Ljava/lang/String;Lnet/minecraft/world/level/gamerules/GameRuleCategory;Z)Lnet/minecraft/world/level/gamerules/GameRule;",
					ordinal = 30
			)
	)
	private static GameRule<Boolean> reducedDebugInfo(String id, GameRuleCategory category, boolean defaultValue, Operation<GameRule<Boolean>> original) {
		return original.call(id, category, true);
	}
}