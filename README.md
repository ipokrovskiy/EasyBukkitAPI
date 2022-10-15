<h1 align="center"> EasyBukkitAPI </h1>




```java
#create custom item
Item sword = new EasyItem(Material.IRON_SWORD).setName("Magic Sword").addLore("The sword does a lot of damage").addEnchantment(Enchantment.DAMAGE_ALL, 10);

#how to give an item to a player
Player player = //;
player.getInventory().addItem(sword.create);

#method create() transfers the EasyItem to the ItemStack        

#create clickable item 
Item soup = new EasyItem(Material.BEETROOT_SOUP)
                .setName("Regenerating soup")
                .addLore("This soup can regenerate your health")
                .onUsable(event -> {
                    if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                        event.getPlayer().setHealth(20.0);
                    }
                });
```
