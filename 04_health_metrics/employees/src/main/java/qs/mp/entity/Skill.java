package qs.mp.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Skill {

    private static final AtomicInteger counter = new AtomicInteger(0);
    private int id ;

    private String name;
    private Level level;

    public Skill(String name, Level level) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public Boolean isMoreExperiencedThan(Skill skill) {
        return this.level.ordinal() > skill.getLevel().ordinal();
    }
}
