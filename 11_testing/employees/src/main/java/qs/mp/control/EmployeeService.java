package qs.mp.control;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import qs.mp.entity.Employee;
import qs.mp.entity.Skill;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ApplicationScoped
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Employee with id " + id + " not found"));
    }

    public List<Integer> getEmployeeSkills(int id) {
        return getEmployeeById(id).getSkillIds();
    }

    public void addEmployeeSkill(int id, Integer skillId) {
        getEmployeeById(id).addSkill(skillId);
    }

    public List<Employee> getEmployeeBySkillId(int skillId) throws InterruptedException {
        List<Integer> ids = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        ids.add(skillId);
        Employee employee = new Employee("Max", "Mustermann", ids);
        employees.add(employee);

        return employees;
    }
}