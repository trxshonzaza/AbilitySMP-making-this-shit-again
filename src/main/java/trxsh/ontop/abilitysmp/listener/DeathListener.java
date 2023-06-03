package trxsh.ontop.abilitysmp.listener;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import trxsh.ontop.abilitysmp.util.DropUtility;
import trxsh.ontop.abilitysmp.util.ItemUtility;
import trxsh.ontop.abilitysmp.util.WandUtility;

import java.util.Random;

public class DeathListener implements Listener {

    public static String deathMessage = "";

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        if(deathMessage.length() > 1)
            e.setDeathMessage(deathMessage);

        deathMessage = "";

    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {

        if(e.getEntity() instanceof Player)
            return;

        LivingEntity en = e.getEntity();

        if(en instanceof Warden) {

            if(DropUtility.drops[0])
                return;

            en.getWorld().dropItem(en.getLocation(), WandUtility.getWandByKey("warden").getItem());
            DropUtility.drops[0] = true;

        }
        else if(en instanceof EnderDragon) {

            if(DropUtility.drops[1])
                return;

            en.getWorld().dropItem(en.getLocation(), WandUtility.getWandByKey("dragon").getItem());
            DropUtility.drops[1] = true;

        }
        else if(en instanceof ElderGuardian) {

            if(DropUtility.drops[2])
                return;

            en.getWorld().dropItem(en.getLocation(), WandUtility.getWandByKey("water").getItem());
            DropUtility.drops[2] = true;


        }
        else if(en instanceof Zombie) {

            Random rand = new Random();
            int i = rand.nextInt(100);

            i += 1;

            if (i > 99)
                en.getWorld().dropItem(en.getLocation(), ItemUtility.getItemByKey("zombie_remains").toItem());

        }

    }

}
