package trxsh.ontop.abilitysmp.data;

import org.bukkit.NamespacedKey;

import java.util.ArrayList;
import java.util.List;

public class RecipeData {

    public static List<NamespacedKey> recipes = new ArrayList();


    public static void addRecipe(NamespacedKey key) {

        recipes.add(key);

    }

}
