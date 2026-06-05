package net.rebel459.legacies.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.components.debug.DebugScreenEntry;
import net.minecraft.client.gui.components.debug.DebugScreenEntryList;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = DebugScreenEntryList.class)
public class DebugScreenEntryListMixin {

	@WrapOperation(
			method = "lambda$rebuildCurrentList$0",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/gui/components/debug/DebugScreenEntry;isAllowed(Z)Z"
			)
	)
	private boolean rebuildRebalancedDebugInfo(DebugScreenEntry instance, boolean reducedDebugInfo, Operation<Boolean> original, @Local(ordinal = 0, argsOnly = true) Identifier key) {
		if (key.equals(Identifier.withDefaultNamespace("chunk_borders"))) return true;
		if (key.equals(Identifier.withDefaultNamespace("entity_hitboxes"))) return true;
		return original.call(instance, reducedDebugInfo);
	}
}