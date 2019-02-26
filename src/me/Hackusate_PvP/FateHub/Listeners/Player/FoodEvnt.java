package me.Hackusate_PvP.FateHub.Listeners.Player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodEvnt implements Listener {

    @EventHandler
    public void onFodd(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.getFoodLevel() > 15) {
                player.setFoodLevel(15);
            } else {
                player.setFoodLevel(15);
                event.setCancelled(true);
            }
        }
    }
}
