package trxsh.ontop.abilitysmp.data;

import org.bukkit.ChatColor;
import trxsh.ontop.abilitysmp.wand.WandType;
import trxsh.ontop.abilitysmp.wand.wands.*;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;

import java.util.ArrayList;

public class WandData {

    public static ArrayList<Wand> wands = new ArrayList();
    static {

        wands.add(new WitherWand(
                "Wand of The Wither",
                "wither",
                WandAbility.WITHER,
                WandType.AGGRESSIVE
        ));
        wands.add(new NecroWand(
                "Wand of Necromancy",
                "necromancy",
                WandAbility.NECRO,
                WandType.AGGRESSIVE
        ));
        wands.add(new RegenerationWand(
                "Wand of Regeneration",
                "regen",
                WandAbility.REGENERATION,
                WandType.PASSIVE
        ));
        wands.add(new HealthBoosterWand(
                "Wand of Health",
                "health_boost",
                WandAbility.HEAL_BOOST,
                WandType.PASSIVE
        ));
        wands.add(new ResistanceWand(
                "Wand of Resilience",
                "resistance",
                WandAbility.RESISTANCE,
                WandType.PASSIVE
        ));
        wands.add(new ReaperWand(
                ChatColor.RED + "" + ChatColor.BOLD + "Reaver of Life Energy",
                "reaper",
                WandAbility.REAPER,
                WandType.AGGRESSIVE
        ));
        wands.add(new ForceWand(
                "Wand of " + ChatColor.GOLD + "" + ChatColor.BOLD + "Gravity",
                "force",
                WandAbility.FORCE,
                WandType.AGGRESSIVE
        ));
        wands.add(new EarthWand(
                "Wand of The Earth",
                "earth",
                WandAbility.EARTH,
                WandType.AGGRESSIVE
        ));
        wands.add(new ZeusWand(
                "Wand of The God Zeus",
                "earth",
                WandAbility.ZEUS,
                WandType.AGGRESSIVE
        ));
        wands.add(new WaterWand(
                "Wand of Water",
                "water",
                WandAbility.WATER,
                WandType.PASSIVE
        ));

    }

}
