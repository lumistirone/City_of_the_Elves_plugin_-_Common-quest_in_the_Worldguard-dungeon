package fr.margotfille.cdeqc.utils.langs;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
	

public class ChatColorPlayer {
	Player p;
	
	/*
	 * ChatColorPlayer Management (constructor)
	 */
	public ChatColorPlayer(Player p) {
		this.p = p;
	}
	
	/*
	 * Send a translate message
	 */
	public void sendMessage(String message) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
	}
}
