package fr.margotfille.cdeqc;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import de.netzkronehd.WGRegionEvents.events.RegionEnterEvent;
import fr.margotfille.cdeqc.utils.ServerQuest;
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;
import net.citizensnpcs.api.npc.NPC;

public class PlayerEnterListener implements Listener {
	@EventHandler
	public void onRegionEnter(RegionEnterEvent e) throws Exception {

		Player p = e.getPlayer();

		if(p instanceof NPC) {
			return;
		}

		String regionName = e.getRegion().getId();

		if(regionName.equalsIgnoreCase(main.INSTANCE.getSettings().getWorldguardZone())) {
			main.PlayerInDungeon.add(p);

			if(main.INSTANCE.getSettings().getIsMessageEnter() == true) {
				ServerQuest.sendMessagePlayers(Lang.PLAYER_ENTER_MESSAGE.get()
						.replace(LangValues.PLAYER.toName(), p.getName())
						.replace(LangValues.DUNGEONS_NAME.toName(), regionName));
			}
		}
	}
}
