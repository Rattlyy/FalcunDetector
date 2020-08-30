package it.rattly.FalcunDetector.API;

import it.rattly.FalcunDetector.FalcunDetector;

import java.util.UUID;

public class API {

    public static boolean isFalcun(UUID uuid) {
        return FalcunDetector.getProfileManager().getProfile(uuid).isFalcun();
    }

}
