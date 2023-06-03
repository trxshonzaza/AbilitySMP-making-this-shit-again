package trxsh.ontop.abilitysmp.wand.wands;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;
import trxsh.ontop.abilitysmp.wand.WandType;

public class WitherWand extends Wand {

    public WitherWand(String name, String key, WandAbility ability, WandType type) {
        super(name, key, ability, type);
    }

    @Override
    public void doAbility(Player player) {

        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1f, 1f);

        WitherSkull skull = player.launchProjectile(WitherSkull.class);

        skull.setShooter(player);
        skull.setBounce(false);
        skull.setIsIncendiary(true);
        skull.setYield(5F);
        skull.setCustomName("TrxshWither");

    }

}
