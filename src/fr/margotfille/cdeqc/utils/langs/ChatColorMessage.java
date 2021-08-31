package fr.margotfille.cdeqc.utils.langs;

import net.md_5.bungee.api.ChatColor;

public class ChatColorMessage {
	
	/*
	 * Translate message
	 */
	public static String translateColor(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
