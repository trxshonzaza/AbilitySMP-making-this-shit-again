package trxsh.ontop.abilitysmp.wand.wands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;
import trxsh.ontop.abilitysmp.wand.WandType;

public class RegenerationWand extends Wand {

    public RegenerationWand(String name, String key, WandAbility ability, WandType type) {
        super(name, key, ability, type);
    }

    @Override
    public void doAbility(Player player) {

        player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1f, 1f);
        player.sendMessage("You were granted " + ChatColor.RED + "" + ChatColor.BOLD + "Regeneration.");
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (20 * 60), 1));
        
    }
    
}
