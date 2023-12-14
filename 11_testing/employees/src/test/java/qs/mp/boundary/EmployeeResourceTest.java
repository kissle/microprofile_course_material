package qs.mp.boundary;

import io.quarkus.test.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import qs.mp.control.EmployeeService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import qs.mp.entity.Employee;

import java.util.Arrays;
import java.util.List;

@QuarkusTest
public class EmployeeResourceTest {

    @InjectMock
    EmployeeService employeeService;

    @Test
    public void testGetEmployees() {
        Employee employee = new Employee("Max", "Mustermann", Arrays.asList(1, 2, 3));
        Mockito.when(employeeService.getEmployees()).thenReturn(List.of(employee));

        List<Employee> employees = employeeService.getEmployees();

        Assertions.assertEquals(1, employees.size());
        Assertions.assertEquals(employee, employees.get(0));
    }

}