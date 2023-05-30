package trxsh.ontop.abilitysmp.wand.wands;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;
import trxsh.ontop.abilitysmp.wand.WandType;

import java.util.ArrayList;
import java.util.List;

public class WardenWand extends Wand {

    public WardenWand(String name, String key, WandAbility ability, WandType type) {
        super(name, key, ability, type);
    }

    @Override
    public void doAbility(Player player) {

        player.getWorld().spawnParticle(Particle.SONIC_BOOM, player.getEyeLocation(), 1);

        BlockIterator iterator = new BlockIterator(player.getEyeLocation(), 1, 50);

        List<Location> rayLocations = new ArrayList();
        List<LivingEntity> entities = new ArrayList();


        while(iterator.hasNext()) {

            Location l = iterator.next().getLocation();
            rayLocations.add(l);

        }

        for(Location l : rayLocations) {

            player.getWorld().spawnParticle(Particle.SONIC_BOOM, l, 1);

            List<Entity> near = new ArrayList<>(player.getWorld().getNearbyEntities(l, 2, 2, 2));

            if(!near.isEmpty())
                for(Entity e : near)
                    if(e instanceof LivingEntity) {

                        if(!entities.contains((LivingEntity) e) && !(e.getName().equalsIgnoreCase(player.getName())))
                            entities.add((LivingEntity) e);

                    }

        }

        for(LivingEntity e : entities)
            e.damage(16);

        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_WARDEN_SONIC_BOOM, 1f, 1f);

    }

}
