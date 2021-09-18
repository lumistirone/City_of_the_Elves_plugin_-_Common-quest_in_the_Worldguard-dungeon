package fr.margotfille.cdeqc;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import fr.margotfille.cdeqc.utils.QuestFiles;
import fr.margotfille.cdeqc.utils.QuestState;
import fr.margotfille.cdeqc.utils.ServerQuest;
import fr.margotfille.cdeqc.utils.finishChrono;
import fr.margotfille.cdeqc.utils.startChrono;
import fr.margotfille.cdeqc.utils.langs.ChatColorPlayer;
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;

public class NPCRightClickListener implements Listener {

	@EventHandler
	public void onNPCRightClick(NPCRightClickEvent e) {
		Player p = e.getClicker();
		NPC entity = e.getNPC();
		int NPCId = entity.getId();
		String NPCName = entity.getName();
		ChatColorPlayer cp = new ChatColorPlayer(p);
		
		/*
		 * NPC verification
		 */
		if(main.INSTANCE.getSettings().getHowVerify().equalsIgnoreCase("name") || main.INSTANCE.getSettings().getHowVerify().equalsIgnoreCase("NPCname") || main.INSTANCE.getSettings().getHowVerify().equalsIgnoreCase("NPC_name")) {
			if(!(NPCName.equals(main.INSTANCE.getSettings().getNPCName()))) return;
		} else if(main.INSTANCE.getSettings().getHowVerify().equalsIgnoreCase("Id") || main.INSTANCE.getSettings().getHowVerify().equalsIgnoreCase("NPCId") || main.INSTANCE.getSettings().getHowVerify().equalsIgnoreCase("NPC_Id")) {
			if(NPCId != main.INSTANCE.getSettings().getNPCId()) return;
		} else {
			if(NPCId != main.INSTANCE.getSettings().getNPCId() || !NPCName.equalsIgnoreCase(main.INSTANCE.getSettings().getNPCName())) return;
		}
		
		/*
		 * If the quest is blocked
		 */
		if(main.INSTANCE.getSettings().getIsBlocked()) {
			cp.sendMessage(Lang.QUEST_BLOCKED.get()
					.replace(LangValues.PLAYER.toName(), p.getName())
					.replace(LangValues.NPC_NAME.toName(), NPCName));
			return;
		}
		
		/*
		 * If the quest isn't start
		 */
		if(ServerQuest.isState(QuestState.NOTSTART)) {
			new startChrono(p).runTaskTimer(main.getINSTANCE(), 0L, 1L);
			
			cp.sendMessage(Lang.MSG_FIRST.get()
					.replace(LangValues.PLAYER.toName(), p.getName())
					.replace(LangValues.NPC_NAME.toName(), NPCName));
			ServerQuest.setState(QuestState.START);
			
			if(!Bukkit.getOnlinePlayers().isEmpty())
				for(Player online : Bukkit.getOnlinePlayers()) {
					main.INSTANCE.createBoard(online);
					main.INSTANCE.start(online);
				}
			

			return;
		}

		/*
		 * If the quest is start
		 */
		if(ServerQuest.isState(QuestState.START)) {
			cp.sendMessage(Lang.START_MSG.get()
					.replace(LangValues.PLAYER.toName(), p.getName())
					.replace(LangValues.NPC_NAME.toName(), NPCName));
			
			return;
		}
		
		/*
		 * If all ingredients have been found
		 */
		cp.sendMessage(Lang.FINISH_MSG.get()
				.replace(LangValues.PLAYER.toName(), p.getName())
				.replace(LangValues.NPC_NAME.toName(), NPCName));
		
		new finishChrono(p).runTaskTimer(main.getINSTANCE(), 0L, 1L);
		
		p.getInventory().addItem(ServerQuest.createItem(main.INSTANCE.getSettings().getMaterial(), main.INSTANCE.getSettings().getUnite(), main.INSTANCE.getSettings().getDisplayName(), main.INSTANCE.getSettings().getLore(), Enchantment.LUCK, 1, main.INSTANCE.getSettings().getHideEnchantment()));
		
		try {
			QuestFiles configname = QuestFiles.CONFIG;
			File configFile = configname.getFile();
			FileConfiguration config = configname.getConfig();
			config.set("IsBlocked", true);
			config.save(configFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		main.INSTANCE.getSettings().setIsBlocked(true);
		
		/*
		 * Yaml yaml = new Yaml();
		 * InputStream inputStream = this.getClass()
		 *  .getClassLoader()
		 *  .getResourceAsStream(QuestFiles.getInstanceFiles().getFileName());
		 * Settings customer = yaml.load(inputStream);
		 */
		
		return;
		
	}
}