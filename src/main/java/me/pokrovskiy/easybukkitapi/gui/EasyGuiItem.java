package me.pokrovskiy.easybukkitapi.gui;

import me.pokrovskiy.easybukkitapi.EasyBukkitAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class EasyGuiItem implements GuiItem, Listener {

    private String name;
    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private List<String> lore;
    private GuiUsable usable;
    private Inventory inventory;


    public EasyGuiItem(Material material){
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
        name = itemMeta.getDisplayName();
        lore = new ArrayList<>();
        inventory = null;
    }

    @Override
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public GuiItem setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public GuiItem addLore(String text) {
        lore.add(text);
        return this;
    }

    @Override
    public GuiItem setLore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    @Override
    public GuiItem addEnchantment(Enchantment enchantment, int level) {
        itemMeta.addEnchant(enchantment, level, true);
        return this;
    }

    @Override
    public GuiItem setDurability(short durability) {
        itemStack.setDurability(durability);
        return this;
    }

    @Override
    public void removeAllFlags(){
        itemMeta.removeItemFlags();
    }

    @Override
    public ItemStack create() {
        itemMeta.setLore(lore);
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override
    public GuiItem onUsable(GuiUsable usable) {
        this.usable = usable;
        Bukkit.getPluginManager().registerEvents(this, EasyBukkitAPI.getInstance());
        return this;
    }

    @EventHandler
    public void onUse(InventoryClickEvent event) {
        if(event.getCurrentItem() != null) {
            if(event.getInventory().equals(inventory) && event.getCurrentItem().equals(itemStack)) usable.onGuiUsable(event);
        }

    }

}
