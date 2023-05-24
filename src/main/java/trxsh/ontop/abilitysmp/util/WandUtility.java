package trxsh.ontop.abilitysmp.util;

import org.bukkit.inventory.ItemStack;
import trxsh.ontop.abilitysmp.data.WandData;
import trxsh.ontop.abilitysmp.wand.Wand;

public class WandUtility {

    public static Wand getWandByName(String name) {

        for(Wand w : WandData.wands) {

            if(w.name.replaceAll(" ", "").equalsIgnoreCase(name.replaceAll(" ", ""))) {

                return w;

            }

        }

        return null;

    }

    public static Wand getWandByItem(ItemStack stack) {

        for(Wand w : WandData.wands) {

            if(w.getItem().getItemMeta().getDisplayName().replaceAll(" ", "").equalsIgnoreCase(stack.getItemMeta().getDisplayName().replaceAll(" ", ""))) {

                return w;

            }

        }

        return null;

    }

}
