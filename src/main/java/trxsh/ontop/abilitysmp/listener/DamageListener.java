package trxsh.ontop.abilitysmp.listener;

import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {

        LivingEntity le = null;

        if(e.getEntity() instanceof LivingEntity)
             le = (LivingEntity) e.getEntity();
        else
            return;

        if(e.getDamager() instanceof WitherSkull) {

            WitherSkull skull = (WitherSkull) e.getDamager();

            skull = (WitherSkull)e.getDamager();

            if(skull.getCustomName().equalsIgnoreCase("TrxshWither"))
                le.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20 * 10, 1));

        } else if(e.getDamager() instanceof LightningStrike) {

            LightningStrike strike = (LightningStrike) e.getDamager();

            strike = (LightningStrike) e.getDamager();

            if(strike.getCustomName().equalsIgnoreCase("TrxshLightning"))
                le.damage(2);

        }

    }

}
