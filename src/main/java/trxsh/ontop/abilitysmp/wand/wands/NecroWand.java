package trxsh.ontop.abilitysmp.wand.wands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import trxsh.ontop.abilitysmp.Main;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;
import trxsh.ontop.abilitysmp.wand.WandType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NecroWand extends Wand {

    public NecroWand(String name, String key, WandAbility ability, WandType type) {
        super(name, key, ability, type);
    }

    @Override
    public void doAbility(Player player) {

        Location l = player.getLocation();

        List<Location> possibleLocations = new ArrayList();

        for(int x = (int)l.getX() - 10; x < l.getX() + 10; x++) {

            for(int z = (int)l.getZ() - 10; z < l.getZ() + 10; z++) {

                Location loc = new Location(player.getWorld(), x, l.getY() + 1, z);

                if(loc.getBlock() == null || loc.getBlock().getType() == Material.AIR) {

                    possibleLocations.add(loc);
                    Bukkit.broadcastMessage("possible location found to summon zombie: " + loc);

                } else
                    Bukkit.broadcastMessage("location not possible to spawn zombie: " + loc);

            }

        }

        if(!possibleLocations.isEmpty()) {

            int zombieCount = 0;
            List<Zombie> zombies = new ArrayList();

            for (Location loc : possibleLocations) {

                Random rand = new Random();
                int i = rand.nextInt(100);

                i += 1;

                if (i > 99) {

                    Zombie spawned = (Zombie) player.getWorld().spawnEntity(loc, EntityType.ZOMBIE);

                    zombies.add(spawned);

                    spawned.setCustomName(player.getName() + "'s Zombie");
                    spawned.setCustomNameVisible(false);

                    zombieCount++;

                    Bukkit.getScheduler().runTaskLater(Main.Instance, new Runnable() {
                        @Override
                        public void run() {

                            for(Zombie zombie : zombies)
                                zombie.eject();

                            zombies.clear();

                        }
                    }, 20 * 60L);

                    //Bukkit.broadcastMessage("spawned Zombie at " + spawned.getLocation() + ", now attacking " + p.getName());

                }

            }

            Bukkit.broadcastMessage("spawned " + zombieCount + " zombies");

        }

    }

}
