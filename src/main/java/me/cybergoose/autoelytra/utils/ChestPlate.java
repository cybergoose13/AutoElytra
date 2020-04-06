/*
 * File: ChestPlate.java
 * Author:   Cyber Goose
 * Date:     31/3/20
 * Update:   31/3/20
 * Description:  Holds the different types of armor and compares to item held or equipped.
 * TODO:     add comments
 * */

package me.cybergoose.autoelytra.utils;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public enum ChestPlate {
    CHAIN(Material.CHAINMAIL_CHESTPLATE),
    LEATHER(Material.LEATHER_CHESTPLATE),
    GOLD(Material.GOLDEN_CHESTPLATE),
    IRON(Material.IRON_CHESTPLATE),
    DIAMOND(Material.DIAMOND_CHESTPLATE);

    private final Material type;

    ChestPlate(Material type){
        this.type = type;
    }

    public Material getType(){
        return this.type;
    }

    public static List<Material> getArmorTypes(){
        List<Material> chestplates = new ArrayList<>();
        for(ChestPlate chestPlate : ChestPlate.values()){
            chestplates.add(chestPlate.type);
        }
        return chestplates;
    }

    public static boolean contains(Material material){
        for(ChestPlate chestPlate: ChestPlate.values()){
            if(material.equals(chestPlate.getType())) return true;
        }
        return false;
    }
}
