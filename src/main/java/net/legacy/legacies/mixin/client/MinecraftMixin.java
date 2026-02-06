package net.legacy.legacies.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.logging.LogUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.legacy.legacies.client.LegaciesDefaultOptions;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Environment(EnvType.CLIENT)
@Mixin(value = Minecraft.class)
public class MinecraftMixin {
	
	@WrapOperation(method = "<init>(Lnet/minecraft/client/main/GameConfig;)V", at = @At(value = "INVOKE", target = "Ljava/io/File;toPath()Ljava/nio/file/Path;", ordinal = 0))
	private static Path init(File instance, Operation<Path> original) {
        try {
            LegaciesDefaultOptions.init();
        } catch (IOException e) {
            LogUtils.getLogger().warn("Failed to register Legacies default options");
        }
        return original.call(instance);
    }
}