package qs.mp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "Employee", description = "POJO that represents an employee.")
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
