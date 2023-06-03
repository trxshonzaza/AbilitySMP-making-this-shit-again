package trxsh.ontop.abilitysmp.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import trxsh.ontop.abilitysmp.data.ItemData;
import trxsh.ontop.abilitysmp.item.CustomItem;

public class ItemUtility {

    public static CustomItem getItemByName(String name) {

        for(CustomItem i : ItemData.items) {

            if(i.name.replaceAll(" ", "").equalsIgnoreCase(name.replaceAll(" ", ""))) {

                return i;

            }

        }

        return null;

    }

    public static CustomItem getItemByStack(ItemStack stack) {

        for(CustomItem i : ItemData.items) {

            if(i.toItem().getItemMeta().getDisplayName().replaceAll(" ", "").equalsIgnoreCase(stack.getItemMeta().getDisplayName().replaceAll(" ", ""))) {

                return i;

            }

        }

        return null;

    }

    public static CustomItem getItemByKey(String key) {

        for(CustomItem i : ItemData.items) {

            if(i.key.equalsIgnoreCase(key)) {

                return i;

            }

        }

        return null;

    }

    public static ItemStack potionToItem(PotionType type) {

        ItemStack potion = new ItemStack(Material.POTION);

        PotionMeta pm = (PotionMeta) potion.getItemMeta();

        pm.setBasePotionData(new PotionData(type));

        potion.setItemMeta(pm);

        return potion;

    }

}
