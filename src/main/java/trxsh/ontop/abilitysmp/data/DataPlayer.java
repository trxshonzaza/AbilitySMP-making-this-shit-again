package trxsh.ontop.abilitysmp.data;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

@Deprecated
public class DataPlayer {

    public static DataPlayer instance;

    public boolean isOffline = true;

    public Player existingPlayer;

    public UUID uuid;

    public String name;

    public DataPlayer(Player player) {

        this.uuid = player.getUniqueId();
        this.existingPlayer = player;
        this.name = player.getName();

        instance = this;

    }

    public DataPlayer(OfflinePlayer player) {

        isOffline = true;

        if(player.isOnline()) {

            this.isOffline = false;
            this.existingPlayer = player.getPlayer();

        }

        this.name = player.getName();
        this.uuid = player.getUniqueId();

        instance = this;

    }

    public void setPlayer(Player player) {

        if(player.isOnline()) {

            this.isOffline = false;
            this.existingPlayer = player.getPlayer();

        }

        this.name = player.getName();
        this.uuid = player.getUniqueId();

    }

}
