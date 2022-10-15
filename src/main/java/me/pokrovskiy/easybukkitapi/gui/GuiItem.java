package me.pokrovskiy.easybukkitapi.gui;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface GuiItem {

    GuiItem setName(String name);
    GuiItem addLore(String text);
    GuiItem setLore(List<String> lore);
    GuiItem addEnchantment(Enchantment enchantment, int level);
    GuiItem setDurability(short durability);

    void removeAllFlags();
    ItemStack create();

    void setInventory(Inventory inventory);

    GuiItem onUsable(GuiUsable usable);

}
