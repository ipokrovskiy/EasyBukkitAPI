package me.pokrovskiy.easybukkitapi.item;

import me.pokrovskiy.easybukkitapi.EasyBukkitAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class EasyItem implements Item, Listener {

    private String name;
    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private List<String> lore;
    private ItemUsable usable;


    public EasyItem(Material material){
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
        name = itemMeta.getDisplayName();
        lore = new ArrayList<>();
    }

    @Override
    public Item setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Item addLore(String text) {
        lore.add(text);
        return this;
    }

    @Override
    public Item setLore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    @Override
    public Item addEnchantment(Enchantment enchantment, int level) {
        itemMeta.addEnchant(enchantment, level, true);
        return this;
    }

    @Override
    public Item setDurability(short durability) {
        itemStack.setDurability(durability);
        return this;
    }

    @Override
    public Item removeAllFlags(){
        itemMeta.removeItemFlags();
        return this;
    }

    @Override
    public ItemStack create() {
        itemMeta.setLore(lore);
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override
    public Item onUsable(ItemUsable usable) {
        this.usable = usable;
        Bukkit.getPluginManager().registerEvents(this, EasyBukkitAPI.getInstance());
        return this;
    }



    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        if(event.getItem() != null) {
            if(event.getItem().getItemMeta().equals(itemStack.getItemMeta())) usable.onUsable(event);
        }

    }
}
