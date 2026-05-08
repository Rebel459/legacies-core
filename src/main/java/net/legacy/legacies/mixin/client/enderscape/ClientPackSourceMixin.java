package net.legacy.legacies.mixin.client.enderscape;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.legacy.legacies.client.enderscape.EnderscapeJar;
import net.legacy.legacies.client.enderscape.EnderscapePack;
import net.minecraft.client.resources.ClientPackSource;
import net.minecraft.server.packs.repository.Pack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiConsumer;
import java.util.function.Function;

@Environment(EnvType.CLIENT)
@Mixin(ClientPackSource.class)
public abstract class ClientPackSourceMixin {

    @Inject(method = "populatePackList", at = @At("TAIL"))
    private void addEnderscapeAssets(BiConsumer<String, Function<String, Pack>> output, CallbackInfo ci) {
        if (!EnderscapeJar.isUsable()) {
            return;
        }

        output.accept(
            EnderscapePack.PACK_ID,
            ignoredId -> EnderscapePack.createPack()
        );
    }
}