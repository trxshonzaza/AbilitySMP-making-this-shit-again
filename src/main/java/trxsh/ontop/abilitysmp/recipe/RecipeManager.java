package trxsh.ontop.abilitysmp.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.potion.PotionType;
import trxsh.ontop.abilitysmp.Main;
import trxsh.ontop.abilitysmp.data.RecipeData;
import trxsh.ontop.abilitysmp.util.ItemUtility;
import trxsh.ontop.abilitysmp.util.WandUtility;

public class RecipeManager {

    public static void createRecipes() {

        NamespacedKey necroKey = new NamespacedKey(Main.Instance, "necro_wand");
        ShapedRecipe necroRecipe = new ShapedRecipe(necroKey, WandUtility.getWandByKey("necromancy").getItem());

        necroRecipe.shape("###", "#$#", "###");

        necroRecipe.setIngredient('#', new RecipeChoice.ExactChoice(ItemUtility.getItemByKey("zombie_remains").toItem()));
        necroRecipe.setIngredient('$', new RecipeChoice.ExactChoice(ItemUtility.getItemByKey("special_rod").toItem()));

        //

        NamespacedKey enderKey = new NamespacedKey(Main.Instance, "ender_wand");
        ShapedRecipe enderRecipe = new ShapedRecipe(enderKey, WandUtility.getWandByKey("teleport").getItem());

        enderRecipe.shape("###", "#$~", "~~~");

        enderRecipe.setIngredient('#', Material.ENDER_PEARL);
        enderRecipe.setIngredient('~', Material.ENDER_EYE);
        enderRecipe.setIngredient('$', new RecipeChoice.ExactChoice(ItemUtility.getItemByKey("special_rod").toItem()));

        //

        NamespacedKey boostKey = new NamespacedKey(Main.Instance, "health_boost_wand");
        ShapelessRecipe boostRecipe = new ShapelessRecipe(boostKey, WandUtility.getWandByKey("health_boost").getItem());

        boostRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.potionToItem(PotionType.INSTANT_HEAL)));
        boostRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.getItemByKey("special_rod").toItem()));

        //

        NamespacedKey earthKey = new NamespacedKey(Main.Instance, "earth_wand");
        ShapelessRecipe earthRecipe = new ShapelessRecipe(earthKey, WandUtility.getWandByKey("earth").getItem());

        earthRecipe.addIngredient(Material.GRASS_BLOCK);
        earthRecipe.addIngredient(Material.SAND);
        earthRecipe.addIngredient(Material.WATER_BUCKET);
        earthRecipe.addIngredient(Material.LAVA_BUCKET);
        earthRecipe.addIngredient(Material.NETHERRACK);
        earthRecipe.addIngredient(Material.END_STONE);
        earthRecipe.addIngredient(Material.DEEPSLATE);
        earthRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.getItemByKey("special_rod").toItem()));

        //

        NamespacedKey forceKey = new NamespacedKey(Main.Instance, "force_wand");
        ShapelessRecipe forceRecipe = new ShapelessRecipe(forceKey, WandUtility.getWandByKey("force").getItem());

        forceRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.potionToItem(PotionType.JUMP)));
        forceRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.potionToItem(PotionType.SLOW_FALLING)));
        forceRecipe.addIngredient(new RecipeChoice.ExactChoice(WandUtility.getWandByKey("earth").getItem()));
        forceRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.getItemByKey("special_rod").toItem()));

        //

        NamespacedKey zeusKey = new NamespacedKey(Main.Instance, "zeus_wand");
        ShapelessRecipe zeusRecipe = new ShapelessRecipe(zeusKey, WandUtility.getWandByKey("lightning").getItem());

        zeusRecipe.addIngredient(Material.LIGHTNING_ROD);
        zeusRecipe.addIngredient(new RecipeChoice.ExactChoice(WandUtility.getWandByKey("teleport").getItem()));
        zeusRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.getItemByKey("special_rod").toItem()));

        //

        NamespacedKey speedKey = new NamespacedKey(Main.Instance, "speed_wand");
        ShapelessRecipe speedRecipe = new ShapelessRecipe(speedKey, WandUtility.getWandByKey("speed").getItem());

        speedRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.potionToItem(PotionType.SPEED)));
        speedRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.potionToItem(PotionType.JUMP)));
        speedRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.getItemByKey("special_rod").toItem()));

        //

        NamespacedKey reaperKey = new NamespacedKey(Main.Instance, "reaper_wand");
        ShapelessRecipe reaperRecipe = new ShapelessRecipe(reaperKey, WandUtility.getWandByKey("reaper").getItem());

        reaperRecipe.addIngredient(Material.ZOMBIE_HEAD);
        reaperRecipe.addIngredient(Material.SKELETON_SKULL);
        reaperRecipe.addIngredient(Material.CREEPER_HEAD);
        reaperRecipe.addIngredient(new RecipeChoice.ExactChoice(WandUtility.getWandByKey("teleport").getItem()));
        reaperRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.getItemByKey("special_rod").toItem()));

        //

        NamespacedKey regenKey = new NamespacedKey(Main.Instance, "regeneration_wand");
        ShapelessRecipe regenRecipe = new ShapelessRecipe(regenKey, WandUtility.getWandByKey("regen").getItem());

        regenRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.potionToItem(PotionType.REGEN)));
        regenRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.getItemByKey("special_rod").toItem()));

        //

        NamespacedKey resistanceKey = new NamespacedKey(Main.Instance, "resistance_wand");
        ShapelessRecipe resistanceRecipe = new ShapelessRecipe(resistanceKey, WandUtility.getWandByKey("resistance").getItem());

        resistanceRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.potionToItem(PotionType.TURTLE_MASTER)));
        resistanceRecipe.addIngredient(new RecipeChoice.ExactChoice(ItemUtility.getItemByKey("special_rod").toItem()));

        //

        NamespacedKey rodKey = new NamespacedKey(Main.Instance, "special_rod");
        ShapedRecipe rodRecipe = new ShapedRecipe(rodKey, ItemUtility.getItemByKey("special_rod").toItem());

        rodRecipe.shape("~$~", "~#~", "~#~");

        rodRecipe.setIngredient('#', Material.BLAZE_ROD);
        rodRecipe.setIngredient('$', Material.ENCHANTING_TABLE);
        rodRecipe.setIngredient('~', Material.AIR);

        Bukkit.addRecipe(necroRecipe);
        Bukkit.addRecipe(rodRecipe);
        Bukkit.addRecipe(enderRecipe);
        Bukkit.addRecipe(boostRecipe);
        Bukkit.addRecipe(resistanceRecipe);
        Bukkit.addRecipe(earthRecipe);
        Bukkit.addRecipe(zeusRecipe);
        Bukkit.addRecipe(reaperRecipe);
        Bukkit.addRecipe(forceRecipe);
        Bukkit.addRecipe(speedRecipe);

        RecipeData.addRecipe(necroKey);
        RecipeData.addRecipe(rodKey);
        RecipeData.addRecipe(enderKey);
        RecipeData.addRecipe(boostKey);
        RecipeData.addRecipe(resistanceKey);
        RecipeData.addRecipe(earthKey);
        RecipeData.addRecipe(zeusKey);
        RecipeData.addRecipe(reaperKey);
        RecipeData.addRecipe(forceKey);
        RecipeData.addRecipe(speedKey);

    }

}
