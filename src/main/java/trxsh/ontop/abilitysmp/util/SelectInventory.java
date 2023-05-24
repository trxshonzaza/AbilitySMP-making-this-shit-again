package trxsh.ontop.abilitysmp.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import trxsh.ontop.abilitysmp.data.WandData;
import trxsh.ontop.abilitysmp.wand.Wand;

public class SelectInventory {

    public static Inventory currentInventory;

    public static Inventory get() {

        Inventory n = Bukkit.createInventory(null, 54, ChatColor.GOLD + "" + ChatColor.BOLD + "Pick a Starting Wand!");

        for(Wand w : WandData.wands)
            n.addItem(w.getItem());

        currentInventory = n;

        return n;

    }

}
