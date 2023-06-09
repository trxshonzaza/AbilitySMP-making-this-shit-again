package trxsh.ontop.abilitysmp.data;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import trxsh.ontop.abilitysmp.item.CustomItem;
import trxsh.ontop.abilitysmp.item.SpecialRodItem;
import trxsh.ontop.abilitysmp.item.ZombieRemainsItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemData {

    public static List<CustomItem> items = new ArrayList();
    static {

        items.add(new ZombieRemainsItem(
                ChatColor.GOLD + "Zombie Remains",
                "zombie_remains",
                Material.ROTTEN_FLESH,
                Arrays.asList("Zombie Remains.", "Try Crafting With It.")
        ));
        items.add(new SpecialRodItem(
                ChatColor.AQUA + "" + ChatColor.BOLD + "Special Rod",
                "special_rod",
                Material.BLAZE_ROD,
                Arrays.asList("Something Strange...", "Try Collecting And Crafting Unique Items.")
        ));

    }

}
