package net.legacy.legacies.mixin.client;

import net.legacy.legacies.util.TutorialWorld;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Component title) {
        super(title);
    }

    @Inject(method = "init", at = @At("HEAD"))
    private void addCustomButton(CallbackInfo ci) {
        this.addRenderableWidget(Button.builder(Component.translatable("menu.legacies.tutorial"), (button) -> {
            try {
                TutorialWorld.process("tutorial");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).bounds(20, 20, 100, 20).build());
    }
}