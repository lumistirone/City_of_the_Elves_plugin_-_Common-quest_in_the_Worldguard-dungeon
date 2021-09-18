package fr.margotfille.cdeqc.utils.langs;

import org.bukkit.ChatColor;

public class ChatColorMessage {

	/*
	 * Translate message
	 */
	public static String translateColor(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}