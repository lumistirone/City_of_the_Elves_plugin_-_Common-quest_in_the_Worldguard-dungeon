package fr.margotfille.cdeqc.utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.margotfille.cdeqc.main;
import net.md_5.bungee.api.ChatColor;

public class ServerQuest {
	
	/**
	 * State management.
	 */
	public static QuestState questState;

	public static boolean isState(QuestState state) {
		return questState == state;
	}

	public static void setState(QuestState state) {
		questState = state;
	}
	
	/*
	 * Send a Message for Players in the dungeons.
	 */
	public static void sendMessagePlayers(String message) {
		if(!(main.PlayerInDungeon.isEmpty())) {
			for(Player players : main.PlayerInDungeon) {
				players.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
			}
		}
	}
	
	/*
	 * Play a sound for Players in the dungeons.
	 */
	public static void playSoundPlayers(Sound soundEffect) {
		for(Player players : main.PlayerInDungeon) {
			players.playSound(players.getLocation(), soundEffect, 1F, 1F);
		}
	}
	
	/*
	 * Item Management
	 */
	public static ItemStack createItem(Material m, int unite, String DisplayName, String Lore, Enchantment enchantment, int enchantment_level, Boolean hideEnchant) {
		
		ItemStack i;
		
		if(m == null) {
			if(unite > 0) {
				i = new ItemStack(Material.STONE, unite);
			} else {
				i = new ItemStack(Material.STONE, 1);
			}
		} else {
			if(unite > 0) {
				i = new ItemStack(m, unite);
			} else {
				i = new ItemStack(m, 1);
			}
		}

		ItemMeta im = i.getItemMeta();

		if(DisplayName != null) im.setDisplayName(ChatColor.translateAlternateColorCodes('&', DisplayName)); 
		if(DisplayName.equals("null")) im.setDisplayName(" "); 
		
		String[] Lore1 = Lore.split(",");
		ArrayList<String> Lore2 = new ArrayList<String>();
		
		for(String lore1 : Lore1) {
			Lore2.add(ChatColor.translateAlternateColorCodes('&', lore1));
		}
		
		if(Lore2 != null && !Lore2.isEmpty()) im.setLore(Lore2);

		if(main.INSTANCE.getSettings().getHasEnchantment()) {
			if(enchantment != null) {
				if(enchantment_level > 0) {
					im.addEnchant(enchantment, enchantment_level, true);
				} else {
					im.addEnchant(enchantment, 1, true);
				}

				if(hideEnchant = true) {
					im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				}
			}
		}

		i.setItemMeta(im);

		return i;
	}
}