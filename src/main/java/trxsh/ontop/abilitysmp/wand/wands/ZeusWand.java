package trxsh.ontop.abilitysmp.wand.wands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;
import trxsh.ontop.abilitysmp.wand.WandType;

public class ZeusWand extends Wand {

    public ZeusWand(String name, String key, WandAbility ability, WandType type) {
        super(name, key, ability, type);
    }

    @Override
    public void doAbility(Player player) {

        if(!player.getWorld().isThundering()) {

            player.sendMessage(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "It Starts to Rain...");
            player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, .5f, .5f);

            player.getWorld().setThundering(true);

        } else {

            Block b = player.getTargetBlock(null, 20);

            if(b.getType() == Material.AIR)
                return;

            LightningStrike strike = player.getWorld().strikeLightning(b.getLocation());

            strike.setCustomName("TrxshLightning");

        }

    }
}
