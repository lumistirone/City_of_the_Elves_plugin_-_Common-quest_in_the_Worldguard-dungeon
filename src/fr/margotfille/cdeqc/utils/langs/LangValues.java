package fr.margotfille.cdeqc.utils.langs;

public enum LangValues {
	PLAYER("player"),
	DUNGEONS_NAME("dungeons-name"),
	NPC_NAME("npc-name"),
	INGREDIENT_NAME("ingredient-name"),
	QUANTITY("quantity");
	
	private String name;
	
	LangValues(String name) {
		this.name = name;
	}
	
	public String toName() {
		return "{" + name + "}";
	}
}
