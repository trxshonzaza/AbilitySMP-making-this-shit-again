package trxsh.ontop.abilitysmp.manager;

import org.bukkit.Bukkit;
import trxsh.ontop.abilitysmp.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CooldownManager {

    public static List<UUID> playerCooldowns = new ArrayList();

    public static boolean isIdInList(UUID id) {

        for(UUID id1 : playerCooldowns)
            if(id.equals(id1))
                return true;

        return false;

    }

    public static UUID getIdFromList(UUID id) {

        for(UUID id1 : playerCooldowns)
            if(id.equals(id1))
                return id1;

        return null;

    }

    public static void addIdToList(UUID id) {

        playerCooldowns.add(id);

        Bukkit.getScheduler().runTaskLater(Main.Instance, new Runnable() {

            @Override
            public void run() {

                playerCooldowns.remove(id);

            }

        }, 20 * 60L);

    }

}
