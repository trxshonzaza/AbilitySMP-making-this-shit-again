package trxsh.ontop.abilitysmp.wand.wands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;
import trxsh.ontop.abilitysmp.wand.WandType;

public class SpeedWand extends Wand {

    public SpeedWand(String name, String key, WandAbility ability, WandType type) {
        super(name, key, ability, type);
    }

    @Override
    public void doAbility(Player player) {

        player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1f, 1f);
        player.sendMessage("You were granted " + ChatColor.AQUA + "" + ChatColor.BOLD + "Swiftness "  + ChatColor.WHITE + "And " + ChatColor.GREEN + "" + ChatColor.BOLD + "Leaping.");
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (20 * 60), 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, (20 * 60), 1));

    }
}
