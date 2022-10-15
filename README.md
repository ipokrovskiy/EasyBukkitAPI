<h1 align="center"> EasyBukkitAPI </h1>

<h2 align="center"> How to use Item API: </h2>


<h3> Create EasyItem: </h3>
```java
Item sword = new EasyItem(Material.IRON_SWORD).setName("Magic Sword").addLore("The sword does a lot of damage").addEnchantment(Enchantment.DAMAGE_ALL, 10);
```

<h3> Create clickable EasyItem </h3>
```java
Item soup = new EasyItem(Material.BEETROOT_SOUP)
                .setName("Regenerating soup")
                .addLore("This soup can regenerate your health")
                .onUsable(event -> {
                    if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                        event.getPlayer().setHealth(20.0);
                    }
                });
```

<h3> How to give an item to a player</h3>
```java

//PlayerJoin example

@EventHanlder
public void onJoin(PlayerJoinEvent event) {
    Item sword = EasyItem(Material.IRON_SWORD).setName("Magic Sword").addLore("The sword does a lot of damage").addEnchantment(Enchantment.DAMAGE_ALL, 10);
    event.getPlayer().getInventory().addItem(sword.create()); //method create() will transfer EasyItem to ItemStack
}
```
