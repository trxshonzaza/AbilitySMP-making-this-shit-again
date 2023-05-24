package trxsh.ontop.abilitysmp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    public static String deathMessage = "";

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        if(deathMessage.length() > 1)
            e.setDeathMessage(deathMessage);

        deathMessage = "";

    }

}
