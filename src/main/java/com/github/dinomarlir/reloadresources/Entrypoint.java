package com.github.dinomarlir.reloadresources;

import net.fabricmc.api.ModInitializer;
import net.minecraft.network.chat.Component;

public class Entrypoint implements ModInitializer {

    @Override
    public void onInitialize() {
        System.out.println("----------------------------------------------------------");
        System.out.println(Component.translatable("menu.reload_resources").getString());
        System.out.println("----------------------------------------------------------");
    }
}
