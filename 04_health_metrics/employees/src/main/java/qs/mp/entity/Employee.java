package qs.mp.entity;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {

    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int id;

    private String firstName;
    private String lastName;
    private List<Integer> skillIds;

    public Employee(String firstName, String lastName) {
        this.id = counter.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public List<Integer> getSkillIds() {
        return skillIds;
    }

    public void addSkill(Integer skillId) {
        skillIds.add(skillId);
    }

}
