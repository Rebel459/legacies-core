package net.rebel459.legacies;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Screenshot;
import net.rebel459.unified.platform.client.UnifiedClientEvents;
import net.rebel459.unified.platform.client.UnifiedClientRegistries;
import net.rebel459.unified.util.EventType;
import org.lwjgl.glfw.GLFW;

import java.util.function.Supplier;

public class LegaciesClient implements ClientModInitializer {

    public static final Supplier<KeyMapping> SCREENSHOT_KEY = UnifiedClientRegistries.KeyMappings.create(Legacies.MOD_ID).registerKeybind(
            "screenshot",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_F2,
            KeyMapping.Category.MISC
    );

    @Override
    public void onInitializeClient() {
        UnifiedClientEvents.Instance.onTick(EventType.POST, client -> {
            while (SCREENSHOT_KEY.get().consumeClick()) {
                Screenshot.grab(
                        client.gameDirectory,
                        client.getMainRenderTarget(),
                        message -> {
                            if (client.player != null) client.player.sendSystemMessage(message);
                        }
                );
            }
        });
    }
}