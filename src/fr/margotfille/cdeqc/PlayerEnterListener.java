package fr.margotfille.cdeqc;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import de.netzkronehd.WGRegionEvents.events.RegionEnterEvent;
import fr.margotfille.cdeqc.utils.QuestState;
import fr.margotfille.cdeqc.utils.ServerQuest;
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;

public class PlayerEnterListener implements Listener {
	@EventHandler
	public void onRegionEnter(RegionEnterEvent e) {
		Player p = e.getPlayer();
		String regionName = e.getRegion().getId();
		
		/*
		 * Worldguard zone enter management
		 */
		if(regionName.equalsIgnoreCase(main.INSTANCE.getSettings().getWorldguardZone())) {
			main.PlayerInDungeon.add(p);

			if(main.INSTANCE.getSettings().getIsMessageEnter() == true) {
				ServerQuest.sendMessagePlayers(Lang.PLAYER_ENTER_MESSAGE.get()
						.replace(LangValues.PLAYER.toName(), p.getName())
						.replace(LangValues.DUNGEONS_NAME.toName(), regionName)
						.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
			}
			
			if(ServerQuest.isState(QuestState.START) || ServerQuest.isState(QuestState.COLLECT)) {
				main.INSTANCE.createBoard(p);
				main.INSTANCE.start(p);
			}
		}
	}
}
