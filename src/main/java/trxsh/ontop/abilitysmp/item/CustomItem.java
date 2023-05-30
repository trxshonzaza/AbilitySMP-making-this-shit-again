package trxsh.ontop.abilitysmp.item;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomItem {

    public String name;
    public String key;

    public List<String> lore;

    public Material material;

    public CustomItem(String name, String key, Material material, List<String> lore) {

        this.name = name;
        this.key = key;
        this.material = material;
        this.lore = lore;

    }

    public ItemStack toItem() {

        ItemStack stack = new ItemStack(material);

        ItemMeta meta = stack.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(lore);

        stack.setItemMeta(meta);

        return stack;

    }

}
