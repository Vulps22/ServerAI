/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vulps22.serverai.function;

import org.bukkit.entity.Player;

/**
 *
 * @author jamie
 */
public class Teleport {

    public void tp(Player target, Player victim) {

        target.teleport(victim);
    }
    public void toMe(Player victim, Player me){
        victim.teleport(me);
    }
    public void meTo(Player victim, Player me){
        me.teleport(victim);
    }
}
