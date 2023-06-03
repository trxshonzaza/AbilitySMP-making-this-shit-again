package trxsh.ontop.abilitysmp.wand.wands;

import org.bukkit.Sound;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.Player;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;
import trxsh.ontop.abilitysmp.wand.WandType;

public class DragonWand extends Wand {

    public DragonWand(String name, String key, WandAbility ability, WandType type) {
        super(name, key, ability, type);
    }

    @Override
    public void doAbility(Player player) {

        DragonFireball fireball = player.launchProjectile(DragonFireball.class);

        fireball.setShooter(player);
        fireball.setBounce(false);
        fireball.setIsIncendiary(true);
        fireball.setYield(5F);
        fireball.setCustomName("TrxshFireball");

        player.getWorld().playSound(player.getLocation(), Sound.ITEM_FIRECHARGE_USE, 1f, 1f);

    }
}
