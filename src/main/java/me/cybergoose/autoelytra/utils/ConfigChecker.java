/*
 * File: ConfigChecker.java
 * Author:   Cyber Goose
 * Date:     31/3/20
 * Update:   31/3/20
 * Description:  Gets config file booleans and stores them to be accessed.
 * TODO:     add comments
 * */

package me.cybergoose.autoelytra.utils;

import me.cybergoose.autoelytra.interfaces.AutoElytraInterface;

public class ConfigChecker implements AutoElytraInterface {
    private static boolean autoGlide;
    private static boolean chainmail;
    private static boolean leather;
    private static boolean golden;
    private static boolean iron;
    private static boolean diamond;
    private static boolean unbreakable;
    private static boolean usingMainHand;
    private static boolean consoleOut;
    private static boolean craftable;

    private static final String OPT_PRE = "Options.";
    private static final String PLATE_PRE = "ChestPlates.";

    public ConfigChecker(){
//        }
        consoleOut = PLUGIN.getConfig().getBoolean(OPT_PRE + "ConsoleOut");
        autoGlide = PLUGIN.getConfig().getBoolean(OPT_PRE + "AutoGlide");
        unbreakable = PLUGIN.getConfig().getBoolean(OPT_PRE + "Unbreakable");
        usingMainHand = PLUGIN.getConfig().getBoolean(OPT_PRE + "UseMainHand");
        craftable = PLUGIN.getConfig().getBoolean(OPT_PRE + "Craftable");

        chainmail = PLUGIN.getConfig().getBoolean(PLATE_PRE + "CHAINMAIL");
        leather = PLUGIN.getConfig().getBoolean(PLATE_PRE + "LEATHER");
        golden = PLUGIN.getConfig().getBoolean(PLATE_PRE + "GOLDEN");
        iron = PLUGIN.getConfig().getBoolean(PLATE_PRE + "IRON");
        diamond = PLUGIN.getConfig().getBoolean(PLATE_PRE + "DIAMOND");

        sendToConsole();
    }

    private static void sendToConsole(){

        if(!consoleOut) return;
        PLUGIN.getServer().getConsoleSender().sendMessage("auto gliding - " + valueToString(isAutoGlide()));
        PLUGIN.getServer().getConsoleSender().sendMessage("unbreakable - " + valueToString(isUnbreakable()));
        PLUGIN.getServer().getConsoleSender().sendMessage("craftable - " + valueToString(isCraftable()));
        PLUGIN.getServer().getConsoleSender().sendMessage("chainmail - " + valueToString(isChainmailEnabled()));
        PLUGIN.getServer().getConsoleSender().sendMessage("leather - " + valueToString(isLeatherEnabled()));
        PLUGIN.getServer().getConsoleSender().sendMessage("golden - " + valueToString(isGoldenEnabled()));
        PLUGIN.getServer().getConsoleSender().sendMessage("iron - " + valueToString(isIronEnabled()));
        PLUGIN.getServer().getConsoleSender().sendMessage("diamond - " + valueToString(isDiamondEnabled()));

        PLUGIN.getServer().getConsoleSender().sendMessage("using main - " + valueToString(isUsingMainHand()));

    }

    private static String valueToString(boolean value){
        return value ? "enabled" : "disabled";
    }

    public static boolean isAutoGlide(){
        return autoGlide;
    }

    public static boolean isChainmailEnabled(){
        return chainmail;
    }

    public static boolean isLeatherEnabled(){
        return leather;
    }

    public static boolean isGoldenEnabled(){
        return golden;
    }

    public static boolean isIronEnabled(){
        return iron;
    }

    public static boolean isDiamondEnabled(){
        return diamond;
    }

    public static boolean isUnbreakable(){
        return unbreakable;
    }

    public static boolean isUsingMainHand(){
        return usingMainHand;
    }

    @SuppressWarnings("unused")
    public static boolean isConsoleOut(){
        return consoleOut;
    }

    public static boolean isCraftable(){
        return craftable;
    }
}
