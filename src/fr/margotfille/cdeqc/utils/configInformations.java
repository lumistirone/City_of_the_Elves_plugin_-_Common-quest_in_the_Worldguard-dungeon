package fr.margotfille.cdeqc.utils;

import java.util.HashMap;
import java.util.Map;

public enum configInformations {
	WORLDGUARDZONE("The Dungeon Worldguard Zone."),
	HOWVERIFY("Put 'name' if you want to detect the npc with his name. \n#Put 'id' if you want to detect the npc with his id. \n#Put 'all' if you want to detect the npc with his id and name."),
	NPCNAME("The name of the NPC."),
	NPCID("The Id of the NPC."),
	MATERIAL("The Material of the Object."),
	UNITE("The number of Objects."),
	DISPLAYNAME("The DisplayName of Object."),
	LORE("The Lore of Object."),
	HASENCHANTMENT("If it's true, the object have a enchantment."),
	HIDEENCHANTMENT("If it's true, the enchantment is hide."),
	INGREDIENT1_NUMBER_MAX("The maximum number of ingredients 1."),
	INGREDIENT2_NUMBER_MAX("The maximum number of ingredients 2."),
	INGREDIENT3_NUMBER_MAX("The maximum number of ingredients 3."),
	ISBLOCKED("If it's true, nobody can do the quest. The quest is blocked."),
	ISMESSAGEENTER("If it's true, you activate the dungeon enter message."),
	ISMESSAGELEFT("If it's true, you activate the dungeon left message."),
	ISSENDBROADCASTCOLLECT("If it's true, a broadcast is performed on the Dungeon chat when a player ended the quest."),
	NOTBROADCASTPLAYERFIRSTSTART("If it's true, the dungeon entrance broadcast will be sent to the clicker player."),
	MOREINGREDIENT("If it's true, if a player catch a ingredient, a broadcast is displayed."),
	IHAVEALLINGREDIENTSINCATEGORIE("If it's true, if a player catch the last ingredient in a categorie, a broadcast is displayed.");
	
	private final String name;
	
	/*
	 * Constructor
	 */
	configInformations(String name) {
		this.name = name;
	}
	
	/*
	 * Get LangValues
	 */
	public String toName() {
		return "§8#" + name;
	}
	
	public static Map<String, Object> getInformations() {
		Map<String, Object> Config = new HashMap<String, Object>();
		Config.put(configSetup.WORLDGUARDZONE.toNameLower(), configInformations.WORLDGUARDZONE.toName());
		Config.put(configSetup.HOWVERIFY.toNameLower(), configInformations.HOWVERIFY.toName());
		Config.put(configSetup.NPCNAME.toNameLower(), configInformations.NPCNAME.toName());
		Config.put(configSetup.NPCID.toNameLower(), configInformations.NPCID.toName());
		Config.put(configSetup.MATERIAL.toNameLower(), configInformations.MATERIAL.toName());
		Config.put(configSetup.UNITE.toNameLower(), configInformations.UNITE.toName());
		Config.put(configSetup.DISPLAYNAME.toNameLower(), configInformations.DISPLAYNAME.toName());
		Config.put(configSetup.LORE.toNameLower(), configInformations.LORE.toName());
		Config.put(configSetup.HASENCHANTMENT.toNameLower(), configInformations.HASENCHANTMENT.toName());
		Config.put(configSetup.HIDEENCHANTMENT.toNameLower(), configInformations.HIDEENCHANTMENT.toName());
		Config.put(configSetup.INGREDIENT1_NUMBER_MAX.toNameLower(), configInformations.INGREDIENT1_NUMBER_MAX.toName());
		Config.put(configSetup.INGREDIENT2_NUMBER_MAX.toNameLower(), configInformations.INGREDIENT2_NUMBER_MAX.toName());
		Config.put(configSetup.INGREDIENT3_NUMBER_MAX.toNameLower(), configInformations.INGREDIENT3_NUMBER_MAX.toName());
		Config.put(configSetup.ISBLOCKED.toNameLower(), configInformations.ISBLOCKED.toName());
		Config.put(configSetup.ISMESSAGEENTER.toNameLower(), configInformations.ISMESSAGEENTER.toName());
		Config.put(configSetup.ISMESSAGELEFT.toNameLower(), configInformations.ISMESSAGELEFT.toName());
		Config.put(configSetup.ISSENDBROADCASTCOLLECT.toNameLower(), configInformations.ISSENDBROADCASTCOLLECT.toName());
		Config.put(configSetup.NOTBROADCASTPLAYERFIRSTSTART.toNameLower(), configInformations.NOTBROADCASTPLAYERFIRSTSTART.toName());
		Config.put(configSetup.MOREINGREDIENT.toNameLower(), configInformations.MOREINGREDIENT.toName());
		Config.put(configSetup.IHAVEALLINGREDIENTSINCATEGORIE.toNameLower(), configInformations.IHAVEALLINGREDIENTSINCATEGORIE.toName());
		
		return Config;
	}
}
