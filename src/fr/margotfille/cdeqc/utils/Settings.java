package fr.margotfille.cdeqc.utils;

import org.bukkit.Material;

public class Settings {
	private String HowVerify;
	private String WorldguardZone;
	private String NPCName;
	private int NPCId;
	private int Ingredient1_number_max;
	private int Ingredient2_number_max;
	private int Ingredient3_number_max;
	private boolean AnnonceFullIngredientInCategorie;
	private boolean BeforeHaveAll;
	private boolean BeforeHaveAllInCategorie;
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
	
	public Boolean getBeforeHaveAllInCategorie() {
		return BeforeHaveAllInCategorie;
	}
	
	public void setBeforeHaveAllInCategorie(Boolean BeforeHaveAllInCategorie) {
		this.BeforeHaveAllInCategorie = BeforeHaveAllInCategorie;
	}
	
	public Boolean getAnnonceFullIngredientInCategorie() {
		return AnnonceFullIngredientInCategorie;
	}
	
	public void setAnnonceFullIngredientInCategorie(Boolean AnnonceFullIngredientInCategorie) {
		this.AnnonceFullIngredientInCategorie = AnnonceFullIngredientInCategorie;
	}
	
	public Boolean getBeforeHaveAll() {
		return BeforeHaveAll;
	}
	
	public void setBeforeHaveAll(Boolean BeforeHaveAll) {
		this.BeforeHaveAll = BeforeHaveAll;
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
}