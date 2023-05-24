package trxsh.ontop.abilitysmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import trxsh.ontop.abilitysmp.util.BlockUtility;

public class BlockListener implements Listener {

    @EventHandler
    public void onEntityChange(EntityChangeBlockEvent e) {

        Location blockLocation = e.getBlock().getLocation();
        World world = e.getEntity().getWorld();

        if(e.getEntity().getCustomName() != null) {

            if(e.getEntity().getCustomName().contains("TrxshBlock")) {

                BlockUtility.fallingBlocks.remove((FallingBlock) e.getEntity());

                world.createExplosion(blockLocation, 3f);
                world.playSound(blockLocation, Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f);

                e.setCancelled(true);

            }

        }

    }

}
