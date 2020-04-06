/*
 * File: PlayerMoveEventHandler.java
 * Author:   Cyber Goose
 * Date:     4/4/20
 * Update:   4/6/20
 * Description:  Detects when player tries to craft an elytra and makes sure its enabled on server.
 * TODO:     add comments
 * */

package me.cybergoose.autoelytra.handlers;

import me.cybergoose.autoelytra.interfaces.AutoElytraInterface;
import me.cybergoose.autoelytra.utils.ConfigChecker;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class ElytraCraftedEventHandler implements Listener, AutoElytraInterface {

    @EventHandler
    public void elytraCraftedEvent(CraftItemEvent e){
        ItemStack elytra = new ItemStack(Material.ELYTRA);
        if(!ConfigChecker.isCraftable()){
            if(e.getInventory().getResult().equals(elytra)){
                e.setCancelled(true);
                e.getWhoClicked().sendMessage(ChatColor.RED + "Elytra is not craftable.");
            }
        }
    }
}
