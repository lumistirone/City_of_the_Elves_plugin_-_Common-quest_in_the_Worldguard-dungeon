package fr.margotfille.cdeqc;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import fr.margotfille.cdeqc.events.RegionEnterEvent;
import fr.margotfille.cdeqc.utils.QuestState;
import fr.margotfille.cdeqc.utils.ServerQuest;
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;

public class RegionEnterListener implements Listener {
	@EventHandler
	public void onRegionEnter(RegionEnterEvent e) {
		Player p = e.getPlayer();
		String regionName = e.getRegion().getId();
		
        if(regionName.equalsIgnoreCase(main.INSTANCE.getSettings().getWorldguardZone())) {
			if(main.INSTANCE.getSettings().getIsMessageEnter() == true) {
				p.sendMessage(Lang.PLAYER_ENTER_MESSAGE.get()
						.replace(LangValues.PLAYER.toName(), p.getName())
						.replace(LangValues.DUNGEONS_NAME.toName(), regionName)
						.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
				
				if(!(main.PlayerInDungeon.isEmpty())) {
					for(Player players : main.PlayerInDungeon) {
						if(players != p) {
							players.sendMessage(Lang.PLAYER_ENTER_MESSAGE.get()
		    						.replace(LangValues.PLAYER.toName(), p.getName())
		    						.replace(LangValues.DUNGEONS_NAME.toName(), regionName)
		    						.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
						}
    				}
				}
			}
			
			if(ServerQuest.isState(QuestState.START) || ServerQuest.isState(QuestState.COLLECT)) {
				main.INSTANCE.createBoard(p);
				main.INSTANCE.start(p);
			}
			
			main.PlayerInDungeon.add(p);
		}
	}
}
