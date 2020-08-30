package it.rattly.FalcunDetector.listeners;

import it.rattly.FalcunDetector.FalcunDetector;
import it.rattly.FalcunDetector.profile.Profile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRegisterChannelEvent;
import org.bukkit.event.player.PlayerUnregisterChannelEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(FalcunDetector.getProfileManager().getProfile(p.getUniqueId()) == null) {
            FalcunDetector.getProfileManager().addProfile(p.getUniqueId(), new Profile(p.getUniqueId(), false));
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        FalcunDetector.getProfileManager().removeProfile(e.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onMessage(PlayerRegisterChannelEvent e) {
        if (e.getChannel().equals("FALCUN-CLIENT")) {
            Player p = e.getPlayer();
            if(FalcunDetector.getProfileManager().getProfile(p.getUniqueId()) != null) {
                FalcunDetector.getProfileManager().removeProfile(p.getUniqueId());
                FalcunDetector.getProfileManager().addProfile(p.getUniqueId(), new Profile(p.getUniqueId(), true));
            } else {
                FalcunDetector.getProfileManager().addProfile(p.getUniqueId(), new Profile(p.getUniqueId(), true));
            }
        }
    }

    @EventHandler
    public void onDisconnect(PlayerUnregisterChannelEvent e) {
        if (e.getChannel().equals("FALCUN-CLIENT")) {
            Player p = e.getPlayer();
            if(FalcunDetector.getProfileManager().getProfile(p.getUniqueId()) != null) {
                FalcunDetector.getProfileManager().removeProfile(p.getUniqueId());
                FalcunDetector.getProfileManager().addProfile(p.getUniqueId(), new Profile(p.getUniqueId(), false));
            } else {
                FalcunDetector.getProfileManager().addProfile(p.getUniqueId(), new Profile(p.getUniqueId(), false));
            }
        }
    }
}
