package me.pokrovskiy.easybukkitapi.item;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface Item {

    Item setName(String name);
    Item addLore(String text);
    Item setLore(List<String> lore);
    Item addEnchantment(Enchantment enchantment, int level);
    Item setDurability(short durability);

    Item removeAllFlags();
    ItemStack create();

    Item onUsable(ItemUsable usable);


}
