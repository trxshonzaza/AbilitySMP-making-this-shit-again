package trxsh.ontop.abilitysmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class MobListener implements Listener {

    @EventHandler
    public void onTarget(EntityTargetEvent e) {

        if(e.getEntity() instanceof Zombie && e.getTarget() instanceof Player) {

            Zombie zombie = (Zombie) e.getEntity();

            if(zombie.getCustomName() == null)
                return;

            if(zombie.getCustomName().contains("'s")) {

                String playerName = zombie.getCustomName().split("'s")[0];

                Bukkit.broadcastMessage(zombie + " creator is " + playerName);

                if(playerName.equals(e.getTarget().getName())) {

                    Bukkit.broadcastMessage("Zombie targeting its creator, cancelling...");
                    e.setCancelled(true);

                } else
                    return;

            }

        }

    }

}