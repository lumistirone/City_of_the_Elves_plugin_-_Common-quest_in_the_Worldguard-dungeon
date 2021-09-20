package fr.margotfille.cdeqc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class RegionEnterEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final ProtectedRegion protectedRegion;

    public RegionEnterEvent(Player player, ProtectedRegion protectedRegion) {
    	this.player = player;
    	this.protectedRegion = protectedRegion;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}


	public Player getPlayer() {
		return player;
	}

	public ProtectedRegion getRegion() {
		return protectedRegion;
	}

	public ProtectedRegion getProtectedRegion() {
		return protectedRegion;
	}
}
