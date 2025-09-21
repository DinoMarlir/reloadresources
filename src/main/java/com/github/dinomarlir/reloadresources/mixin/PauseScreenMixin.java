package com.github.dinomarlir.reloadresources.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PauseScreen.class)
public abstract class PauseScreenMixin extends Screen {

    protected PauseScreenMixin(Component title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void addReloadButton(CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        Component label = Component.translatable("menu.reload_resources");

        // Berechne die Breite des Textes + Padding
        int textWidth = mc.font.width(label);
        int padding = 10;
        int buttonWidth = Math.min(textWidth + padding, 150); // max 150 px

        // Positioniere den Button unten rechts mit 10px Abstand zum Rand
        int x = this.width - buttonWidth - 10;
        int y = this.height - 30;

        this.addRenderableWidget(Button.builder(
                label,
                button -> mc.reloadResourcePacks()
        ).bounds(x, y, buttonWidth, 20).build());
    }

}
