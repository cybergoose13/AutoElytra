/*
* File: PlayerMoveEventHandler.java
* Author:   Cyber Goose
* Date:     31/3/20
* Update:   31/3/20
* Description:  Detects player movements and checks config files before switching elytra and armor.
* TODO:     add comments
* */

package me.cybergoose.autoelytra.handlers;

import me.cybergoose.autoelytra.interfaces.AutoElytraInterface;
import me.cybergoose.autoelytra.utils.ChestPlate;
import me.cybergoose.autoelytra.utils.ConfigChecker;
import me.cybergoose.autoelytra.utils.IgnoreItemCheck;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;

public class PlayerMoveEventHandler implements Listener, AutoElytraInterface {

    static final float JUMP_PEAK = (float) 1.1278902;

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        boolean unbreakable = ConfigChecker.isUnbreakable();
        Player player = event.getPlayer();
        ItemStack chestPlate = Objects.requireNonNull(player.getEquipment()).getChestplate();
        ItemStack inHandItem = handCheck(player);
        ItemMeta itemMeta;

        if(chestPlate == null) return;
        if(IgnoreItemCheck.isItemIgnored(inHandItem, chestPlate)) return;

        float fallDistance = player.getFallDistance();
        List<Material> chestPlates = ChestPlate.getArmorTypes();

        if(player.isOnGround() || player.isSwimming()){
            for(Material material : chestPlates){
                if(inHandItem.getType() == material && chestPlate.getType().equals(Material.ELYTRA)){
                    itemMeta = chestPlate.getItemMeta();
                    assert itemMeta != null;
                    itemMeta.setUnbreakable(unbreakable);
                    chestPlate.setItemMeta(itemMeta);

                    putItemInHand(player, chestPlate);
                    player.getEquipment().setChestplate(inHandItem);
                    return;
                }
            }
        }

        if(!player.isOnGround() && !player.isSwimming() && fallDistance > JUMP_PEAK){
            if(inHandItem.getType() == Material.ELYTRA && chestPlate.getType() != Material.ELYTRA){
                itemMeta = inHandItem.getItemMeta();
                assert itemMeta != null;
                itemMeta.setUnbreakable(unbreakable);
                inHandItem.setItemMeta(itemMeta);

                putItemInHand(player, chestPlate);
                player.getEquipment().setChestplate(inHandItem);
                player.setGliding(ConfigChecker.isAutoGlide());
            }
        }
    }

    private static ItemStack handCheck(Player player){
        if(ConfigChecker.isUsingMainHand()){
            return player.getInventory().getItemInMainHand();
        }else return player.getInventory().getItemInOffHand();
    }

    private static void putItemInHand(Player player, ItemStack item){
        if(ConfigChecker.isUsingMainHand()){
            Objects.requireNonNull(player.getEquipment()).setItemInMainHand(item);
        }else Objects.requireNonNull(player.getEquipment()).setItemInOffHand(item);
    }
}
