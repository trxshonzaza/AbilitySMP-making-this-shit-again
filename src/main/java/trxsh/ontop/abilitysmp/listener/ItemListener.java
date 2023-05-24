package trxsh.ontop.abilitysmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.util.WandUtility;

import java.util.List;

public class ItemListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

            try {

                ItemStack stack = e.getItem();

                Wand wand = WandUtility.getWandByItem(stack);

                Bukkit.broadcastMessage("wand is " + wand.name);

                wand.doAbility(e.getPlayer());

            }catch(Exception e1){ }

        }

    }

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent e) {

        List<Entity> entities = e.getEntity().getNearbyEntities(2, 2, 2);

        for(Entity entity : entities)
            if(entity instanceof FallingBlock) {

                if(e.getEntity().getCustomName() != null) {

                    e.getEntity().getWorld().createExplosion(e.getLocation(), 3f);
                    e.getEntity().getWorld().playSound(e.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f);

                    e.getEntity().eject();

                }

            }

    }

}
