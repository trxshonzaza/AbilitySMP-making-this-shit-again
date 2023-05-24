package trxsh.ontop.abilitysmp.wand.wands;

import org.bukkit.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import trxsh.ontop.abilitysmp.listener.DeathListener;
import trxsh.ontop.abilitysmp.util.MathUtility;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;
import trxsh.ontop.abilitysmp.wand.WandType;

public class ReaperWand extends Wand {

    public ReaperWand(String name, String key, WandAbility ability, WandType type) {
        super(name, key, ability, type);
    }

    @Override
    public void doAbility(Player player) {

        if(!MathUtility.isLookingAtEntity(player, 20))
            return;

        LivingEntity e = MathUtility.getEntityLookingAt(player, 20);

        if(e == null)
            return;

        Bukkit.broadcastMessage("player was looking at " + e.getName());

        double healthNeeded = 20 - player.getHealth();

        Bukkit.broadcastMessage("health needed before logic: " + healthNeeded);

        if (healthNeeded <= 0) {

            Bukkit.broadcastMessage("error 1");
            return;

        } else if (healthNeeded >= e.getHealth())
            healthNeeded = e.getHealth();

        Bukkit.broadcastMessage("health needed after logic: " + healthNeeded);

        if (healthNeeded >= e.getHealth()) {

            if(e instanceof Player) {

                DeathListener.deathMessage = player.getName() + " took all of " + e.getName() + "'s life energy";
                e.setHealth(0);

            }

        } else {

            e.setHealth(e.getHealth() - healthNeeded);

            if(e instanceof Player)
                ((Player) e).playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT_SWEET_BERRY_BUSH, 1f, 1f);

        }


        if(e instanceof Player)
            e.sendMessage(player.getName() + " Took Your " + ChatColor.RED + "" + ChatColor.BOLD + "Life Energy.");

        player.setHealth(player.getHealth() + healthNeeded);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT_SWEET_BERRY_BUSH, 1f, 1f);

        player.sendMessage("You Took " + ChatColor.RED + "" + ChatColor.BOLD + e.getName() + "'s Life Energy.");

    }

}
