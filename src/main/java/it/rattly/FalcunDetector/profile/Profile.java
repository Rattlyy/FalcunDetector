package it.rattly.FalcunDetector.profile;

import lombok.Data;

import java.util.UUID;

@Data
public class Profile {

    private UUID uuid;
    private boolean falcun;

    public Profile(UUID uuid, boolean falcun) {
        this.uuid = uuid;
        this.falcun = falcun;
    }
}
