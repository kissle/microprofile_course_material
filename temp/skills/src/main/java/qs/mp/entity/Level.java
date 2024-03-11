package qs.mp.entity;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Level", description = "Enum that represents a level of experience.")
public enum Level {

    JUNIOR,
    MIDDLE,
    SENIOR;
}
