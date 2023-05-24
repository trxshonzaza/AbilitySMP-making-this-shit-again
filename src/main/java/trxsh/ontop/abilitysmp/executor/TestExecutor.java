package trxsh.ontop.abilitysmp.executor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import trxsh.ontop.abilitysmp.util.SelectInventory;

public class TestExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            ((Player)sender).openInventory(SelectInventory.get());
            return true;

        }

        return false;

    }

}
