package trxsh.ontop.abilitysmp;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import trxsh.ontop.abilitysmp.executor.TestExecutor;
import trxsh.ontop.abilitysmp.listener.*;
import trxsh.ontop.abilitysmp.manager.PlayerManager;
import trxsh.ontop.abilitysmp.data.DataPlayer;
import trxsh.ontop.abilitysmp.util.BlockUtility;

public final class Main extends JavaPlugin {

    public static Main Instance = null;

    @Override
    public void onEnable() {

        Bukkit.getPluginCommand("tester").setExecutor(new TestExecutor());

        Bukkit.getPluginManager().registerEvents(new ItemListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new MobListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockListener(), this);
        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        //Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);

        for(Player p : Bukkit.getOnlinePlayers()) {

            DataPlayer dp = new DataPlayer(p);

            if(!PlayerManager.dataPlayerExists(dp)) {

                PlayerManager.addDataPlayer(dp);

            }

        }

        Instance = this;

        BlockUtility.start();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
