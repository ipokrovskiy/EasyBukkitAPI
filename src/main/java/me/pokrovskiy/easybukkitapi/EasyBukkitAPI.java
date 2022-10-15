package me.pokrovskiy.easybukkitapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EasyBukkitAPI extends JavaPlugin {

    private static EasyBukkitAPI instance;
    public static EasyBukkitAPI getInstance(){
        return instance;
    }

    @Override
    public void onLoad(){
        instance = this;
    }
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aEasyBukkitAPI §7[v" + this.getDescription().getVersion() + "§7] §a[ENABLED]");
        Bukkit.getConsoleSender().sendMessage("§8developed by §fpokrovskiy §8-> §9vk.com/pokrovskiy2016");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§aEasyBukkitAPI §7[v" + this.getDescription().getVersion() + "§7] §c[DISABLED]");
    }
}
