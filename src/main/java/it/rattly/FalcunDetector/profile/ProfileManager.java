package it.rattly.FalcunDetector.profile;

import java.util.HashMap;
import java.util.UUID;

public class ProfileManager {
    private HashMap<UUID, Profile> map;

    public ProfileManager() {
        this.map = new HashMap<>();
    }

    public Profile getProfile(UUID uuid) {
        return this.map.get(uuid);
    }

    public void addProfile(UUID uuid, Profile pf) {
        this.map.put(uuid, pf);
    }

    public void removeProfile(UUID uuid) {
        this.map.remove(uuid);
    }
}
