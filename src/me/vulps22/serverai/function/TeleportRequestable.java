/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vulps22.serverai.function;


import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.vulps22.serverai.ServerChatListener;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
/**
 *
 * @author dmkiller11
 */
public class TeleportRequestable implements Runnable{//allows threading
    
    static ChatColor RED = ChatColor.RED;
    static ChatColor WHITE = ChatColor.WHITE;
    Player toListen = null;
    String tempMessage;
    String[] Playermessage;
    int i = 0;
    public static boolean TeleCheck = false;
    public static Player publicTarget;
    public static Player publicSender;
    public static int Checks = 0;
    public void run(){//Main thread
        
        Player target = ServerChatListener.targetTPA;//Creates a local threaded variable for target and sender
        Player sender = ServerChatListener.senderTPA;//from the temp one in ServerChatListener
        publicSender = sender;//New public vars, as the ones in ServerChatListener will get rewrote with each tpa
        publicTarget = target;
        SendMeToMsg(target, sender);//Sends Sais PM to ask about the tpa request
        for (Checks = 0; Checks < 60; Checks++){//for 60 intervals of half a second, the telecheck variable is set 
            try {                               // to true, and false after the 30th second to expire request
                Thread.sleep(500);              // Refer to ServerChatListener for the rest...
                TeleCheck = true;
                if(Checks == 59){
                    TeleCheck = false;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TeleportRequestable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    public static void SendMeToMsg(Player target, Player sender) {
        
        sendPersonalMsg(target, RED + "[SAI] " + WHITE + "Excuse me, " + sender.getName()  + " would like to teleport to you, do you accept?");
        
    }
    public static void sendPersonalMsg(Player player, String message) {
        player.sendMessage(message);
    }
    public boolean containsString(String[] read, String contains) {
        if (Arrays.asList(read).contains(contains)) {
            return true;
        } else {
            return false;
        }
    }
    public void tp(Player target, Player victim) {
        
        target.teleport(victim);
    }
    public static void toMe(Player victim, Player me){
        victim.teleport(me);
    }
    public static void meTo(Player victim, Player me){
        me.teleport(victim);
    }
    
    
}
