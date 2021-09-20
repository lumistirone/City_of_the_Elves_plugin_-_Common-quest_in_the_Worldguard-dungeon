package fr.margotfille.cdeqc.events;

import java.util.Set;

import org.bukkit.Bukkit;

import com.sk89q.worldedit.util.Location;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.session.MoveType;
import com.sk89q.worldguard.session.Session;
import com.sk89q.worldguard.session.handler.Handler;

import fr.margotfille.cdeqc.main;

public class CrossBoundaryListener extends Handler {

	public static final Factory FACTORY = new Factory();

    public static class Factory extends Handler.Factory<CrossBoundaryListener> {
        @Override
        public CrossBoundaryListener create(Session session) {
            return new CrossBoundaryListener(session);
        }
    }

    public CrossBoundaryListener(Session session) {
        super(session);
    }

    @Override
    public boolean onCrossBoundary(LocalPlayer player, Location from, Location to, ApplicableRegionSet toSet,
                                   Set<ProtectedRegion> entered, Set<ProtectedRegion> exited, MoveType moveType) {
        entered.forEach((enterR) -> {
            Bukkit.getScheduler().runTaskLater(main.INSTANCE, () -> Bukkit.getPluginManager().callEvent(new RegionEnterEvent(Bukkit.getPlayer(player.getUniqueId()),enterR)), 1L);
        });

        exited.forEach((leftR) -> {
            Bukkit.getScheduler().runTaskLater(main.INSTANCE, () -> Bukkit.getPluginManager().callEvent(new RegionLeftEvent(Bukkit.getPlayer(player.getUniqueId()),leftR)), 1L);
        });
        return true;
    }
}
