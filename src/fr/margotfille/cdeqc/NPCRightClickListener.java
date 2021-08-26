package fr.margotfille.cdeqc;

import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import fr.margotfille.cdeqc.utils.QuestState;
import fr.margotfille.cdeqc.utils.ServerQuest;
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.md_5.bungee.api.ChatColor;

public class NPCRightClickListener implements Listener {

	@EventHandler
	public void onNPCRightClick(NPCRightClickEvent e) throws Exception {
		Player p = e.getClicker();
		NPC entity = e.getNPC();
		int NPCId = entity.getId();
		String NPCName = entity.getName();

		if(main.INSTANCE.getSettings().getHowVerify().equalsIgnoreCase("name") || main.INSTANCE.getSettings().getHowVerify().equalsIgnoreCase("NPCname") || main.INSTANCE.getSettings().getHowVerify().equalsIgnoreCase("NPC_name")) {
			if(!(NPCName.equals(main.INSTANCE.getSettings().getNPCName()))) {
				return;
			}
		} else if(main.INSTANCE.getSettings().getHowVerify().equalsIgnoreCase("Id") || main.INSTANCE.getSettings().getHowVerify().equalsIgnoreCase("NPCId") || main.INSTANCE.getSettings().getHowVerify().equalsIgnoreCase("NPC_Id")) {
			if(NPCId != main.INSTANCE.getSettings().getNPCId()) {
				return;
			}
		} else {
			if(NPCId != main.INSTANCE.getSettings().getNPCId() || !NPCName.equalsIgnoreCase(main.INSTANCE.getSettings().getNPCName())) {
				return;
			}
		}

		if(main.INSTANCE.getSettings().getIsBlocked()) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', Lang.QUEST_BLOCKED.get()
					.replace(LangValues.PLAYER.toName(), p.getName())
					.replace(LangValues.NPC_NAME.toName(), NPCName)));
			return;
		}

		if(ServerQuest.isState(QuestState.NOTSTART)) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', Lang.MSG_FIRST.get()
					.replace(LangValues.PLAYER.toName(), p.getName())
					.replace(LangValues.NPC_NAME.toName(), NPCName)));
			ServerQuest.setState(QuestState.START);
			if(!(main.PlayerInDungeon.isEmpty()) || !(main.PlayerInDungeon == null)) {
				for(Player players : main.PlayerInDungeon) {
					if(main.INSTANCE.getSettings().getNotBroadcastPlayerFirstStart() == true) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', Lang.BROADCAST_FIRST.get()
								.replace(LangValues.PLAYER.toName(), p.getName())
								.replace(LangValues.NPC_NAME.toName(), NPCName)));
						return;
					}

					if(p != players) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', Lang.BROADCAST_FIRST.get()
								.replace(LangValues.PLAYER.toName(), p.getName())
								.replace(LangValues.NPC_NAME.toName(), NPCName)));
						return;
					}
				}

				for(Player players : main.PlayerInDungeon) {
					players.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_GUITAR, 1F, 1F);
				}
			}

			return;
		}

		if(ServerQuest.isState(QuestState.START)) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', Lang.START_MSG.get()
					.replace(LangValues.PLAYER.toName(), p.getName())
					.replace(LangValues.NPC_NAME.toName(), NPCName)));
			
			return;
		}

		p.sendMessage(ChatColor.translateAlternateColorCodes('&', Lang.FINISH_MSG.get()
				.replace(LangValues.PLAYER.toName(), p.getName())
				.replace(LangValues.NPC_NAME.toName(), NPCName)));

		if(main.INSTANCE.getSettings().getIsSendBroadcastCollect() == true) {
			ServerQuest.sendMessagePlayers(Lang.FINISH_BROADCAST.get()
					.replace(LangValues.PLAYER.toName(), p.getName())
					.replace(LangValues.NPC_NAME.toName(), NPCName));
		}

		p.getInventory().addItem(ServerQuest.createItem(main.INSTANCE.getSettings().getMaterial(), main.INSTANCE.getSettings().getUnite(), main.INSTANCE.getSettings().getDisplayName(), main.INSTANCE.getSettings().getLore(), Enchantment.LUCK, 1, main.INSTANCE.getSettings().getHideEnchantment()));

		main.INSTANCE.getSettings().setIsBlocked(true);
		return;
		
	} 
}