package me.pokrovskiy.easybukkitapi.hologram;

import java.util.List;

public interface Hologram {

    Hologram addLore(String text);
    Hologram setLore(List<String> lore);

    Hologram onClick(HologramUsable usable);

    Hologram addAnimatedLore(String[] animatedText, int delay);

    void changeLore(int index, String text);

    void spawn();

    void kill();

}
