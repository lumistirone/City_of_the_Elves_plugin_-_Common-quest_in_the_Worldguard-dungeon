package fr.margotfille.cdeqc.utils.langs;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;

import fr.margotfille.cdeqc.main;
import fr.margotfille.cdeqc.utils.QuestFiles;
import net.md_5.bungee.api.ChatColor;

public enum Lang {
	/*
	 * All Langs
	 */
	DONTHAVEPERMISSION,
	
	INGREDIENT1NAME,
	INGREDIENT2NAME,
	INGREDIENT3NAME,

	TITLE,
	SUB_TITLE,
	INGREDIENT1SCORE,
	INGREDIENT2SCORE,
	INGREDIENT3SCORE,
	INGREDIENT1SCOREFINISH,
	INGREDIENT2SCOREFINISH,
	INGREDIENT3SCOREFINISH,
	
	PLAYER_ENTER_MESSAGE,
	PLAYER_LEFT_MESSAGE,
	
	QUEST_BLOCKED,
	MSG_FIRST,
	BROADCAST_FIRST,
	START_MSG,
	
	MORE_INGREDIENTS,
	IHAVE_ALL_INGREDIENTS,
	IHAVE_ALL_INGREDIENTS_IN_CATEGORIE,
	
	FINISH_MSG,
	FINISH_BROADCAST;

	/*
	 * VALUES HashMap Management
	 */
	private static final Map<Lang, String> VALUES = new HashMap<Lang, String>();

	static {
		for(Lang lang : values()) {
			VALUES.put(lang, lang.getFromFile());
		}

		main.INSTANCE.getLogger().info("Le fichier de langue a été lu avec succès !");
	}

	/*
	 * Get Value from VALUES
	 */
	public String get() {
		if(VALUES.get(this) == null) {
			return "error";
		}
		
		return VALUES.get(this);
	}
	
	/*
	 * Get Value from File
	 */
	private String getFromFile() {
		FileConfiguration config = QuestFiles.LANG.getConfig();
		String key = name().toLowerCase().replace('_', '-');
		String value = config.getString(key);
		
		if(value == null) {
			value = "";
		}

		return ChatColor.translateAlternateColorCodes('&', value);
	}
}