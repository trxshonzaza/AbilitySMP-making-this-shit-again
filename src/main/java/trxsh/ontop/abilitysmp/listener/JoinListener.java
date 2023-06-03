package trxsh.ontop.abilitysmp.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import trxsh.ontop.abilitysmp.data.RecipeData;

public class JoinListener implements Listener {

    @EventHandler
    public void onEventJoin(PlayerJoinEvent e) {

        e.getPlayer().discoverRecipes(RecipeData.recipes);

    }

}
