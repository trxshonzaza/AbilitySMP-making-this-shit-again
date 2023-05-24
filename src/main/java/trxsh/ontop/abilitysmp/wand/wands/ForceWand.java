package trxsh.ontop.abilitysmp.wand.wands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import trxsh.ontop.abilitysmp.util.MathUtility;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;
import trxsh.ontop.abilitysmp.wand.WandType;

import java.util.List;

public class ForceWand extends Wand {


    public ForceWand(String name, String key, WandAbility ability, WandType type) {
        super(name, key, ability, type);
    }

    @Override
    public void doAbility(Player player) {

        if(!MathUtility.isEntitiesNearby(player, 10))
            return;

        List<Entity> entities = MathUtility.getEntitiesNearby(player, 10);

        Bukkit.broadcastMessage(entities.size() + " entities are nearby");

        for(Entity e : entities) {

            Location playerLocation = player.getLocation().add(0, .5D, 0);
            Vector facing = e.getLocation().toVector().subtract(playerLocation.toVector());

            if(!player.isSneaking()) {

                e.setVelocity(new Vector(-facing.getX() / 3,
                        facing.getY() + .5D,
                        -facing.getZ() / 3));

            } else {

                e.setVelocity(new Vector(facing.getX() / 2,
                        facing.getY() + .9D,
                        facing.getZ() / 2));

            }

        }

        player.playSound(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, 1f, 1f);

    }
}
