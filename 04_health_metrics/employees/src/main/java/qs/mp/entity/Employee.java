package qs.mp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Employee {

    private static final AtomicInteger counter = new AtomicInteger(0);
    @Getter
    private final int id;

    private String firstName;
    private String lastName;
    @Getter
    private List<Integer> skillIds = new ArrayList<Integer>();

    public Employee(String firstName, String lastName, List<Integer> skillIds) {
        this.id = counter.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.skillIds = skillIds;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void addSkill(Integer skillId) {
        skillIds.add(skillId);
    }

}
