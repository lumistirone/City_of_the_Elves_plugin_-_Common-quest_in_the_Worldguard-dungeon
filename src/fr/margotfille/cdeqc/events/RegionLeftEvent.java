package fr.margotfille.cdeqc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class RegionLeftEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	 
	Player player; 
	ProtectedRegion region;

	public RegionLeftEvent(Player player, ProtectedRegion region) {
		this.player = player;
		this.region = region;
	}

	public Player getPlayer() {
		return player;
	}
	    
	public ProtectedRegion getRegion() {
		return region;
	}
	    
	public ProtectedRegion getProtectedRegion() {
		return region;
	}
	    
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
