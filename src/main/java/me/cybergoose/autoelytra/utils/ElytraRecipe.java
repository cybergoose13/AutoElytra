/*
 * File: PlayerMoveEventHandler.java
 * Author:   Cyber Goose
 * Date:     4/6/20
 * Update:   4/6/20
 * Description:  Sets Recipe for elytra to be made in game
 * TODO:     Make recipe customizable.
 * */

package me.cybergoose.autoelytra.utils;

import me.cybergoose.autoelytra.interfaces.AutoElytraInterface;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class ElytraRecipe implements AutoElytraInterface {

    public ElytraRecipe(){
        NamespacedKey namespacedKey = new NamespacedKey(PLUGIN,"elytra");
        ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, new ItemStack(Material.ELYTRA));
        shapedRecipe.shape("PEP", "PDP", "P P");
        shapedRecipe.setIngredient('P', Material.PHANTOM_MEMBRANE);
        shapedRecipe.setIngredient('E', Material.ENDER_EYE);
        shapedRecipe.setIngredient('D', Material.NETHERITE_CHESTPLATE);
        PLUGIN.getServer().addRecipe(shapedRecipe);
    }
}
