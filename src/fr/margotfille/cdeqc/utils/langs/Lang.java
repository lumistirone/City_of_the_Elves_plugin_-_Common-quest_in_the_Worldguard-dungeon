package fr.margotfille.cdeqc.utils.langs;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;

import fr.margotfille.cdeqc.main;
import fr.margotfille.cdeqc.utils.QuestFiles;
import net.md_5.bungee.api.ChatColor;

public enum Lang {
	INGREDIENT1NAME,
	INGREDIENT2NAME,
	INGREDIENT3NAME,

	TITLE,
	SUB_TITLE,
	INGREDIENT1SCORE,
	INGREDIENT2SCORE,
	INGREDIENT3SCORE,

	PLAYER_ENTER_MESSAGE,
	PLAYER_LEFT_MESSAGE,
	
	QUEST_BLOCKED,
	MSG_FIRST,
	BROADCAST_FIRST,
	START_MSG,
	FINISH_MSG,
	FINISH_BROADCAST,
	
	IHAVEALLINGREDIENTS,
	BEFOREHAVEALL,
	IHAVEALLINGREDIENTSINCATEGORIE,
	BEFOREHAVEALLINCATEGORIE;

	private static final Map<Lang, String> VALUES = new HashMap<Lang, String>();

	static {
		for(Lang lang : values()) {
			VALUES.put(lang, lang.getFromFile());
		}

		main.INSTANCE.getLogger().info("Le fichier de langue a été lu avec succès !");
	}

	public String get() {
		return VALUES.get(this);
	}

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