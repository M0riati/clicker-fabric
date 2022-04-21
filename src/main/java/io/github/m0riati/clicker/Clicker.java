package io.github.m0riati.clicker;

import net.fabricmc.api.ClientModInitializer;

public class Clicker implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClickerConfig.init();
    }

    public static int Cooldown() {
        switch (ClickerConfig.INSTANCE.cps) {
            case OEIGTH:
                return 160;
            case OQUARTER:
                return 80;
            case OHALF:
                return 40;
            case O1:
                return 20;
            case O2:
                return 10;
            case O4:
                return 5;
            case O5:
                return 4;
            case O10:
                return 2;
            case O20:
                return 1;
        }
        return 10;
    }
}