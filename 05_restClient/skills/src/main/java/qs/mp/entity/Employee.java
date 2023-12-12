package qs.mp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private List<Integer> skillIds;

    public Employee(Integer id, String firstName, String lastName, List<Integer> skillIds) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skillIds = skillIds;
    }
}
