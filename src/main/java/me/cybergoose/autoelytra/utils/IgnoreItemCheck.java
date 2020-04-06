/*
 * File: IgnoreItemCheck.java
 * Author:   Cyber Goose
 * Date:     31/3/20
 * Update:   31/3/20
 * Description:  Determines if the chestplate is to be ignored or switched as per config file.
 * TODO:     add comments
 * */

package me.cybergoose.autoelytra.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class IgnoreItemCheck {

//    return true if ignoring switch
    public static boolean isItemIgnored(ItemStack inHand, ItemStack chestPlate){
        Material materialInHand = inHand.getType();
        Material materialChest = chestPlate.getType();

//        check for chest-plate in hand and equipped.
        if(ChestPlate.contains(inHand.getType()) && ChestPlate.contains(chestPlate.getType())) return true;
//        check for elytra equipped or in hand.
        if(inHand.getType().equals(Material.ELYTRA) && chestPlate.getType().equals(Material.ELYTRA)) return true;

//        Check config file if chest plate type is the same that is set to false and in hand
        if(!ConfigChecker.isChainmailEnabled()){
//            ChestPlate.contains(materialInHand) || ChestPlate.contains()
            return materialInHand.equals(ChestPlate.CHAIN.getType())
                    || materialChest.equals(ChestPlate.CHAIN.getType());
        }

        if(!ConfigChecker.isLeatherEnabled()){
            return materialInHand.equals(ChestPlate.LEATHER.getType())
                    || materialChest.equals(ChestPlate.LEATHER.getType());
        }

        if (!ConfigChecker.isGoldenEnabled()){
            return materialInHand.equals(ChestPlate.GOLD.getType())
                    || materialChest.equals(ChestPlate.GOLD.getType());
        }

        if(!ConfigChecker.isIronEnabled()){
            return materialInHand.equals(ChestPlate.IRON.getType())
                    || materialChest.equals(ChestPlate.IRON.getType());
        }

        if(!ConfigChecker.isDiamondEnabled()){
            return materialInHand.equals(ChestPlate.DIAMOND.getType())
                    || materialChest.equals(ChestPlate.DIAMOND.getType());
        }
        return false;
    }
}
