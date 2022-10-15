package me.pokrovskiy.easybukkitapi.item;

import org.bukkit.event.player.PlayerInteractEvent;

public interface ItemUsable {

    void onUsable(PlayerInteractEvent event);

}
