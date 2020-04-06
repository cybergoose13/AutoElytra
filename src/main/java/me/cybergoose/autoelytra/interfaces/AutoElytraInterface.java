/*
 * File: AutoElytraInterface.java
 * Author:   Cyber Goose
 * Date:     31/3/20
 * Update:   31/3/20
 * Description:  Holds plugin info.
 * */

package me.cybergoose.autoelytra.interfaces;

import me.cybergoose.autoelytra.Autoelytra;
import org.bukkit.plugin.java.JavaPlugin;

public interface AutoElytraInterface {
    JavaPlugin PLUGIN = Autoelytra.getProvidingPlugin(Autoelytra.class);
    String PLUGIN_NAME = PLUGIN.getName();
}
