package fr.margotfille.cdeqc.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.margotfille.cdeqc.main;
import fr.margotfille.cdeqc.utils.langs.ChatColorPlayer;
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;

public class startChrono extends BukkitRunnable{
	
	public int time = main.INSTANCE.getSettings().getStartTick();
	public Player p;
	
	public startChrono(Player player) {
		this.p = player;
	}
	
	@Override
	public void run() {
		time--;
		
		if(time == 0) {
			if(!(main.PlayerInDungeon.isEmpty()) || !(main.PlayerInDungeon == null)) {
				for(Player players : main.PlayerInDungeon) {
					ChatColorPlayer plc = new ChatColorPlayer(players);
					
					if(main.INSTANCE.getSettings().getNotBroadcastPlayerFirstStart() == true) {
						plc.sendMessage(Lang.BROADCAST_FIRST.get()
								.replace(LangValues.PLAYER.toName(), p.getName())
								.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
					} 
					
					if(main.INSTANCE.getSettings().getNotBroadcastPlayerFirstStart() == false && p != players) {
						plc.sendMessage(Lang.BROADCAST_FIRST.get()
								.replace(LangValues.PLAYER.toName(), p.getName())
								.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
					}
				}

				ServerQuest.playSoundPlayers(Sound.BLOCK_NOTE_BLOCK_GUITAR);
			}
			this.cancel();
		}
	}
}
