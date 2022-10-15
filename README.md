<h1 align="center"> EasyBukkitAPI </h1>

<h2 align="center"> How to use Item API: </h2>

<h3> Create EasyItem: </h3>

```java
Item sword = new EasyItem(Material.IRON_SWORD).setName("Magic Sword").addLore("The sword does a lot of damage").addEnchantment(Enchantment.DAMAGE_ALL, 10);
```

<h3> Create clickable EasyItem: </h3>

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

<h3> How to give an item to a player: </h3>

```java

//PlayerJoin example

@EventHanlder
public void onJoin(PlayerJoinEvent event) {
    Item sword = EasyItem(Material.IRON_SWORD).setName("Magic Sword").addLore("The sword does a lot of damage").addEnchantment(Enchantment.DAMAGE_ALL, 10);
    event.getPlayer().getInventory().addItem(sword.create()); //method create() will transfer EasyItem to ItemStack
}
```
<h2 align="center"> How to use Gui API: </h2>

<h3> Create Gui: </h3>

```java
//Simple create

Gui gui = new EasyGui("Menu", 3); //Menu - is name, 3 - is rows

//Create a menu with clickable elements

Gui gui = new EasyGui("Menu", 3).addItem(
                new EasyGuiItem(Material.APPLE)
                        .setName("Hello World")
                        .onUsable(event -> {
                            event.setCancelled(true);
                            event.getWhoClicked().sendMessage("Hello, " + event.getWhoClicked().getName());
                        })
                );

```

<h3> How to open Gui: </h3>

```java
//Menu example

Gui menuGui = new EasyGui("Menu", 3).addItem(
                new EasyGuiItem(Material.APPLE)
                        .setName("Hello World")
                        .onUsable(event -> {
                            event.setCancelled(true);
                            event.getWhoClicked().sendMessage("Hello, " + event.getWhoClicked().getName());
                        })
                );

Item menu = new EasyItem(Material.COMPASS)
                .setName("Server menu")
                .addLore("Right click to open menu")
                .onUsable(event -> {
                    if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                        event.getPlayer().openInventory(menuGui.create());
                    }
                });
```

<h2 align="center"> How to use Hologram API: </h2>

<h3> How to create Hologram: </h3>

```java
Hologram holo = new EasyHologram(new Location(Bukkit.getWorld("world"), 50, 100, 50).addLore("test").addLore("test2");
holo.spawn();
```

<h3> How to create clickable Hologram: </h3>

```java
Hologram holo = new EasyHologram(new Location(Bukkit.getWorld("world"), 50, 100, 50)
                          .addLore("test")
                          .addLore("test2")
                          .onUsable(event -> event.getPlayer().sendMessage("Test message");
holo.spawn();
```

<h3> How to remove Hologram </h3>

```java
holo.kill();
```
