package me.pokrovskiy.easybukkitapi.gui;

import org.bukkit.inventory.Inventory;

public interface Gui {

    Gui addItem(GuiItem item);
    Gui setItem(GuiItem item, int position);
    Gui setItem(GuiItem item, int row, int pos);

    Inventory create();
}
