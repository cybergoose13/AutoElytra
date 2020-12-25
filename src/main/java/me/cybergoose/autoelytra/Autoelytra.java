/*
* Title:    Auto Elytra
* Author:   Cyber Goose
* Date:     31/3/20
* Updated:  24/12/20
*
* TODO:
* */

package me.cybergoose.autoelytra;

import me.cybergoose.autoelytra.handlers.ElytraCraftedEventHandler;
import me.cybergoose.autoelytra.handlers.PlayerMoveEventHandler;
import me.cybergoose.autoelytra.utils.ConfigChecker;
import me.cybergoose.autoelytra.utils.ElytraRecipe;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Autoelytra extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        loadConfig();
        this.getServer().getPluginManager().registerEvents(new PlayerMoveEventHandler(), this);
        if(ConfigChecker.isCraftable()) new ElytraRecipe();
        this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + this.getName() + " is enabled.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getServer().getConsoleSender().sendMessage(ChatColor.RED + this.getName() + " is disabled.");
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
        new ConfigChecker();
    }
}
