package trxsh.ontop.abilitysmp.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import trxsh.ontop.abilitysmp.data.DataPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Deprecated
public class PlayerManager {

    public static List<DataPlayer> players = new ArrayList();

    public static boolean dataPlayerExists(DataPlayer p) {

        for(DataPlayer p1 : players)
            if(p.uuid == p1.uuid)
                return true;

        return false;

    }

    public static boolean dataPlayerExists(UUID id) {

        for(DataPlayer p1 : players)
            if(id == p1.uuid)
                return true;

        return false;

    }

    public static boolean getDataPlayer(UUID id) {

        for(DataPlayer p1 : players)
            if(id == p1.uuid)
                return true;

        return false;

    }

    public static void addDataPlayer(DataPlayer p) {

        players.add(p);

        Bukkit.broadcastMessage("added player to metadata: " + p.name);

    }

    public static void addDataPlayer(Player p) {

        players.add(new DataPlayer(p));

        Bukkit.broadcastMessage("added player to metadata: " + p.getName());

    }

    public static void removeDataPlayer(DataPlayer p) {

        players.remove(p);

        Bukkit.broadcastMessage("removeed player to metadata: " + p.name);

    }

}
