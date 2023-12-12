package qs.mp.control;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import qs.mp.entity.Employee;
import qs.mp.entity.Skill;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SkillService {

        List<Skill> skills = new ArrayList<>();

        @Inject
        @RestClient
        EmployeeClient employeeClient;

        public List<Skill> getAll() {
            return skills;
        }

        public Skill getById(int id){
            return skills.stream().filter(skill -> skill.getId() == id).findFirst().orElse(null);
        }

        public void create(Skill skill) {
            skills.add(skill);
        }

        public Boolean isMoreExperiencedThan(Skill skill1, Skill skill2) {
            return skill1.isMoreExperiencedThan(skill2);
        }

        public List<Skill> getEmployees(int id) {
            return skills;
        }


    public List<Employee> getEmployeesBySkillId(int id) {
            List<Integer> ids = new ArrayList<>();
            List<Employee> employees = new ArrayList<>();
            ids.add(id);
            Employee employee = new Employee(0, "Max", "Mustermann", ids);
            employees.add(employee);
            return employees;
    }
}
