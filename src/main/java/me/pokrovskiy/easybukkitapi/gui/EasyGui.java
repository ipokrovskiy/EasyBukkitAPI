package me.pokrovskiy.easybukkitapi.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class EasyGui implements Gui{

    private Inventory inventory;

    public EasyGui(String name, int rows) {
        inventory = Bukkit.createInventory(null, rows <= 9 ? rows * 9 : 54, name);
    }

    @Override
    public Gui addItem(GuiItem item) {
        item.setInventory(inventory);
        inventory.addItem(item.create());
        return this;
    }

    @Override
    public Gui setItem(GuiItem item, int position) {
        item.setInventory(inventory);
        inventory.setItem(position, item.create());
        return this;
    }

    @Override
    public Gui setItem(GuiItem item, int row, int pos) {
        item.setInventory(inventory);
        inventory.setItem(9 * row + pos - 1, item.create());
        return this;
    }

    @Override
    public Inventory create() {
        return inventory;
    }
}
