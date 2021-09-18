package fr.margotfille.cdeqc.utils.langs;

public enum LangValues {
	/*
	 * LangValues
	 */
	PLAYER("player"),
	DUNGEONS_NAME("dungeons-name"),
	NPC_NAME("npc-name"),
	INGREDIENT_NAME("ingredient-name"),
	QUANTITY("quantity"),
	MAX_QUANTITY("max-quantity");
	
	private final String name;
	
	/*
	 * Constructor
	 */
	LangValues(String name) {
		this.name = name;
	}
	
	/*
	 * Get LangValues
	 */
	public String toName() {
		return "{" + name + "}";
	}
}
