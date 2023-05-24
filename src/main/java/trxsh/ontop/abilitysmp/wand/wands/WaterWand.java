package trxsh.ontop.abilitysmp.wand.wands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;
import trxsh.ontop.abilitysmp.wand.WandType;

public class WaterWand extends Wand {

    public WaterWand(String name, String key, WandAbility ability, WandType type) {
        super(name, key, ability, type);
    }

    @Override
    public void doAbility(Player player) {

        player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1f, 1f);
        player.sendMessage("You were granted " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Water Breathing and Dolphins Grace.");
        player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, (20 * 60), 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, (20 * 60), 1));

    }
}
