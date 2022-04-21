package io.github.m0riati.clicker;


import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.EnumHandler;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import static me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON;

@Config(name = "clicker")
public class ClickerConfig implements ConfigData {
    public static ClickerConfig INSTANCE;

    public static void init() {
        AutoConfig.register(ClickerConfig.class, JanksonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(ClickerConfig.class).getConfig();
    }

    public enum CPS {
        OEIGTH, OQUARTER, OHALF, O1, O2, O4, O5, O10, O20;

        @Override
        public String toString() {
            return "text.autoconfig.clicker.option.cps." + this.name().toLowerCase();
        }
    }

    @Comment("Click frequency of holding the LMB")
    @EnumHandler(option = BUTTON)
    CPS cps = CPS.O10;
}
