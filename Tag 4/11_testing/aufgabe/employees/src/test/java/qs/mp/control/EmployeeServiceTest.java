package qs.mp.control;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qs.mp.entity.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee("John", "Doe", new ArrayList<>());
        employeeService.addEmployee(employee);
        Assertions.assertTrue(employeeService.getEmployees().contains(employee));
    }

    @Test
    public void testRemoveEmployee() {
        Employee employee = new Employee("Jane", "Smith", new ArrayList<>());
        employeeService.addEmployee(employee);
        employeeService.removeEmployee(employee);
        Assertions.assertFalse(employeeService.getEmployees().contains(employee));
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee("Max", "Mustermann", new ArrayList<>());
        employeeService.addEmployee(employee);
        Employee retrievedEmployee = employeeService.getEmployeeById(employee.getId());
        Assertions.assertEquals(employee, retrievedEmployee);
    }

    @Test
    public void testGetEmployeeSkills() {
        Employee employee = new Employee("Alice", "Johnson", Arrays.asList(1, 2, 3));
        employeeService.addEmployee(employee);
        List<Integer> skills = employeeService.getEmployeeSkills(employee.getId());
        Assertions.assertEquals(employee.getSkillIds(), skills);
    }

    @Test
    public void testAddEmployeeSkill() {
        Employee employee = new Employee("Bob", "Williams", new ArrayList<>());
        employeeService.addEmployee(employee);
        Integer skillId = 1;
        employeeService.addEmployeeSkill(employee.getId(), skillId);
        Assertions.assertTrue(employee.getSkillIds().contains(skillId));
    }

    @Test
    public void testGetEmployeeBySkillId() throws InterruptedException {
        Integer skillId = 1;
        List<Employee> employees = employeeService.getEmployeeBySkillId(skillId);
        Assertions.assertEquals(1, employees.size());
        Employee employee = employees.get(0);
        Assertions.assertEquals(skillId, employee.getSkillIds().get(0));
    }
}