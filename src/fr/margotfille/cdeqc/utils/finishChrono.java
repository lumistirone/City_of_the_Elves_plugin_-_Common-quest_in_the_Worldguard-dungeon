package fr.margotfille.cdeqc.utils;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.margotfille.cdeqc.main;
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;

public class finishChrono extends BukkitRunnable{
	
	public int time = main.INSTANCE.getSettings().getFinishTick();
	public Player p;
	
	public finishChrono(Player player) {
		this.p = player;
	}
	
	@Override
	public void run() {
		time--;

		if(time == 0) {
			if(main.INSTANCE.getSettings().getIsSendBroadcastCollect() == true) ServerQuest.sendMessagePlayers(Lang.FINISH_BROADCAST.get().replace(LangValues.PLAYER.toName(), p.getName()).replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
			this.cancel();
		}
	}
}
