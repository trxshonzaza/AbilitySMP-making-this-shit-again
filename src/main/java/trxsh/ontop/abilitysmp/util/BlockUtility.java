package trxsh.ontop.abilitysmp.util;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import trxsh.ontop.abilitysmp.Main;

import java.util.ArrayList;
import java.util.List;

public class BlockUtility {

    public static List<FallingBlock> fallingBlocks = new ArrayList();

    public static void start() {

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.Instance, new Runnable() {
            @Override
            public void run() {

                if(!fallingBlocks.isEmpty())
                    for(FallingBlock block : fallingBlocks) {

                        if(!block.isValid()) {

                            block.getWorld().createExplosion(block.getLocation(), 3f);
                            block.getWorld().playSound(block.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f);

                            fallingBlocks.remove(block);

                            return;

                        } else {

                            List<Entity> entities = block.getNearbyEntities(1, 1, 1);

                            if(!entities.isEmpty()) {

                                for(Entity entity : entities)
                                    if(block.getCustomName() != null) {

                                        String owner = block.getCustomName().split("'")[0];

                                        if(entity.getName().equalsIgnoreCase(owner)) {

                                            Bukkit.broadcastMessage("entity detected is owner, cancelling");
                                            return;

                                        }

                                    }

                                Bukkit.broadcastMessage("entity detected near block");

                                for(Entity entity : entities)
                                    if(entity instanceof LivingEntity)
                                        ((LivingEntity) entity).damage(15, block);

                            }

                        }

                    }

            }
        }, 5, 5);

    }

}
