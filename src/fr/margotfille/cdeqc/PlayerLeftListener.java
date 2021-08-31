package fr.margotfille.cdeqc;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import de.netzkronehd.WGRegionEvents.events.RegionLeftEvent;
import fr.margotfille.cdeqc.utils.ServerQuest;
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;

public class PlayerLeftListener implements Listener {

	@EventHandler
	public void onRegionLeft(RegionLeftEvent e) throws Exception{
		Player p = e.getPlayer();
		String regionName = e.getRegion().getId();

		/*
		 * Worldguard zone left management
		 */
		if(regionName.equalsIgnoreCase(main.INSTANCE.getSettings().getWorldguardZone())) {
			if(main.INSTANCE.getSettings().getIsMessageLeft() == true) {
				ServerQuest.sendMessagePlayers(Lang.PLAYER_LEFT_MESSAGE.get()
						.replace(LangValues.PLAYER.toName(), p.getName())
						.replace(LangValues.DUNGEONS_NAME.toName(), regionName)
						.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
			}
			
			main.PlayerInDungeon.remove(p);
		}
	}
}
