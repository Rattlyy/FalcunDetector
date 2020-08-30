package it.rattly.FalcunDetector;

import it.rattly.FalcunDetector.commands.CheckCommand;
import it.rattly.FalcunDetector.listeners.PlayerListener;
import it.rattly.FalcunDetector.profile.Profile;
import it.rattly.FalcunDetector.profile.ProfileManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class FalcunDetector extends JavaPlugin {

    @Getter
    private static ProfileManager profileManager;

    @Override
    public void onEnable() {
        profileManager = new ProfileManager();
        getServer().getMessenger().registerIncomingPluginChannel(this, "FALCUN-CLIENT", ((channel, p, message) -> {
            if(profileManager.getProfile(p.getUniqueId()) != null) {
                profileManager.removeProfile(p.getUniqueId());
                profileManager.addProfile(p.getUniqueId(), new Profile(p.getUniqueId(), true));
            } else {
                profileManager.addProfile(p.getUniqueId(), new Profile(p.getUniqueId(), true));
            }
        }));
        getCommand("checkfalcun").setExecutor(new CheckCommand());
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getLogger().info("[FalcunDetector] Plugin Loaded; By Rattly");
    }
}
