package trxsh.ontop.abilitysmp.wand.wands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import trxsh.ontop.abilitysmp.util.MathUtility;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;
import trxsh.ontop.abilitysmp.wand.WandType;

public class TeleportWand extends Wand {

    public TeleportWand(String name, String key, WandAbility ability, WandType type) {
        super(name, key, ability, type);
    }

    @Override
    public void doAbility(Player player) {

        Block b = MathUtility.getSolidBlockLookingAt(player, 20);

        if(b == null)
            return;

        Location location = b.getLocation().add(0, 1, 0);

        location.setYaw(player.getLocation().getYaw());
        location.setPitch(player.getLocation().getPitch());

        if(location.getBlock().getType() == Material.AIR) {

            player.teleport(location);
            player.playSound(location, Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);

        }

    }
}
