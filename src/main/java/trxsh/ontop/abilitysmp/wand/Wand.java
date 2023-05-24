package trxsh.ontop.abilitysmp.wand;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class Wand {

    public String name;
    public String key;
    public WandAbility ability;
    public WandType type;

    public Wand(String name, String key, WandAbility ability, WandType type) {

        this.name = name;
        this.key = key;
        this.ability = ability;
        this.type = type;

    }

    public String getName() {

        return name;

    }

    public String getKey() {

        return key;

    }

    public WandAbility getAbility() {

        return ability;

    }

    public ItemStack getItem() {

        ItemStack stack = new ItemStack(Material.BLAZE_ROD);

        ItemMeta meta = stack.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + getName());
        meta.addEnchant(Enchantment.DURABILITY, 10, true);

        stack.setItemMeta(meta);

        return stack;

    }

    public abstract void doAbility(Player player);

}
