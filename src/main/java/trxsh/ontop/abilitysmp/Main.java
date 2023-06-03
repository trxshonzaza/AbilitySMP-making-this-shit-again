package trxsh.ontop.abilitysmp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import trxsh.ontop.abilitysmp.listener.*;
import trxsh.ontop.abilitysmp.manager.FileManager;
import trxsh.ontop.abilitysmp.recipe.RecipeManager;
import trxsh.ontop.abilitysmp.util.BlockUtility;

import java.io.IOException;

public final class Main extends JavaPlugin {

    public static Main Instance = null;

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new ItemListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new MobListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockListener(), this);
        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);

        Instance = this;

        if(FileManager.fileExists()) {
            try {
                FileManager.readDrops();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        RecipeManager.createRecipes();
        BlockUtility.start();

    }

    @Override
    public void onDisable() {
        try {
            FileManager.writeDrops();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
