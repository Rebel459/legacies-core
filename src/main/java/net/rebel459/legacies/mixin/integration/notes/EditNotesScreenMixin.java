package net.rebel459.legacies.mixin.integration.notes;

import com.chaosthedude.notes.gui.EditNoteScreen;
import com.chaosthedude.notes.gui.NotesButton;
import com.chaosthedude.notes.gui.NotesTextField;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.rebel459.legacies.tag.LegaciesItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EditNoteScreen.class)
public class EditNotesScreenMixin {

	@Shadow
	private NotesTextField noteTextField;

	@Shadow
	private NotesButton insertBiomeButton;

	@Shadow
	private NotesButton insertChunkButton;

	@Shadow
	private NotesButton insertCoordsButton;

	@Inject(method = "tick", at = @At("HEAD"), cancellable = true)
	private void enforceNoteItems(CallbackInfo ci) {
		Player player = Minecraft.getInstance().player;
		if (player == null || !player.isReducedDebugInfo()) return;
		Inventory inventory = player.getInventory();
		boolean isFocused = this.noteTextField.isFocused();
		this.insertBiomeButton.active = isFocused && inventory.contains(LegaciesItemTags.PROVIDES_BIOME);
		this.insertChunkButton.active = this.insertCoordsButton.active = isFocused && inventory.contains(LegaciesItemTags.PROVIDES_COORDINATES);
		ci.cancel();
	}
}