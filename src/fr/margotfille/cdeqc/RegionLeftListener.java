package fr.margotfille.cdeqc;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import fr.margotfille.cdeqc.events.RegionLeftEvent;
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;

public class RegionLeftListener implements Listener {
	@EventHandler
	public void onRegionLeft(RegionLeftEvent e) {
		Player p = e.getPlayer();
		String regionName = e.getRegion().getId();

		/*
		 * Worldguard zone left management
		 */
		if(regionName.equalsIgnoreCase(main.INSTANCE.getSettings().getWorldguardZone())) {
			if(main.INSTANCE.getSettings().getIsMessageLeft() == true) {
				p.sendMessage(Lang.PLAYER_LEFT_MESSAGE.get()
						.replace(LangValues.PLAYER.toName(), p.getName())
						.replace(LangValues.DUNGEONS_NAME.toName(), regionName)
						.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
				
				if(!(main.PlayerInDungeon.isEmpty())) {
					for(Player players : main.PlayerInDungeon) {
						if(p != players) {
							players.sendMessage(Lang.PLAYER_LEFT_MESSAGE.get()
									.replace(LangValues.PLAYER.toName(), p.getName())
									.replace(LangValues.DUNGEONS_NAME.toName(), regionName)
									.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));	
						}
    				}
				}
			}
			
			main.PlayerInDungeon.remove(p);
			
			if(main.PlayerInDungeon.contains(p)) {
				p.sendMessage("loul");
			}
		}
	}
}
