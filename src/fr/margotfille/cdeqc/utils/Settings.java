package fr.margotfille.cdeqc.utils;

import org.bukkit.Material;

public class Settings {
	
	/*
	 * Snake Yaml management (config.yml)
	 */
	private String WorldguardZone;
	private String HowVerify;
	private String NPCName;
	private int NPCId;
	private int Ingredient1_number_max;
	private int Ingredient2_number_max;
	private int Ingredient3_number_max;
	private int start_tick;
	private int finish_tick;
	
	private boolean IsBlocked;
	private boolean IsMessageEnter;
	private boolean IsMessageLeft;
	private boolean IsSendBroadcastCollect;
	private boolean NotBroadcastPlayerFirstStart;
	
	private Material material;
	private int unite;
	private String DisplayName;
	private String Lore;

	private Boolean hasEnchantment;
	private Boolean hideEnchantment;
	
	private Boolean MoreIngredient;
	private Boolean IhaveAllIngredientsInCategories;
	
	public Boolean getMoreIngredient() {
		return MoreIngredient;
	}
	
	public void setMoreIngredient(Boolean MoreIngredient) {
		this.MoreIngredient = MoreIngredient;
	}
	
	public Boolean getIhaveAllIngredientsInCategories() {
		return IhaveAllIngredientsInCategories;
	}
	
	public void setIhaveAllIngredientsInCategories(Boolean IhaveAllIngredientsInCategories) {
		this.IhaveAllIngredientsInCategories = IhaveAllIngredientsInCategories;
	}
	
	public Boolean getHideEnchantment() {
		return hideEnchantment;
	}
	
	public void setHideEnchantment(Boolean hideEnchantment) {
		this.hideEnchantment = hideEnchantment;
	}
	
	public Boolean getHasEnchantment() {
		return hasEnchantment;
	}
	
	public void setHasEnchantment(Boolean hasEnchantment) {
		this.hasEnchantment = hasEnchantment;
	}
	
	public String getLore() {
		return Lore;
	}
	
	public void setLore(String Lore) {
		this.Lore = Lore;
	}
	
	public String getDisplayName() {
		return DisplayName;
	}
	
	public void setDisplayName(String DisplayName) {
		this.DisplayName = DisplayName;
	}
	
	public int getUnite() {
		return unite;
	}
	
	public void setUnite(int unite) {
		this.unite = unite;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public String getHowVerify() {
		return HowVerify;
	}
	
	public void setHowVerify(String HowVerify) {
		this.HowVerify = HowVerify;
	}
	
	public String getWorldguardZone() {
		return WorldguardZone;
	}
	
	public void setWorldguardZone(String WorldguardZone) {
		this.WorldguardZone = WorldguardZone;
	}
	
	public String getNPCName() {
		return NPCName;
	}
	
	public void setNPCName(String NPCName) {
		this.NPCName = NPCName;
	}
	
	public int getNPCId() {
		return NPCId;
	}
	
	public void setNPCId(int NPCId) {
		this.NPCId = NPCId;
	}

	public int getIngredient1_number_max() {
		return Ingredient1_number_max;
	}
	
	public void setIngredient1_number_max(int Ingredient1_number_max) {
		this.Ingredient1_number_max = Ingredient1_number_max;
	}
	
	public int getIngredient2_number_max() {
		return Ingredient2_number_max;
	}
	
	public void setIngredient2_number_max(int Ingredient2_number_max) {
		this.Ingredient2_number_max = Ingredient2_number_max;
	}
	
	public int getIngredient3_number_max() {
		return Ingredient3_number_max;
	}
	
	public void setIngredient3_number_max(int Ingredient3_number_max) {
		this.Ingredient3_number_max = Ingredient3_number_max;
	}
	
	public Boolean getIsBlocked() {
		return IsBlocked;
	}
	
	public void setIsBlocked(Boolean IsBlocked) {
		this.IsBlocked = IsBlocked;
	}
	
	public Boolean getIsMessageEnter() {
		return IsMessageEnter;
	}
	
	public void setIsMessageEnter(Boolean IsMessageEnter) {
		this.IsMessageEnter = IsMessageEnter;
	}
	
	public Boolean getIsMessageLeft() {
		return IsMessageLeft;
	}
	
	public void setIsMessageLeft(Boolean IsMessageLeft) {
		this.IsMessageLeft = IsMessageLeft;
	}
	
	public Boolean getIsSendBroadcastCollect() {
		return IsSendBroadcastCollect;
	}
	
	public void setIsSendBroadcastCollect(Boolean IsSendBroadcastCollect) {
		this.IsSendBroadcastCollect = IsSendBroadcastCollect;
	}
	
	public Boolean getNotBroadcastPlayerFirstStart() {
		return NotBroadcastPlayerFirstStart;
	}
	
	public void setNotBroadcastPlayerFirstStart(Boolean NotBroadcastPlayerFirstStart) {
		this.NotBroadcastPlayerFirstStart = NotBroadcastPlayerFirstStart;
	}
	
	/*public void arrayGetAll(List<Object> all) {
	*	all.add(getWorldguardZone()); all.add(getHowVerify()); all.add(getNPCName()); all.add(getNPCId()); all.add(getMaterial()); all.add(getUnite()); all.add(getDisplayName()); all.add(getLore()); all.add(getHasEnchantment()); all.add(getHideEnchantment()); all.add(getIngredient1_number_max()); all.add(getIngredient2_number_max()); all.add(getIngredient3_number_max()); all.add(getIsBlocked()); all.add(getIsMessageEnter()); all.add(getIsMessageLeft())
	}*/
	
	public int getStartTick() {
		return start_tick;
	}
	
	public void setStartTick(int tick) {
		this.start_tick = tick;
	}
	
	public int getFinishTick() {
		return finish_tick;
	}
	
	public void setFinishTick(int tick) {
		this.finish_tick = tick;
	}
}