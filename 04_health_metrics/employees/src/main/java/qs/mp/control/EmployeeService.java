package qs.mp.control;

import jakarta.enterprise.context.ApplicationScoped;
import qs.mp.entity.Employee;
import qs.mp.entity.Skill;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

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

    public List<Employee> getEmployeeBySkillId(int skillId) {
        return employees.stream()
                .filter(e -> e.getSkillIds().contains(skillId))
                .toList();
    }
}
