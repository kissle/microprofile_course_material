package qs.mp.entity;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@Schema(name = "Skill", description = "POJO that represents a skill.")
public class Skill {

    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int id;

    @Schema(required = true, description = "Skill name")
    private String name;
    @Schema(required = true, description = "Skill level")
    private Level level;

    public Skill(String name, Level level) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.level = level;
    }

    public Boolean isMoreExperiencedThan(Skill skill) {
        return this.level.ordinal() > skill.getLevel().ordinal();
    }

}
