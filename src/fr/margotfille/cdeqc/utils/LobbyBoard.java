package fr.margotfille.cdeqc.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;

public class LobbyBoard {
	public static Map<UUID, Integer> TASKS = new HashMap<UUID, Integer>();
	private final UUID uuid;
	public LobbyBoard(UUID uuid) {
		this.uuid = uuid;
	}

	/*
	 * Set scoreboard id
	 */
	public void setID(int id) {
		TASKS.put(uuid, id);
	}
	
	/*
	 * Get scoreboard id
	 */
	public int getID() {
		return TASKS.get(uuid);
	}
	
	/*
	 * Get if the player has a ID
	 */
	public boolean hasID() {
		if(TASKS.containsKey(uuid))
			return true;
		return false;
	}
	
	/*
	 * Stop scoreboard id
	 */
	public void stop() {
		Bukkit.getScheduler().cancelTask(TASKS.get(uuid));
		TASKS.remove(uuid);
	}
}
