package fr.margotfille.cdeqc.utils;

import java.util.HashMap;
import java.util.Map;

import fr.margotfille.cdeqc.main;

public enum configSetup {
	WORLDGUARDZONE("WorldguardZone"),
	HOWVERIFY("HowVerify"),
	NPCNAME("NPCName"),
	NPCID("NPCID"),
	MATERIAL("material"),
	UNITE("unite"),
	DISPLAYNAME("DisplayName"),
	LORE("Lore"),
	HASENCHANTMENT("hasEnchantment"),
	HIDEENCHANTMENT("hideEnchantment"),
	INGREDIENT1_NUMBER_MAX("Ingredient1_number_max"),
	INGREDIENT2_NUMBER_MAX("Ingredient2_number_max"),
	INGREDIENT3_NUMBER_MAX("Ingredient3_number_max"),
	ISBLOCKED("IsBlocked"),
	ISMESSAGEENTER("IsMessageEnter"),
	ISMESSAGELEFT("IsMessageLeft"),
	ISSENDBROADCASTCOLLECT("IsSendBroadcastCollect"),
	NOTBROADCASTPLAYERFIRSTSTART("NotBroadcastPlayerFirstStart"),
	MOREINGREDIENT("MoreIngredient"),
	IHAVEALLINGREDIENTSINCATEGORIE("IhaveAllIngredientsInCategorie");
	
	private final String name;
	
	/*
	 * Constructor
	 */
	configSetup(String name) {
		this.name = name;
	}
	
	/*
	 * Get LangValues
	 */
	public String toName() {
		return name;
	}
	
	public String toNameLower() {
		return name.toLowerCase();
	}
	
	public static Map<String, Object> getConfig() {
		Map<String, Object> Config = new HashMap<String, Object>();
		Config.put(configSetup.WORLDGUARDZONE.toNameLower(), configSetup.WORLDGUARDZONE.toName());
		Config.put(configSetup.HOWVERIFY.toNameLower(), configSetup.HOWVERIFY.toName());
		Config.put(configSetup.NPCNAME.toNameLower(), configSetup.NPCNAME.toName());
		Config.put(configSetup.NPCID.toNameLower(), configSetup.NPCID.toName());
		Config.put(configSetup.MATERIAL.toNameLower(), configSetup.MATERIAL.toName());
		Config.put(configSetup.UNITE.toNameLower(), configSetup.UNITE.toName());
		Config.put(configSetup.DISPLAYNAME.toNameLower(), configSetup.DISPLAYNAME.toName());
		Config.put(configSetup.LORE.toNameLower(), configSetup.LORE.toName());
		Config.put(configSetup.HASENCHANTMENT.toNameLower(), configSetup.HASENCHANTMENT.toName());
		Config.put(configSetup.HIDEENCHANTMENT.toNameLower(), configSetup.HIDEENCHANTMENT.toName());
		Config.put(configSetup.INGREDIENT1_NUMBER_MAX.toNameLower(), configSetup.INGREDIENT1_NUMBER_MAX.toName());
		Config.put(configSetup.INGREDIENT2_NUMBER_MAX.toNameLower(), configSetup.INGREDIENT2_NUMBER_MAX.toName());
		Config.put(configSetup.INGREDIENT3_NUMBER_MAX.toNameLower(), configSetup.INGREDIENT3_NUMBER_MAX.toName());
		Config.put(configSetup.ISBLOCKED.toNameLower(), configSetup.ISBLOCKED.toName());
		Config.put(configSetup.ISMESSAGEENTER.toNameLower(), configSetup.ISMESSAGEENTER.toName());
		Config.put(configSetup.ISMESSAGELEFT.toNameLower(), configSetup.ISMESSAGELEFT.toName());
		Config.put(configSetup.ISSENDBROADCASTCOLLECT.toNameLower(), configSetup.ISSENDBROADCASTCOLLECT.toName());
		Config.put(configSetup.NOTBROADCASTPLAYERFIRSTSTART.toNameLower(), configSetup.NOTBROADCASTPLAYERFIRSTSTART.toName());
		Config.put(configSetup.MOREINGREDIENT.toNameLower(), configSetup.MOREINGREDIENT.toName());
		Config.put(configSetup.IHAVEALLINGREDIENTSINCATEGORIE.toNameLower(), configSetup.IHAVEALLINGREDIENTSINCATEGORIE.toName());
		
		return Config;
	}
	
	public static Map<String, Object> getConfigLower() {
		Map<String, Object> Config = new HashMap<String, Object>();
		Config.put(configSetup.WORLDGUARDZONE.toNameLower(), main.INSTANCE.getSettings().getWorldguardZone());
		Config.put(configSetup.HOWVERIFY.toNameLower(), main.INSTANCE.getSettings().getHowVerify());
		Config.put(configSetup.NPCNAME.toNameLower(), main.INSTANCE.getSettings().getNPCName());
		Config.put(configSetup.NPCID.toNameLower(), main.INSTANCE.getSettings().getNPCId());
		Config.put(configSetup.MATERIAL.toNameLower(), main.INSTANCE.getSettings().getMaterial());
		Config.put(configSetup.UNITE.toNameLower(), main.INSTANCE.getSettings().getUnite());
		Config.put(configSetup.DISPLAYNAME.toNameLower(), main.INSTANCE.getSettings().getDisplayName());
		Config.put(configSetup.LORE.toNameLower(), main.INSTANCE.getSettings().getLore());
		Config.put(configSetup.HASENCHANTMENT.toNameLower(), main.INSTANCE.getSettings().getHasEnchantment());
		Config.put(configSetup.HIDEENCHANTMENT.toNameLower(), main.INSTANCE.getSettings().getHideEnchantment());
		Config.put(configSetup.INGREDIENT1_NUMBER_MAX.toNameLower(), main.INSTANCE.getSettings().getIngredient1_number_max());
		Config.put(configSetup.INGREDIENT2_NUMBER_MAX.toNameLower(), main.INSTANCE.getSettings().getIngredient2_number_max());
		Config.put(configSetup.INGREDIENT3_NUMBER_MAX.toNameLower(), main.INSTANCE.getSettings().getIngredient3_number_max());
		Config.put(configSetup.ISBLOCKED.toNameLower(), main.INSTANCE.getSettings().getIsBlocked());
		Config.put(configSetup.ISMESSAGEENTER.toNameLower(), main.INSTANCE.getSettings().getIsMessageEnter());
		Config.put(configSetup.ISMESSAGELEFT.toNameLower(), main.INSTANCE.getSettings().getIsMessageLeft());
		Config.put(configSetup.ISSENDBROADCASTCOLLECT.toNameLower(), main.INSTANCE.getSettings().getIsSendBroadcastCollect());
		Config.put(configSetup.NOTBROADCASTPLAYERFIRSTSTART.toNameLower(), main.INSTANCE.getSettings().getNotBroadcastPlayerFirstStart());
		Config.put(configSetup.MOREINGREDIENT.toNameLower(), main.INSTANCE.getSettings().getMoreIngredient());
		Config.put(configSetup.IHAVEALLINGREDIENTSINCATEGORIE.toNameLower(), main.INSTANCE.getSettings().getIhaveAllIngredientsInCategories());
		
		return Config;
	}
}
