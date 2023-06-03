package trxsh.ontop.abilitysmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import trxsh.ontop.abilitysmp.Main;
import trxsh.ontop.abilitysmp.manager.CooldownManager;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.util.WandUtility;

import java.util.List;

public class ItemListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

            try {

                ItemStack stack = e.getItem();

                if(stack == null)
                    return;

                if(stack.getType() == Material.AIR)
                    return;

                Wand wand = WandUtility.getWandByItem(stack);

                if(wand == null)
                    return;

                if(CooldownManager.isIdInList(e.getPlayer().getUniqueId())) {

                    e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, .5f);
                    e.getPlayer().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Your Wand Ability Is On Cooldown!");

                    return;

                }

                Bukkit.getScheduler().runTaskLater(Main.Instance, new Runnable() {
                    @Override
                    public void run() {
                        CooldownManager.addIdToList(e.getPlayer().getUniqueId());
                    }
                }, 5);

               //Bukkit.broadcastMessage("wand is " + wand.name);

                wand.doAbility(e.getPlayer());

            }catch(Exception e1) { }

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

                    e.getEntity().remove();

                }

            }

    }

}
