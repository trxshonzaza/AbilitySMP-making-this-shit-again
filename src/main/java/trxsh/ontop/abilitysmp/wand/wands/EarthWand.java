package trxsh.ontop.abilitysmp.wand.wands;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import trxsh.ontop.abilitysmp.util.BlockUtility;
import trxsh.ontop.abilitysmp.wand.Wand;
import trxsh.ontop.abilitysmp.wand.WandAbility;
import trxsh.ontop.abilitysmp.wand.WandType;

public class EarthWand extends Wand {

    public EarthWand(String name, String key, WandAbility ability, WandType type) {
        super(name, key, ability, type);
    }

    @Override
    public void doAbility(Player player) {

        Location playerLocation = player.getLocation();
        Location blockLocation = player.getLocation().clone().subtract(0, 1, 0);
        Vector playerDirection = playerLocation.getDirection();

        if(blockLocation.getBlock() != null) {
            if(blockLocation.getBlock().getType() == Material.AIR) {
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "No Block To Pick Up!");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, .5f);
                return;
            }
        }

        Block block = blockLocation.getBlock();

        player.playSound(playerLocation, Sound.BLOCK_STONE_BREAK, 1f, 1f);
        player.playSound(playerLocation, Sound.BLOCK_STONE_BREAK, 1f, 1f);
        player.playSound(playerLocation, Sound.BLOCK_STONE_BREAK, 1f, 1f);

        FallingBlock fallingBlock = player.getWorld().spawnFallingBlock(playerLocation.clone().add(0, 1, 0), block.getBlockData());

        fallingBlock.setDropItem(false);
        fallingBlock.setCustomName(player.getName() + "'TrxshBlock");

        if(player.isSneaking())
            fallingBlock.setVelocity(playerDirection.add(new Vector(0, .3D, 0)));
        else
            fallingBlock.setVelocity(playerDirection.add(new Vector(0, .5D, 0)));

        BlockUtility.fallingBlocks.add(fallingBlock);

    }
}
