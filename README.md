<h1 align="center"> EasyBukkitAPI </h1>


```java
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
