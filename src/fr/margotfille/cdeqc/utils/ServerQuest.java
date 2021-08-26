package fr.margotfille.cdeqc.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.margotfille.cdeqc.main;
import net.md_5.bungee.api.ChatColor;

public class ServerQuest {

	public static QuestState questState;

	public static boolean isState(QuestState state) {
		return questState == state;
	}

	public static void setState(QuestState state) {
		questState = state;
	}

	public static void sendMessagePlayers(String message) {
		if(!(main.PlayerInDungeon.isEmpty())) {
			for(Player players : main.PlayerInDungeon) {
				players.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
			}
		}
	}

	public static ItemStack createItem(Material m, int unite, String DisplayName, String Lore, Enchantment enchantment, int enchantment_level, Boolean hideEnchant) {

		if(m == null) return null;

		ItemStack i = null;
		if(unite > 0) {
			i = new ItemStack(m, unite);
		} else {
			i = new ItemStack(m, 1);
		}

		ItemMeta im = i.getItemMeta();

		if(DisplayName != null) im.setDisplayName(ChatColor.translateAlternateColorCodes('&', DisplayName)); 
		if(DisplayName.equals("null")) im.setDisplayName(" "); 

		List<String> Lore1 = new ArrayList<>();
		Lore1.add(ChatColor.translateAlternateColorCodes('&', Lore));
		if(Lore1 != null && !Lore1.isEmpty()) im.setLore(Lore1);

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