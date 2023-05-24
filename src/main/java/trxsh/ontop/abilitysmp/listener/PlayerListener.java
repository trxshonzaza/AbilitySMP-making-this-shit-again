package trxsh.ontop.abilitysmp.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import trxsh.ontop.abilitysmp.data.DataPlayer;
import trxsh.ontop.abilitysmp.manager.PlayerManager;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        DataPlayer p = new DataPlayer(e.getPlayer());

        if(!PlayerManager.dataPlayerExists(e.getPlayer().getUniqueId())) {

            PlayerManager.players.add(p);

        }

    }

}
