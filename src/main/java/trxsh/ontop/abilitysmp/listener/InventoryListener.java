package trxsh.ontop.abilitysmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import trxsh.ontop.abilitysmp.util.SelectInventory;

@Deprecated
public class InventoryListener implements Listener {

    @EventHandler
    public void onItemClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if(p.getOpenInventory().equals(SelectInventory.currentInventory))
            return;

        ItemStack stack = e.getCurrentItem();

        Bukkit.broadcastMessage(p.getName() + " picked " + stack.getItemMeta().getDisplayName());

        p.closeInventory();

    }

}
