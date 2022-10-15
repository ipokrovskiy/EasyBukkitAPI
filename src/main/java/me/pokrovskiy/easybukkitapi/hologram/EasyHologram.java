package me.pokrovskiy.easybukkitapi.hologram;

import me.pokrovskiy.easybukkitapi.EasyBukkitAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class EasyHologram implements Hologram, Listener {

    private Location location;
    private List<String> hologram;
    private List<ArmorStand> holoEntities;

    private HologramUsable usable;
    private ArmorStand holo;


    public EasyHologram(Location location){
        this.location = location;
        this.hologram = new ArrayList<>();
        this.holoEntities = new ArrayList<>();
    }

    @Override
    public Hologram addAnimatedLore(String[] animatedText, int delay) {
        addLore(animatedText[0]);
        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                changeLore(hologram.indexOf(animatedText[i]), animatedText[i == animatedText.length-1 ? 0 : i+1]);
                if(i < animatedText.length) i++;
                if(i == animatedText.length) i = 0;

            }
        }.runTaskTimer(EasyBukkitAPI.getInstance(), 0, delay);
        return this;
    }
    @Override
    public Hologram addLore(String text) {
        hologram.add(text);
        return this;
    }

    @Override
    public Hologram setLore(List<String> lore) {
        hologram = lore;
        return this;
    }

    @Override
    public Hologram onClick(HologramUsable usable) {
        this.usable = usable;
        Bukkit.getPluginManager().registerEvents(this, EasyBukkitAPI.getInstance());
        return this;
    }

    @Override
    public void changeLore(int index, String text) {
        hologram.set(index, text);
        holoEntities.get(index).setCustomName(text);
    }

    @EventHandler
    public void onHoloClick(PlayerInteractAtEntityEvent event) {
        if(holoEntities.contains(event.getRightClicked())) usable.onClick(event);
    }
    @Override
    public void spawn() {
        for(String text : hologram) {
            holo = location.getWorld().spawn(location.add(0, -0.4,0), ArmorStand.class);
            holo.setCustomNameVisible(true);
            holo.setCustomName(text);
            holo.setGravity(false);
            holo.setVisible(false);
            holoEntities.add(holo);
        }
    }

    @Override
    public void kill() {
        holoEntities.forEach(holo -> {
            holo.remove();
        });
        holoEntities.clear();
    }
}
